package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class dml_demo {

	/**
	 * 执行DML语句 DDL
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		Class.forName("oracle.jdbc.OracleDriver");
		//连接数据库
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String use = "scott";
		String pass = "123456";
		Connection conn =  DriverManager.getConnection(url,use,pass);
		Statement st = conn.createStatement();
		String dml = "insert into wei_emp (id,name,gender,job) " +
				     "values(1,'wei','M','coder') ";
		//int n = st.executeUpdate(dml);
		//System.out.println(n);   //更新的行数
		String ss = "select id, name, job from wei_emp";
		ResultSet rs = st.executeQuery(ss);
		while(rs.next()){   //移动结果集的游标到下一行
			int id = rs.getInt("id");
			String s = rs.getString("name");
			String job = rs.getString("job");
			System.out.println(id+"  "+s+"  "+job);
		}
		rs.close();
		st.close();
		conn.close();
	}

}
