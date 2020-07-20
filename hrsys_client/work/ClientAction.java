package work;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import bean.Resume;
import bean.ResumeList;
import database.DBConnection;
import medol.ActionResult;

public class ClientAction
{
	//添加简历方法。
//	  * * 0：已申请
//     * 1：简历通过
//     * 2：笔试通过
//     * 3：体检通过
//     * 4：背调通过
//     * 5：已签约
//     * 6：已入职
	private String [] chprocess={"已申请","简历通过","笔试通过","体检通过","背调通过","已签约","已入职"};
	public ActionResult addResume(Resume resume)
	{
		int line = 0;
		ActionResult ar = new ActionResult();

		try {
			Connection conn = DBConnection.getConnection();
			Statement statement = conn.createStatement();
			String stringSql = "insert into resume values('"+resume.getName()+"','"+resume.getId()+"','"+resume.getSchool()+chprocess[resume.getProcess()]+"')";
			line = statement.executeUpdate(stringSql);
			DBConnection.closeConnection((ResultSet)null, statement, conn);
		} catch (SQLException var7) {
			System.out.println("SQL Exception:" + var7.toString());
		}

		if (line > 0) {
			ar.isSuccess = "Success";
		} else {
			ar.isSuccess = "false";
			ar.failReason = "unknow error";
		}
		return ar;
	}
	//删除简历方法。
	public ActionResult deleteResumeById(Resume resume)
	{
		int line=0;
		ActionResult ar = new ActionResult();
		try
		{
			Connection conn = DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String stringSql ="delete from resume where id = '"+resume.getId()+"'";
			line=statement.executeUpdate(stringSql);
			DBConnection.closeConnection(null,statement,conn);
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		if (line > 0) {
			ar.isSuccess = "Success";
		} else {
			ar.isSuccess = "false";
			ar.failReason = "没有找到该简历";
		}
		return ar;
	}
	public int deleteResumeByName(Resume resume)
	{
		int line=0;
		try
		{
			System.out.println("1");
			Connection conn = DBConnection.getConnection();
			System.out.println("2");
			Statement statement =conn.createStatement();
			System.out.println("3");
			String stringSql ="delete from resumemis where resumename = '"+resume.getName()+"'";
			System.out.println("4");
			line=statement.executeUpdate(stringSql);
			System.out.println("5");
			DBConnection.closeConnection(null,statement,conn);
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		System.out.println("6");
		return line;
	}
	//修改简历方法。
	public int changeResume(Resume resume,Resume oldresume)
	{
			int line=0;
		try
			{
				Connection conn = DBConnection.getConnection();
				Statement statement =conn.createStatement();
				String stringSql ="UPDATE resumemis SET resumeId = '"+resume.getName()+"','"+resume.getSchool()+chprocess[resume.getProcess()]+"' WHERE  resumename= '"+oldresume.getName()+"'";
				line=statement.executeUpdate(stringSql);
				DBConnection.closeConnection(null,statement,conn);
			}
		catch(SQLException e)
			{
				System.out.println("SQL Exception:"+e.toString());
			}
		return line;
	}
//	//查询简历方法。
//	public  ResumeList searchResumeById(Resume resume)
//	{
//		ResumeList resumeList=new ResumeList();
//		try
//		{
//			Connection conn =  DBConnection.getConnection();
//			Statement statement =conn.createStatement();
//			String sql = "select * from resumemis where id='"+resume.getId()+"'";
//			ResultSet rs = statement.executeQuery(sql);
//			while(rs.next())
//			{
//				Resume aresume=new Resume(rs.getString("resumename"),rs.getString(2),rs.getString(3),rs.getInt(4));
//				resumeList.add(aresume);
//			}
//			DBConnection.closeConnection(rs,statement,conn);
//		}
//		catch(SQLException e)
//		{
//			System.out.println("SQL Exception:"+e.toString());
//		}
//		return resumeList;
//
//	}
//	public  ResumeList searchResumeByresumename(Resume resume)
//	{
//		ResumeList resumeList=new ResumeList();
//		try
//		{
//
//			Connection conn =  DBConnection.getConnection();
//			Statement statement =conn.createStatement();
//			String sql = "select * from resumemis where resumename='"+resume.getName()+"'";
//			ResultSet rs = statement.executeQuery(sql);
//			while(rs.next())
//			{
//				Resume aresume=new Resume(rs.getString("resumename"),rs.getString(2),rs.getString(3),rs.getInt(4));
//				resumeList.add(aresume);
//			}
//			DBConnection.closeConnection(rs,statement,conn);
//		}
//		catch(SQLException e)
//		{
//			System.out.println("SQL Exception:"+e.toString());
//		}
//		return resumeList;
//	}
//	public  ResumeList searchResumeByProcess(Resume resume)
//	{
//			ResumeList resumeList=new ResumeList();
//		try
//		{
//			Connection conn =  DBConnection.getConnection();
//			Statement statement =conn.createStatement();
//			String sql = "select * from resumemis where process='"+resume.getProcess()+"'";
//			ResultSet rs = statement.executeQuery(sql);
//			while(rs.next())
//			{
//				Resume aresume=new Resume(rs.getString("resumename"),rs.getString(2),rs.getString(3),rs.getInt(4));
//				resumeList.add(aresume);
//			}
//			DBConnection.closeConnection(rs,statement,conn);
//			return resumeList;
//		}
//		catch(SQLException e)
//		{
//			System.out.println("SQL Exception:"+e.toString());
//		}
//		return null;
//	}
//	public  ResumeList searchResumeByPointword(Resume resume)
//	{
//		ResumeList resumeList=new ResumeList();
//		try
//		{
//			Connection conn =  DBConnection.getConnection();
//			Statement statement =conn.createStatement();
//			String sql = "select * from resumemis where resumeName like '%"+resume.resumeName+"%'";
//			ResultSet rs = statement.executeQuery(sql);
//			while(rs.next())
//			{
//				Resume aresume=new Resume(rs.getString(1),rs.getString(2),rs.getDouble(3));
//				resumeList.add(aresume);
//			}
//			DBConnection.closeConnection(rs,statement,conn);
//			return resumeList;
//		}
//		catch(SQLException e)
//		{
//			System.out.println("SQL Exception:"+e.toString());
//		}
//		return resumeList;
//	}
}
