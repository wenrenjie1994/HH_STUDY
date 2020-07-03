package ywcl;

import java.sql.*;

public class LoginManager {
	public static boolean login(String name, String ps) {
		Connection connect = null;
		ResultSet rs = null;
		PreparedStatement psmt = null;
		connect = DBManager.getConn();
		String sql = "select * from student where StuName = ? and StuPs = ?";

		try {
			psmt = connect.prepareStatement(sql);
			psmt.setString(1, name);
			psmt.setString(2, ps);
			rs = psmt.executeQuery();
			if (rs.next()) {
				return true;
			}
			return false;
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
		return false;
	}
	
	public static boolean login2(String name) {
		Connection connect = null;
		ResultSet rs = null;
		PreparedStatement psmt = null;
		connect = DBManager.getConn();
		String sql = "select * from student where StuName = ? ";

		try {
			psmt = connect.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();
			if (rs.next()) {
				return true;
			}
			return false;
		
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
		return false;
       
	}

	public static void main(String[] args) {
		System.out.println(login("lisi", "1"));
		System.out.println(login2("κ�"));

	}

}
