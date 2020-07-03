package ywcl;

import java.sql.*;

public class CJManager {
	public static double average() {
		double stuAvg = 0;
		Connection connect = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		connect = DBManager.getConn();
		String sql = "select AVG(stuCj) from student";
		try {
			psmt = connect.prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				stuAvg = rs.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (psmt != null)
					connect.close();
				if (connect != null)
					connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return stuAvg;
	}

	public static double pass() {
		double rate = 0;
		Connection connect = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		connect = DBManager.getConn();
		String sql = "select(select count(stuCj) as a from student where stuCj>=60)*100/"+
		                       "(select count(stuCj) as b from student)from student";
      
		
				
		try {
			psmt = connect.prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				rate = rs.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (psmt != null)
					connect.close();
				if (connect != null)
					connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rate;

	}
	public static void main (String[] args){
		
		System.out.println(pass());
	}
}
