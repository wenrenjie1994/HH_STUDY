package ywcl;

import java.io.*;

import java.sql.*;

public class AddStudentManager {
	public static boolean isAdd(String name) {
		Connection connect = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		connect = DBManager.getConn();
		String sql = "select * from student where StuName=?";
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

	public static int add(String name, String ps, File file, double cj) {
		Connection connect = null;
		PreparedStatement psmt = null;
		connect = DBManager.getConn();
		String sql = "insert into student(stuName,stuPs,stuPhoto,stuCJ) values(?,?,?,?)";
		try {
			psmt = connect.prepareStatement(sql);
			psmt.setString(1, name);
			psmt.setString(2, ps);
			//FileInputStream fis = new FileInputStream(file);
			if(file!=null){
			FileInputStream fis = new FileInputStream(file);
			psmt.setBinaryStream(3, fis, (int) file.length());
			psmt.setDouble(4, cj);
			}
			else
			psmt.setString(3,"");
			psmt.setDouble(4, cj);
			return psmt.executeUpdate();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null)
					psmt.close();
				if (connect != null)
					connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

}