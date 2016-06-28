
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class  SysTableReporter{
    public static void main(String[] args){
        String data="jdbc:derby://localhost:1527/sample";
        try{
            Connection conn=DriverManager.getConnection(data,"app","app");
            Statement st=conn.createStatement();
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            ResultSet rs=st.executeQuery("select * from customer");
            while(rs.next()){
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
                System.out.println(rs.getString(5));
            }
            st.close();
        }catch(SQLException se){
            System.out.println(se.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}