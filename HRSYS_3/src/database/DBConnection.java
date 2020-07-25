package database;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection
{
	    static final String url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&serverTimezone=GMT%2B8";
	    static final String jdbc = "com.mysql.cj.jdbc.Driver";  
	    static final String user = "root";  
	    static final String admin = "789456";
	    Connection con = null; 
	    Statement statement= null;
	    
		static
		{
			try
				{
				 Class.forName(jdbc);//º”‘ÿjdbc«˝∂Ø 
				}
			catch(ClassNotFoundException e)
				{
					System.out.println("Class Not Found Exception:"+e.toString());
				}
		}
		public static Connection getConnection()
		{
			try {
				return DriverManager.getConnection(url,user,admin);
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		public static void closeConnection(ResultSet rs,Statement statement,Connection con)
		{
				try {
					if(rs!=null) {
						rs.close();
					}
					if(statement!=null) {
						statement.close();
					}
					if(con!=null) {
						con.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		public static void closeConnection(Statement statement,Connection con)
		{
			closeConnection(null,statement,con);
		}
}