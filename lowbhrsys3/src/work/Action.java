package work;

import bean.Candidate;
import bean.CandidateList;
import database.DBconnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Action
{

        //添加候选人
        public int addcandidate(Candidate candidate)
        {

            int line=0;

            try
            {
                Connection conn= DBconnection.getConnection();
                Statement statement=conn.createStatement();
                String stringSql="insert into candidates values ('"+candidate.getName()+"','"+candidate.getId()+"','"+
                        candidate.getSchool()+"','"+candidate.getProcess()+"')'";
                line=statement.executeUpdate(stringSql);
                DBconnection.closeConnection(null,statement,conn);

            }catch (SQLException e){
                System.out.println("SQLException e:"+e.toString());
            }
            return line;

        }
        
        //删除候选人
        public int deleteCandidate(Candidate candidate)
        {

            int line=0;
            try
            {
                Connection conn=DBconnection.getConnection();
                Statement statement=conn.createStatement();
                String stringSql="delete from candidates where name='"+candidate.getName()+"'";
                line=statement.executeUpdate(stringSql);
                DBconnection.closeConnection(null,statement,conn);
            }catch (SQLException e){
                e.toString();
            }
            return line;

        }

        //修改候选人
        public int changeCandidate(Candidate candidate)
        {
            int line=0;
            try
            {
                Connection conn=DBconnection.getConnection();
                Statement statement=conn.createStatement();
                String stringSql="UPDATE candidates SET candidateName='"+candidate.getName()+"',candidateId='"+candidate.getId()+
                        "',candidateSchool='"+candidate.getSchool()+"',candidateProcess'"+candidate.getProcess()+"' WHERE candidateName='" +
                        candidate.getName()+"'";
                line=statement.executeUpdate(stringSql);
                DBconnection.closeConnection(null,statement,conn);
            }catch (SQLException e){
                e.toString();
            }
            return line;
        }

        //查询候选人
        public CandidateList searchByName(Candidate candidate)
        {
            CandidateList candidateList=new CandidateList();
            try
            {
                Connection conn=DBconnection.getConnection();
                Statement statement=conn.createStatement();
                String stringSql="select * from candidates where candidateName='"+candidate.getName()+"'";
                ResultSet rs=statement.executeQuery(stringSql);
                while(rs.next())
                {
                    Candidate acandidate=new Candidate(rs.getString("candidateName"),rs.getString("candidateId"),rs.getString("candidateSchool"),rs.getInt("candidateId"));
                    candidateList.add(acandidate);
                }
            }catch (SQLException e){
                e.toString();
            }
            return candidateList;

        }




}
