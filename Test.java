import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class Test{
   public static void main(String[] args) {
	   try {
		   URL rssURL=new URL("http://feeds.sportsfilter.com/sportsfilter");
			rssURL.openConnection();		
			InputStreamReader in=new InputStreamReader(rssURL.openStream());
			BufferedReader buff=new BufferedReader(in);
		    StringBuilder sb=new StringBuilder();
		    String line;
		    while((line=buff.readLine())!=null){
		    	sb.append(line);
		    }
		    buff.close();
		    FileWriter fw=new FileWriter("feed4.rss");
		    BufferedWriter bw=new BufferedWriter(fw);
		    bw.write(sb.toString());
		    bw.close();
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
}

