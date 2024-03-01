package kabaddi.arena.allotment;
import java.sql.*;

public class Conn
{

    Connection c;
    Statement s;
Conn()
{
try{
Class.forName("com.mysql.cj.jdbc.Driver");
c=DriverManager.getConnection("jdbc:mysql:///kabaddiarenaallotment","root","stuphy@purkar");
s=c.createStatement();
}catch(Exception e)
{
e.printStackTrace();
}

    
}
    
}
