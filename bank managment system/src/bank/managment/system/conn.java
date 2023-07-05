
package bank.managment.system;
import java.sql.*;

public class conn {
    Connection C;
    Statement S;
    public conn(){
        try{
          C=DriverManager.getConnection("jdbc:mysql:/// systemm","root","Shivam@1234");
          S=C.createStatement();
        } catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]) {
      
    }
}
