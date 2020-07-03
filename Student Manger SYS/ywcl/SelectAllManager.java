package ywcl;

import java.sql.*;
import java.util.*;

public class SelectAllManager {
	public static List getAll() {
		List list = new ArrayList();
		Connection connect = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		connect = DBManager.getConn();
		String sql = "select * from student";
		try {
			psmt = connect.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Object[] stu = new Object[4];
				stu[0] = rs.getString("StuName");
				stu[1] = rs.getString("StuPs");
				stu[2] = rs.getBytes("stuphoto");
				stu[3] = String.valueOf(rs.getDouble("stucj"));
				list.add(stu);
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
		return list;
	}
}
