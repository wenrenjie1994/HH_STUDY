package work;

import database.DBConnection;
import model.ActionResult;
import model.Resume;
import model.ResumeList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	public ActionResult addResume(Resume resume)
	{ 
		int line = 0;
		ActionResult ar=new ActionResult();
		try
		{
			Connection conn =  DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String stringSql = "insert into employee values(" +
					"'"+resume.getName()+"','"+resume.getId()+"','"+resume.getSchool()+"'," +
					"'"+resume.getProcess()+"','"+resume.getDeleteStatus()+"')";
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

	public ActionResult deleteResumeById(Resume resume)
	{
		int line=0;
		ActionResult ar=new ActionResult();
		try
		{
			Connection conn = DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String stringSql ="delete from employee where id = '"+resume.getId()+"'";
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
			ar.failReason="没有找到应聘者的简历";
		}
		return ar;
	}
	//修改简历方法。
	public ActionResult changeResume(Resume resume,Resume oldresume)
	{
		int line=0;
		ActionResult ar=new ActionResult();
		try
		{
			Connection conn = DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String stringSql ="UPDATE employee SET name = '"+resume.getName()+"',id='"+resume.getId()+"', school='"+resume.getSchool()+"',process='"+resume.getProcess()+"',deletestatus='"+resume.getDeleteStatus()+"' WHERE  id= '"+oldresume.getId()+"'";
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
			ar.failReason="没有需要更新的简历";
		}
		return ar;
	}

}
