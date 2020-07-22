package operation;

import bean.Resume;
import database.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA
 * @Author LC
 * @create 2020/7/12
 */

public class Action {

    //添加方法
    public int addResume(Resume resume){

        int change=0;

        try{
            Connection connection = DBConnection.getConnection();
            Statement statement =connection.createStatement();
            String Sql = "insert into resume values('"+resume.getName()+"','"+resume.getAge()+"','"+resume.getIdCard()+
                    "','"+resume.getSchool()+"','"+resume.getProcessState()+"','"+resume.getDeleteStatus()+"')";
            change = statement.executeUpdate(Sql);
            DBConnection.closeConnection(null,statement,connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return change;
    }

    //查询方法
    public ArrayList searchResume(Resume resume){

        ArrayList<Resume> resumes = new ArrayList<>();

        try{
            Connection connection =DBConnection.getConnection();
            Statement statement =connection.createStatement();
            String Sql ="select * from resume where resumeName ='"+resume.getName()+"'";
            ResultSet resultSet =statement.executeQuery(Sql);
            while (resultSet.next()){
                Resume resume1 = new Resume(resultSet.getString(1),resultSet.getInt(2),
                        resultSet.getString(3),resultSet.getString(4),
                        resultSet.getInt(5),resultSet.getInt(6));
                resumes.add(resume1);
            }
            DBConnection.closeConnection(resultSet,statement,connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resumes;

    }
    //查询方法
    public ArrayList searchByNameAndId(Resume resume){

        ArrayList<Resume> resumes1 = new ArrayList<>();
        try{
            Connection connection =DBConnection.getConnection();
            Statement statement =connection.createStatement();
            String Sql ="select * from resume where name ='"+resume.getName()+"'AND idCard='"+resume.getIdCard()+"'";
            ResultSet resultSet =statement.executeQuery(Sql);
            while (resultSet.next()){
             Resume resume1 = new Resume(resultSet.getString(1),resultSet.getInt(2),
                        resultSet.getString(3),resultSet.getString(4),
                        resultSet.getInt(5),resultSet.getInt(6));
                resumes1.add(resume1);

            }
            DBConnection.closeConnection(resultSet,statement,connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resumes1;

    }



    //修改方法
    public int updateResume(Resume resume,Resume oldresume){

        int chage =0;

        try {
            Connection connection =DBConnection.getConnection();
            Statement statement = connection.createStatement();
            String Sql = "UPDATE resume SET name = '"+resume.getName()+"',age='"+resume.getAge()+"'," +
                    "idCard='"+resume.getIdCard()+"',school='"+resume.getSchool()+"',processState='"+
                    resume.getProcessState()+"',deleteStatus='"+resume.getDeleteStatus()+"' " +
                    "WHERE name='"+oldresume.getName()+"' AND idCard='"+oldresume.getIdCard()+"'";
            DBConnection.closeConnection(null,statement,connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chage;
    }


    //离职方法
    public int upadeteDelete(Resume resume){

        int chage=0;

        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            String Sql = "UPDATE resume SET deleteStatus ='"+resume.getDeleteStatus()+"'";
            DBConnection.closeConnection(null,statement,connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chage;
    }

    //通过姓名和身份证删除
    public int deleteResumeByNameAndId(Resume resume) {
        int change = 0;

        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            String Sql = "DELETE from resume where name = '" + resume.getName() + "' AND idCard = '" + resume.getIdCard() + "'";
            DBConnection.closeConnection(null, statement, connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return change;
    }
}
