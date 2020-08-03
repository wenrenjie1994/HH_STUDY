package work;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.DBConnection;
import medol.ActionResult;
import medol.Resume;
import medol.ResumeList;

public class Action 
{
	/*
	 * 根据相应的操作向数据库传送SQL语句
	 * 通过数据库返回的受影响行数（line）和（boolean）判断操作是否成功
	 * line>0或者boolean = true为成功 令ar.isSuccess = "Success
	 * 查询图书的话令ActionResult.resultData = bookList;
	 *  反之false 并设置ActionResult.failReason
	 * 
	 * */
	//添加图书方法。
	public ActionResult addResume(Resume resume)
	{ 
		int line = 0;
		ActionResult ar = new ActionResult();
		try
		{
			Connection conn =  DBConnection.getConnection();
			Statement statement = conn.createStatement();
			String stringSql = "insert into resumes values('"+resume.getName()+"','"+resume.getId()+"','"+
					resume.getSchool()+"','"+resume.getProcess()+"')";
			line = statement.executeUpdate(stringSql);
			DBConnection.closeConnection(null,statement,conn);	
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		if(line>0)
		{
			ar.isSuccess = "Success";
		}
		else
		{
			ar.isSuccess = "false";
			ar.failReason = "添加时发生错误";
		}
		return ar;
	}
	//删除图书方法。
	public ActionResult deleteResumeByName(Resume resume)
	{
		int line = 0;
		ActionResult ar = new ActionResult();
		try
		{
			Connection conn = DBConnection.getConnection();
			Statement statement = conn.createStatement();
			String stringSql = "delete from resumes where workerName  =  '"+resume.getName()+"'";
			line = statement.executeUpdate(stringSql);
			DBConnection.closeConnection(null,statement,conn);
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		if(line>0)
		{
			ar.isSuccess = "Success";
		}
		else
		{
			ar.isSuccess = "false";
			ar.failReason = "没有找到该员工";
		}
		return ar;
	}
	public ActionResult deleteResumeById(Resume resume)
	{
		int line = 0;
		ActionResult ar = new ActionResult();
		try
		{
			Connection conn  =  DBConnection.getConnection();
			Statement statement  = conn.createStatement();
			String stringSql  = "delete from resumes where workerId  =  '"+resume.getId()+"'";
			line = statement.executeUpdate(stringSql);
			DBConnection.closeConnection(null,statement,conn);
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		if(line>0)
		{
			ar.isSuccess = "Success";
		}
		else
		{
			ar.isSuccess = "false";
			ar.failReason = "没有找到该员工";
		}
		return ar;
	}
	//修改图书方法。
	public ActionResult changeResume(Resume resume, Resume oldResume)
	{
			int line = 0;
			ActionResult ar = new ActionResult();
		try
		{
			Connection conn = DBConnection.getConnection();
			Statement statement = conn.createStatement();
			String stringSql = "UPDATE resumes SET workerName='"+resume.getName()+"', workerId='"+resume.getId()+
					"',workerSchool='"+resume.getSchool()+"', recruitProcess='"+resume.getProcess()+"' WHERE workerId = '"+oldResume.getId()+"'";
			line = statement.executeUpdate(stringSql);
			DBConnection.closeConnection(null,statement,conn);
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		if(line>0)
		{
			ar.isSuccess = "Success";
		}
		else
		{
			ar.isSuccess = "false";
			ar.failReason = "没有找到该员工";
		}
		return ar;
	}
	//查询图书方法。
	public ActionResult searchResumeByName(Resume resume)
	{
		ResumeList resumeList = new ResumeList();
		ActionResult ar = new ActionResult();
		try
		{
			Connection conn =  DBConnection.getConnection();
			Statement statement = conn.createStatement();
			String sql = "select * from resumes where workerName = '"+resume.getName()+"'";
			ResultSet rs = statement.executeQuery(sql);
			//把查询结果放到BookList的操作
			while(rs.next())
			{
				Resume aResume = new Resume(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
				resumeList.add(aResume);
			}
			DBConnection.closeConnection(rs,statement,conn);
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		int resumeSize = resumeList.size();
		if(resumeSize>0)
		{
			ar.isSuccess = "Success";
			ar.resultData = resumeList;
		}
		else
		{
			ar.isSuccess = "false";
			ar.failReason = "没有找到相关员工";
		}
		return ar;
		
	}
	
	public ActionResult searchResumeById(Resume resume)
	{
		ResumeList resumeList = new ResumeList();
		ActionResult ar = new ActionResult();
		try
		{
			Connection conn =  DBConnection.getConnection();
			Statement statement  = conn.createStatement();
			String sql  =  "select * from resumes where workerId = '"+resume.getId()+"'";
			ResultSet rs  =  statement.executeQuery(sql);
			//把查询结果放到BookList的操作
			while(rs.next())
			{
				Resume aResume = new Resume(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
				resumeList.add(aResume);
			}
			DBConnection.closeConnection(rs,statement,conn);
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		int resumeSize = resumeList.size();
		if(resumeSize>0)
		{
			ar.isSuccess = "Success";
			ar.resultData = resumeList;
		}
		else
		{
			ar.isSuccess = "false";
			ar.failReason = "没有找到相关员工";
		}
		return ar;
	}
	
	public ActionResult searchResumeBySchool(Resume resume)
	{
			ResumeList resumeList = new ResumeList();
			ActionResult ar = new ActionResult();
		try
		{
			Connection conn =  DBConnection.getConnection();
			Statement statement = conn.createStatement();
			String sql = "select * from resumes where workerSchool = '"+resume.getSchool()+"'";
			ResultSet rs = statement.executeQuery(sql);
			//把查询结果放到BookList的操作
			while(rs.next())
			{
				Resume aResume = new Resume(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
				resumeList.add(aResume);
			}
			DBConnection.closeConnection(rs,statement,conn);
			int resumeSize = resumeList.size();
			if(resumeSize>0)
			{
				ar.isSuccess = "Success";
				ar.resultData = resumeList;
			}
			else
			{
				ar.isSuccess = "false";
				ar.failReason = "没有找到相关员工";
			}
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		return ar;
	}

	public ActionResult searchResumeByProcess(Resume resume)
	{
		ResumeList resumeList = new ResumeList();
		ActionResult ar = new ActionResult();
		try
		{
			Connection conn =  DBConnection.getConnection();
			Statement statement = conn.createStatement();
			String sql = "select * from resumes where recruitProcess = '"+resume.getProcess()+"'";
			ResultSet rs = statement.executeQuery(sql);
			//把查询结果放到BookList的操作
			while(rs.next())
			{
				Resume aResume = new Resume(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
				resumeList.add(aResume);
			}
			DBConnection.closeConnection(rs,statement,conn);
			int resumeSize = resumeList.size();
			if(resumeSize>0)
			{
				ar.isSuccess = "Success";
				ar.resultData = resumeList;
			}
			else
			{
				ar.isSuccess = "false";
				ar.failReason = "没有找到相关员工";
			}
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		return ar;
	}
	
	public ActionResult searchResumeByPointWord(Resume resume)
	{
		ResumeList resumeList = new ResumeList();
		ActionResult ar = new ActionResult();
		try
		{
			Connection conn = DBConnection.getConnection();
			Statement statement = conn.createStatement();
			String sql = "select * from resumes where workerName like '%"+resume.getName()+"%'";
			ResultSet rs = statement.executeQuery(sql);
			//把查询结果放到BookList的操作
			while(rs.next())
			{
				Resume aResume = new Resume(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
				resumeList.add(aResume);
			}
			DBConnection.closeConnection(rs,statement,conn);
			int resumeSize = resumeList.size();
			if(resumeSize>0)
			{
				ar.isSuccess = "Success";
				ar.resultData = resumeList;
			}
			else
			{
				ar.isSuccess = "false";
				ar.failReason = "没有找到相关员工";
			}
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		return ar;
	}

	public ActionResult listAllInfo()
	{
		ResumeList resumeList = new ResumeList();
		ActionResult ar = new ActionResult();
		try
		{
			Connection conn =  DBConnection.getConnection();
			Statement statement = conn.createStatement();
			String sql = "select * from resumes";
			ResultSet rs = statement.executeQuery(sql);
			//把查询结果放到BookList的操作
			while(rs.next())
			{
				Resume aResume = new Resume(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
				resumeList.add(aResume);
			}
			DBConnection.closeConnection(rs,statement,conn);
			int resumeSize = resumeList.size();
			if(resumeSize>0)
			{
				ar.isSuccess = "Success";
				ar.resultData = resumeList;
			}
			else
			{
				ar.isSuccess = "false";
				ar.failReason = "没有找到相关员工";
			}
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		return ar;
	}
}
