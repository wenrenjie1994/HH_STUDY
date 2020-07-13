package util;

import java.sql.*;

public class DBConnection
{
	    private static final String url = "jdbc:mysql://127.0.0.1:3306/hrsys?useSSL=false";
	    private static final String name = "com.mysql.jdbc.Driver";
	    private static final String user = "root";
	    private static final String password = "dubo000000";
	    
		static
		{
			try
				{
				 Class.forName(name);
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
		public static void closeConnection(ResultSet rs,PreparedStatement statement,Connection con)
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
}
