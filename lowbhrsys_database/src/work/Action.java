package work;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Resume;
import bean.ResumeList;
import database.DBConnection;

public class Action{
	final private String tableName;
	public Action(String tableName) {
		this.tableName = tableName;
	}

	//添加员工方法。
	public int addResumeInfo(Resume resume){
		int line = 0;
		try{
			Connection conn =  DBConnection.getConnection();
			Statement statement = conn.createStatement();
			String stringSql = "insert into "+tableName+" values('"+resume.getName()+"','"+resume.getId()+"','"+resume.getSchool()+"','"+resume.getProcess()+"')";
			line = statement.executeUpdate(stringSql);
			DBConnection.closeConnection(null, statement, conn);
		}
		catch(SQLException e){
			System.out.println("SQL Exception:"+e.toString());
		}
		return line;
	}

	//删除员工方法。
	public int deleteResumeByName(Resume resume){
		int line=0;
		try{
			Connection conn = DBConnection.getConnection();
			Statement statement = conn.createStatement();
			String stringSql = "delete from "+tableName+" where workerName = '"+resume.getName()+"'";
			line = statement.executeUpdate(stringSql);
			DBConnection.closeConnection(null,statement,conn);
		}
		catch(SQLException e){
			System.out.println("SQL Exception:"+e.toString());
		}
		return line;
	}

	public int deleteResumeById(Resume resume){
		int line=0;
		try{
			Connection conn = DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String stringSql = "delete from "+tableName+" where workerId = '"+resume.getId()+"'";
			line = statement.executeUpdate(stringSql);
			DBConnection.closeConnection(null,statement,conn);
		}
		catch(SQLException e){
			System.out.println("SQL Exception:"+e.toString());
		}
		return line;
	}

	//修改图书方法。
	public int changeResumeInfo(Resume resume, Resume old_resume){
		int line=0;
		try{
				Connection conn = DBConnection.getConnection();
				Statement statement = conn.createStatement();
				String stringSql = "UPDATE "+tableName+" SET workerName = '"+resume.getName()+"', workerId='"+
						resume.getId()+"',workerSchool='"+resume.getSchool()+"',recruitProcess='"+resume.getProcess()+"'WHERE workerId='"+old_resume.getId()+"'";
				line = statement.executeUpdate(stringSql);
				DBConnection.closeConnection(null,statement,conn);
			}
		catch(SQLException e){
				System.out.println("SQL Exception:"+e.toString());
			}
		return line;
	}

	//查询员工方法。
	public ResumeList searchResumeByName(Resume resume){
		ResumeList resumeList = new ResumeList();
		try{
			Connection conn =  DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String sql = "select * from "+tableName+" where workerName='"+resume.getName()+"'";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				Resume by_resume_name = new Resume(rs.getString(1), rs.getString(2),rs.getString(3),rs.getInt(4));
				resumeList.add(by_resume_name);
			}
			DBConnection.closeConnection(rs,statement,conn);
		}
		catch(SQLException e){
			System.out.println("SQL Exception:"+e.toString());
		}
		return resumeList;
	}

	public ResumeList searchResumeById(Resume resume){
		ResumeList resumeList = new ResumeList();
		try{
			
			Connection conn =  DBConnection.getConnection();
			Statement statement = conn.createStatement();
			String sql = "select * from "+tableName+" where workerId='"+resume.getId()+"'";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				Resume by_resume_id = new Resume(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
				resumeList.add(by_resume_id);
			}
			DBConnection.closeConnection(rs,statement,conn);
		}
		catch(SQLException e){
			System.out.println("SQL Exception:"+e.toString());
		}
		return resumeList;
	}

	public ResumeList searchResumeBySchool(Resume resume){
			ResumeList resumeList = new ResumeList();
		try{
			Connection conn =  DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String sql = "select * from "+tableName+" where workerSchool='"+resume.getSchool()+"'";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				Resume by_resume_school = new Resume(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
				resumeList.add(by_resume_school);
			}
			DBConnection.closeConnection(rs,statement,conn);
			return resumeList;
		}
		catch(SQLException e){
			System.out.println("SQL Exception:"+e.toString());
		}
		return null;
	}

	public ResumeList searchResumeByPointword(Resume resume){
		ResumeList resumeList = new ResumeList();
		ArrayList<ResultSet> list = new ArrayList<>();
		try(
				Connection conn = DBConnection.getConnection();
				Statement statementName = conn.createStatement();
				Statement statementSchool = conn.createStatement();
				Statement statementId = conn.createStatement();
				Statement statementProcess = conn.createStatement();
				){
			if(resume.getName()!=null || resume.getSchool()!=null){
				String sqlName = "select * from "+tableName+" where workerName like '%"+resume.getName()+"%'";
				String sqlSchool = "select * from "+tableName+" where workerSchool like '%"+resume.getSchool()+"%'";

				ResultSet rsName = statementName.executeQuery(sqlName);
				ResultSet rsSchool = statementSchool.executeQuery(sqlSchool);

				list.add(rsName);
				list.add(rsSchool);
			}
			else if(resume.getId()!=null || resume.getProcess()!=-1){
				String sqlId = "select * from "+tableName+" where workerId like '%"+resume.getId()+"%'";
				String sqlProcess = "select * from "+tableName+" where recruitProcess like '%"+resume.getProcess()+"%'";

				ResultSet rsId = statementId.executeQuery(sqlId);
				ResultSet rsProcess = statementProcess.executeQuery(sqlProcess);

				list.add(rsId);
				list.add(rsProcess);
			}
			for(ResultSet rs: list){
				while(rs.next()){
					Resume add_resume = new Resume(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
					if(!resumeList.isEmpty()){
						if (add_resume.getId().equals(resumeList.getLast().getId())){
							continue;
						}
					}
					resumeList.add(add_resume);
				}
			}
			return resumeList;
		}
		catch(SQLException e){
			System.out.println("SQL Exception:"+e.toString());
		}
		return resumeList;
	}

	public ResumeList listAllResumeInfo(){
		ResumeList resumeList = new ResumeList();
		try{
			Connection conn = DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String sql = "select * from "+tableName+"";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				Resume add_resume = new Resume(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
				resumeList.add(add_resume);
			}
			DBConnection.closeConnection(rs,statement,conn);
			return resumeList;
		}
		catch(SQLException e){
			System.out.println("SQL Exception:"+e.toString());
		}
		return resumeList;
	}
}
