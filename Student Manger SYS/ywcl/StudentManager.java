package ywcl;

import java.sql.*;

public class StudentManager {
	public static Object[] select(String name) {
		Object[] stu = new Object[4];
		Connection connect = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		connect = DBManager.getConn();
		String sql = "select * from student where StuName = ?";

		try {
			psmt = connect.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();
			if (rs.next()) {
				stu[0] = rs.getString("StuName");
				stu[1] = rs.getString("StuPs");
				stu[2] = rs.getBytes("stuphoto");
				stu[3] = rs.getDouble("stucj");
				return stu;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
				if (connect != null)
					connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
