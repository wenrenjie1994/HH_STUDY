package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.commons.dbcp.BasicDataSource;

public class lianjiechi {

	/**
	 * 连接池基本用法
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		/*
		 * 第一种
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String use = "scott";
		String pass = "123456";
		BasicDataSource ds = new BasicDataSource();
		//设置必须参数
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(use);
		ds.setPassword(pass);
		//设置连接池管理策略参数
		ds.setInitialSize(2); //初始化
		ds.setMaxActive(100);
		//使用连接池中的数据库连接
		Connection conn;
		conn = ds.getConnection();
		String sql = "select 'hello' as a from dual";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()){
			String str = rs.getString("a");
			System.out.println(str);
		}			
		//归还连接到数据库连接池
		conn.close();
		*/
		//第二种
		Connection conn= null;
		try {
			conn = bingfaDbUtils.getConnection();
			String ss= "select 'hello' as a from dual";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(ss);
			while(rs.next()){
				String s2 = rs.getString("a");
				System.out.println(s2);
				
			}
			rs.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			bingfaDbUtils.close(conn);
		}
		
	}

}
