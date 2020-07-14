package work;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.DBConnection;

public class Service
{
	//添加图书方法。
	public  void addbook(String abookName,String abookAuthor,Double abookPrice)
	{
		try
		{
			Connection conn =  DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String stringSql = "insert into bookmis values('"+abookName+"','"+abookAuthor+"','"+abookPrice+"')";
			statement.execute(stringSql);
			DBConnection.closeConnection(null,statement,conn);
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
	}
	//删除图书方法。
	public void deleteBook(String stringSql)
	{
		try
		{
			Connection conn = DBConnection.getConnection();
			Statement statement =conn.createStatement();
			statement.execute(stringSql);
			DBConnection.closeConnection(null,statement,conn);
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
	}
	//修改图书方法。
	public void changeBook(String oldBookName,String abookName,String abookAuthor,double abookPrice,String sql,String stringSql)
	{
		try
		{
			Connection conn = DBConnection.getConnection();
			Statement statement =conn.createStatement();
			statement.execute(sql);
			ResultSet rs = statement.executeQuery(sql);
			if(rs!=null)
			{
				statement.execute(stringSql);
				DBConnection.closeConnection(rs,statement,conn);
			}
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
	}
	//查询图书方法。
	public  void searchBook(String abookName,String sql)
	{
		try
		{
			Connection conn =  DBConnection.getConnection();
			Statement statement =conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs!=null)
			{
				System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3));
			}
			DBConnection.closeConnection(rs,statement,conn);
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
	}
}
