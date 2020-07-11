package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** 
*@program : dataBase\DBConnection.java
*@description : 
* @author : liudeqing4191
* @date : 2020/7/10 16:45
*/
public class DBConnection
{
	    static final String url = "jdbc:mysql://39.105.70.32:3306/resume_data";
	    static final String name = "com.mysql.jdbc.Driver";  
	    static final String user = "lowbhr";
	    static final String password = "lowbhr";
	    Connection con = null; 
	    Statement statement= null;
	    
		static
		{
			try
				{
				 Class.forName(name);//指定连接类型  
				}
			catch(ClassNotFoundException cE)
				{
					System.out.println("Class Not Found Exception:"+cE.toString());
				}
		}
		public static Connection getConnection()
		{
			try {
				return DriverManager.getConnection(url,user,password);
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
