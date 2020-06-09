package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class predemo {

	/**
	 * 利用preparedStaement实现查询
	 * @param args
	 */
	public static void main(String[] args) {
		Connection conn = null;
		try {
		    conn = bingfaDbUtils.getConnection();
			String sql = "select id,name,salary,job from wei_emp where name like ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%w%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt(1);
				String s = rs.getString(2);
				int sa = rs.getInt("salary");
				String job = rs.getString("job");
				System.out.println(id+","+s+","+sa+","+job);
			}
			rs.close();
			ps.close();
			

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			bingfaDbUtils.close(conn);
		}

	}

}
