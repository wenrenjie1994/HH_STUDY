package service;

import database.DBConnection;
import model.Resume;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ResumeService {

    /**
     * 添加简历
     * @param resume
     * @return
     */
    public int addResume(Resume resume){
        int result = 0;
        Connection connection = DBConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            //拼接sql语句
            String sql = "insert into resume values('"+resume.getName()+"','"+resume.getId()+"','"+resume.getSchool()+"','"+resume.getProcess()+"')";
            result = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 通过姓名删除简历
     * @param name
     * @return
     */
    public int deleteResumeByName(String name){
        int result = 0;
        Connection connection = DBConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            //拼接sql语句
            String sql = "delete from resume where name ="+"'"+name+"'" ;
            result = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 通过身份证号删除
     * @param id
     * @return
     */
    public int deleteResumeById(String id){
        int result = 0;
        Connection connection = DBConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            //拼接sql语句
            String sql = "delete from resume where id ="+"'"+id+"'" ;
            result = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Resume> searchResumeByName(String name){
        List<Resume> resumeList = new LinkedList<>();
        Connection connection = DBConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            //拼接sql语句
            String sql = "select * from resume where name ="+"'"+name+"'" ;
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Resume resume = new Resume(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));
                resumeList.add(resume);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resumeList;
    }

    public List<Resume> searchResumeById(String id){
        List<Resume> resumeList = new LinkedList<>();
        Connection connection = DBConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            //拼接sql语句
            String sql = "select * from resume where id ="+"'"+id+"'" ;
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Resume resume = new Resume(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));
                resumeList.add(resume);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resumeList;
    }

    public List<Resume> searchResumeBySchool(String school){
        List<Resume> resumeList = new LinkedList<>();
        Connection connection = DBConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            //拼接sql语句
            String sql = "select * from resume where school ="+"'"+school+"'" ;
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Resume resume = new Resume(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));
                resumeList.add(resume);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resumeList;
    }

    /**
     *查询所有简历
     * @return List<Resume>
     */
    public List<Resume> searchAllResume(){
        List<Resume> resumeList = new LinkedList<>();
        Connection connection = DBConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            //拼接sql语句
            String sql = "select * from resume";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Resume resume = new Resume(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));
                resumeList.add(resume);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resumeList;

    }
}
