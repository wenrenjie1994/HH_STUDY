package service;

import bean.Resume;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Service {
    /**
     * 增加简历
     * @param resume
     * @return
     */

    public int addResume(Connection conn,Resume resume){
        int line = 0;
        String sql = "insert into hrmis (id,name,school) values('"+resume.getId()+"','"+resume.getName()+"','"+resume.getSchool()+"')";
        try {
            Statement statement = conn.createStatement();
            line = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("sql执行失败,sql: "+sql);
        }
        return line;
    }

    /**
     * 增加多条简历
     * @param conn
     * @param resumes
     * @return
     */
    public int addResume(Connection conn, List<Resume> resumes){
        int lines = 0;
        for(int i=0;i<resumes.size();i++){
            int line = addResume(conn,resumes.get(i));
            if(line>0)
                lines++;
        }
        return lines;
    }

    /**
     * 删除简历用id
     * @param ID
     * @return
     */
    public int deleteResumeByID(Connection conn,String ID){
        int line = 0;
        Resume res = searchResumeByID(conn,ID);
        System.out.println(res.toString());
        res.setDeleteStatus(1);
        line = updateResume(conn,res);
        return line;
    }
    public int deleteResumeByID(Connection conn,List<String> IDs){
        int lines = 0;
        for(int i=0;i<IDs.size();i++){
            int line = deleteResumeByID(conn,IDs.get(i));
            if(line>0)
                lines++;
        }
        return lines;
    }

    /**
     * 非唯一条件简历删除，暂时不考虑多条消息交叉
     * @param sub_sql
     * @return
     */
    public int deleteResume(Connection conn,String sub_sql){
        int lines = 0;
        LinkedList<Resume> ress = searchResume(conn,sub_sql);
        for(int i=0;i<ress.size();i++){
            Resume cur = ress.get(i);
            cur.setDeleteStatus(1);
            int temp = updateResume(conn,cur);
            lines+=temp;
        }
        return lines;
    }

    /**
     * 更改简历按照id
     * @param resume
     * @return
     */
    public int updateResume(Connection conn,Resume resume){
        int line = 0;
        String sql = "update hrmis set name=?,school=?,process=?,deleteStatus=? where id='"+resume.getId()+"'";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,resume.getName());
            ps.setString(2,resume.getSchool());
            ps.setInt(3,resume.getProcess());
            ps.setInt(4,resume.getDeleteStatus());
            line = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("sql执行失败，sql: "+sql);
        }
        return line;
    }

    /**
     * 当提交多条更改信息时
     * @param conn
     * @param resumes
     * @return
     */
    public int updateResume(Connection conn,List<Resume> resumes){
        int lines = 0;
        for(int i=0;i<resumes.size();i++){
            int line = updateResume(conn,resumes.get(i));
            if(line>0)
                lines++;
        }
        return lines;
    }

    /**
     * 按照ID查询
     * @param conn
     * @param ID
     * @return
     */
    public Resume searchResumeByID(Connection conn,String ID){
        Resume result = new Resume();
        String sql = "select * from hrmis where id ='"+ID+"'";
        try{

            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                result = new Resume(rs.getString("id"),rs.getString("name"),
                        rs.getString("school"),rs.getInt("process"),
                        rs.getInt("deleteStatus"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("sql 执行失败，sql: "+sql);
        }
        return result;
    }

    /**
     * 多个ID查询
     * @param conn
     * @param IDs
     * @return
     */
    public List<Resume> searchResumeByID(Connection conn,List<String> IDs){
        List<Resume> resumes = new ArrayList<>();
        for(int i=0;i<IDs.size();i++){
            Resume resume = searchResumeByID(conn,IDs.get(i));
            if(resume!=null)
                resumes.add(resume);
        }
        return resumes;
    }


    public LinkedList<Resume> searchResume(Connection conn, String sub_sql){
        LinkedList<Resume> res = new LinkedList<Resume>();
        String sql = "select * from hrmis where "+sub_sql;
        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                Resume result = new Resume(rs.getString("id"),rs.getString("name"),
                        rs.getString("school"),rs.getInt("process"),
                        rs.getInt("deleteStatus"));
                res.add(result);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("sql 执行失败，sql: "+sql);
        }
        return res;
    }
}
