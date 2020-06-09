package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class zhurusqldemo {

	/**
	 * SQL注入操作
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String name = scan.nextLine();
		System.out.println("请输入密码：");
		String pwd = scan.nextLine();
		boolean f = login1(name,pwd);
		if(f){
			System.out.println("登陆成功！");
		}else{
			System.out.println("用户名密码错误!");
		}
		

	}
	public static boolean login(String name, String pwd){
		String sql = "select count(*) as c from wei_user " +
			 	     "where name=\'"+name+"\' "
				      +"and password=\'"+pwd+"\' ";
		Connection conn = null;
		try {
			conn = bingfaDbUtils.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				int n = rs.getInt("c");
				return n>=1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			bingfaDbUtils.close(conn);
		}
		return false;
	}
	
	public static boolean login1(String name,String pwd){
		String sql = "select count(*) as c from wei_user where name=? and password=? ";
		Connection conn = null;
		try {
			conn = bingfaDbUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				int n = rs.getInt("c");
				return n>=1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			bingfaDbUtils.close(conn);
		}
		return false;
	}

}
