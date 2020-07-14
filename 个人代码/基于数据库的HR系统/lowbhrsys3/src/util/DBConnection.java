package util;

import java.sql.*;

/**
 * jdbc连接数据库操作
 * @author 杜波
 * @version 创建时间: 2020/7/13 11:27
 */
public class DBConnection
{
	    private static final String  URL= "jdbc:mysql://127.0.0.1:3306/hrsys?useSSL=false";
	    private static final String NAME = "com.mysql.jdbc.Driver";
	    private static final String USER = "root";
	    private static final String PASSWORD = "dubo000000";
	    
		static
		{
			try
				{
				 Class.forName(NAME);
				}
			catch(ClassNotFoundException cE)
				{
					System.out.println("Class Not Found Exception:"+cE.toString());
				}
		}
		public static Connection getConnection()
		{
			try {
				return DriverManager.getConnection(URL,USER,PASSWORD);
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
