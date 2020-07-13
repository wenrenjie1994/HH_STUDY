package service;

import bean.Resume_v3;
import tool.DBConnection;

import java.sql.*;
import java.util.LinkedList;

public class HrAction {
    /**
     * 增加简历
     * @param resume_v3
     * @return
     */
    public int addResume(Resume_v3 resume_v3){
        int line = 0;
        try {
            Connection conn = DBConnection.getConnection();
            Statement statement = conn.createStatement();
            String sql = "insert into hrmis (id,name,school) values('"+resume_v3.getId()+"','"+resume_v3.getName()+"','"+resume_v3.getSchool()+"')";
            System.out.println(sql);
            line = statement.executeUpdate(sql);
            DBConnection.closeConnection(statement,conn);
            System.out.println("增加简历成功");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("增加简历失败");
        }
        return line;
    }

    /**
     * 删除简历用id
     * @param ID
     * @return
     */
    public int deleteResumeByID(String ID){
        int line = 0;
        Resume_v3 res = searchResumeByID(ID);
        res.setDeleteStatus(1);
        line = changeResume(res);
        return line;
    }
    public int deleteResume(String sub_sql){
        int line = 0;
        LinkedList<Resume_v3> ress = searchResume(sub_sql);
        for(int i=0;i<ress.size();i++){
            Resume_v3 cur = ress.get(i);
            cur.setDeleteStatus(1);
            int temp = changeResume(cur);
            line+=temp;
        }
        return line;
    }

    /**
     * 更改简历按照id
     * @param resume_v3
     * @return
     */
    public int changeResume(Resume_v3 resume_v3){
        int line = 0;
        try{
            Connection conn = DBConnection.getConnection();
            String sql = "update hrmis set name=?,school=?,process=?,deleteStatus=? where id='"+resume_v3.getId()+"'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,resume_v3.getName());
            ps.setString(2,resume_v3.getSchool());
            ps.setInt(3,resume_v3.getProcess());
            ps.setInt(4,resume_v3.getDeleteStatus());
            line = ps.executeUpdate();
            DBConnection.closeConnection(ps,conn);
            System.out.println("简历修改成功");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("简历修改失败");
        }
        return line;
    }

    public Resume_v3 searchResumeByID(String ID){
        Resume_v3 result = null;
        try{
            Connection conn = DBConnection.getConnection();
            String sql = "select * from hrmis where id ='"+ID+"'";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                result = new Resume_v3(rs.getString("id"),rs.getString("name"),
                        rs.getString("school"),rs.getInt("process"),
                        rs.getInt("deleteStatus"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("输入错误");
        }
        return result;
    }
    public LinkedList<Resume_v3> searchResume(String sub_sql){
        LinkedList<Resume_v3> res = new LinkedList<>();
        try{
            Connection conn = DBConnection.getConnection();
            String sql = "select * from hrmis where "+sub_sql;
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                Resume_v3 result = new Resume_v3(rs.getString("id"),rs.getString("name"),
                        rs.getString("school"),rs.getInt("process"),
                        rs.getInt("deleteStatus"));
                res.add(result);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("输入错误");
        }
        return res;
    }
}
