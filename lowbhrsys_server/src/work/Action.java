package work;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.DBConnection;
import medol.ActionResult;
import medol.Book;
import medol.BookList;

public class Action 
{
	/*
	 * 根据相应的操作向数据库传送SQL语句
	 * 通过数据库返回的受影响行数（line）和（boolean）判断操作是否成功
	 * line>0或者boolean=true为成功 令ar.isSuccess="Success
	 * 查询图书的话令ActionResult.resultData=bookList;
	 *  反之false 并设置ActionResult.failReason
	 * 
	 * */
	//添加图书方法。
	public ActionResult addbook(Book book)
	{ 
		int line = 0;
		ActionResult ar=new ActionResult();
		try
		{
			Connection conn =  DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String stringSql = "insert into bookmis values('"+book.bookName+"','"+book.bookAuthor+"','"+book.bookPrice+"')";
			line=statement.executeUpdate(stringSql);
			DBConnection.closeConnection(null,statement,conn);	
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		if(line>0)
		{
			ar.isSuccess="Success";
		}
		else
		{
			ar.isSuccess="false";
			ar.failReason="unknow error";
		}
		return ar;
	}
	//删除图书方法。
	public ActionResult deleteBookByName(Book book)
	{
		int line=0;
		ActionResult ar=new ActionResult();
		try
		{
			Connection conn = DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String stringSql ="delete from bookmis where bookName = '"+book.bookName+"'";
			line=statement.executeUpdate(stringSql);
			DBConnection.closeConnection(null,statement,conn);
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		if(line>0)
		{
			ar.isSuccess="Success";
		}
		else
		{
			ar.isSuccess="false";
			ar.failReason="没有找到该图书";
		}
		return ar;
	}
	public ActionResult deleteBookByAuthor(Book book)
	{
		int line=0;
		ActionResult ar=new ActionResult();
		try
		{
			Connection conn = DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String stringSql ="delete from bookmis where bookAuthor = '"+book.bookAuthor+"'";
			line=statement.executeUpdate(stringSql);
			DBConnection.closeConnection(null,statement,conn);
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		if(line>0)
		{
			ar.isSuccess="Success";
		}
		else
		{
			ar.isSuccess="false";
			ar.failReason="没有找到该图书";
		}
		return ar;
	}
	//修改图书方法。
	public ActionResult changeBook(Book book,Book oldbook)
	{
			int line=0;
			ActionResult ar=new ActionResult();
		try
			{
				Connection conn = DBConnection.getConnection();
				Statement statement =conn.createStatement();
				String stringSql ="UPDATE bookmis SET bookName = '"+book.bookName+"', bookAuthor='"+book.bookAuthor+"',bookPrice='"+book.bookPrice+"' WHERE  bookName= '"+oldbook.bookName+"'";
				line=statement.executeUpdate(stringSql);
				DBConnection.closeConnection(null,statement,conn);
			}
		catch(SQLException e)
			{
				System.out.println("SQL Exception:"+e.toString());
			}
		if(line>0)
		{
			ar.isSuccess="Success";
		}
		else
		{
			ar.isSuccess="false";
			ar.failReason="没有找到该图书";
		}
		return ar;
	}
	//查询图书方法。
	public  ActionResult searchBookByName(Book book)
	{
		BookList bookList=new BookList();
		ActionResult ar=new ActionResult();
		try
		{
			Connection conn =  DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String sql = "select * from bookmis where bookName='"+book.bookName+"'";
			ResultSet rs = statement.executeQuery(sql);
			//把查询结果放到BookList的操作
			while(rs.next())
			{
				Book abook=new Book(rs.getString(1),rs.getString(2),rs.getDouble(3));
				bookList.add(abook);
			}
			DBConnection.closeConnection(rs,statement,conn);
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		int booksize=bookList.size();
		if(booksize>0)
		{
			ar.isSuccess="Success";
			ar.resultData=bookList;
		}
		else
		{
			ar.isSuccess="false";
			ar.failReason="没有找到相关图书";
		}
		return ar;
		
	}
	public  ActionResult searchBookByAuthor(Book book)
	{
		BookList bookList=new BookList();
		ActionResult ar=new ActionResult();
		try
		{
			
			Connection conn =  DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String sql = "select * from bookmis where bookAuthor='"+book.bookAuthor+"'";
			ResultSet rs = statement.executeQuery(sql);
			//把查询结果放到BookList的操作
			while(rs.next())
			{
				Book abook=new Book(rs.getString(1),rs.getString(2),rs.getDouble(3));
				bookList.add(abook);
			}
			DBConnection.closeConnection(rs,statement,conn);
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		int booksize=bookList.size();
		if(booksize>0)
		{
			ar.isSuccess="Success";
			ar.resultData=bookList;
		}
		else
		{
			ar.isSuccess="false";
			ar.failReason="没有找到相关图书";
		}
		return ar;
	}
	public  ActionResult searchBookByPrice(Book book)
	{
			BookList bookList=new BookList();
			ActionResult ar=new ActionResult();
		try
		{
			Connection conn =  DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String sql = "select * from bookmis where bookPrice='"+book.bookPrice+"'";
			ResultSet rs = statement.executeQuery(sql);
			//把查询结果放到BookList的操作
			while(rs.next())
			{
				Book abook=new Book(rs.getString(1),rs.getString(2),rs.getDouble(3));
				bookList.add(abook);
			}
			DBConnection.closeConnection(rs,statement,conn);
			int booksize=bookList.size();
			if(booksize>0)
			{
				ar.isSuccess="Success";
				ar.resultData=bookList;
			}
			else
			{
				ar.isSuccess="false";
				ar.failReason="没有找到相关图书";
			}
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		return ar;
	}	
	public  ActionResult searchBookByPointword(Book book)
	{
		BookList bookList=new BookList();
		ActionResult ar=new ActionResult();
		try
		{
			Connection conn =  DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String sql = "select * from bookmis where bookName like '%"+book.bookName+"%'";
			ResultSet rs = statement.executeQuery(sql);
			//把查询结果放到BookList的操作
			while(rs.next())
			{
				Book abook=new Book(rs.getString(1),rs.getString(2),rs.getDouble(3));
				bookList.add(abook);
			}
			DBConnection.closeConnection(rs,statement,conn);
			int booksize=bookList.size();
			if(booksize>0)
			{
				ar.isSuccess="Success";
				ar.resultData=bookList;
			}
			else
			{
				ar.isSuccess="false";
				ar.failReason="没有找到相关图书";
			}
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		return ar;
	}
}
