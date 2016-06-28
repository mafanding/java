
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.StringBuilder;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.StringTokenizer;

public class QuoteData{
    private String ticker;

    public QuoteData(String inTicker){
        ticker=inTicker;
    }

    private String retrieveQuote(){
        StringBuilder build=new StringBuilder();
        try{
            URL page=new URL("http://download.finance.yahoo.com/d/quotes.csv?s="+ticker+"&f=sl1d1t1c1ohgv&e=.csv");
            String line;
            URLConnection conn=page.openConnection();
            conn.connect();
            InputStreamReader in=new InputStreamReader(conn.getInputStream());
            BufferedReader buff=new BufferedReader(in);
            while ((line=buff.readLine())!=null){
                build.append(line);
                build.append("\n");
            }
            buff.close();
        }catch(MalformedURLException me){
            System.out.println(me.getMessage());
        }catch(IOException ie){
            System.out.println(ie.getMessage());
        }
        return build.toString();
    }

    private void storeQuote(String data){
        StringTokenizer tokens=new StringTokenizer(data,",");
        String[] fields=new String[9];
        for(int i=0;i<fields.length;i++){
            fields[i]=stripQuotes(tokens.nextToken());
        }
        String dataSource="jdbc:derby://localhost:1527/sample";
        try{
            Connection conn=DriverManager.getConnection(dataSource, "app", "app");
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            PreparedStatement pstat=conn.prepareStatement("INSERT INTO STOCKS (TICKER,PRICE,DATE,CHANGE,LOW,HIGH,PRICEOPEN,VOLUME) VALUES (?,?,?,?,?,?,?,?)");
            pstat.setString(1, fields[0]);
            pstat.setString(2, fields[1]);
            pstat.setString(3, fields[2]);
            pstat.setString(4, fields[3]);
            pstat.setString(5, fields[4]);
            pstat.setString(6, fields[5]);
            pstat.setString(7, fields[6]);
            pstat.setString(8, fields[7]);
            pstat.executeUpdate();
            conn.close();
        }catch(SQLException se){
            System.out.println(se.getMessage());
        }catch(ClassNotFoundException ce){
            System.out.println(ce.getMessage());
        }
    }

    private String stripQuotes(String input){
        StringBuilder output=new StringBuilder();
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)!='\"'){
                output.append(input.charAt(i));
            }
        }
        return output.toString();
    }

    public static void main(String[] args){
        if(args.length<1){
            System.out.println("Error");
            System.exit(1);
        }
        QuoteData data=new QuoteData(args[0]);
        String qd=data.retrieveQuote();
        data.storeQuote(qd);
    }
}