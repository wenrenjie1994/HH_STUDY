package com.hr;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HumanResourceService {
    private List<Resume> resumeList = new ArrayList<Resume>();
    private String content = null;

    private static HumanResourceService humanResource = new HumanResourceService();
    private Lock listLock = new ReentrantLock();
    public static HumanResourceService getInstance(){
        return humanResource;
    }

    /*
    数据库连接变量
     */
    String url = "jdbc:mysql://localhost:3306/spdb_hr_sys?serverTimezone=GMT&useSSL=false";
    String username = "root";
    String password = "xxz358";

    Connection conn = null;
    String sql = null;
    PreparedStatement st = null;
    ResultSet rs = null;
    List<Resume> rl = null;

    private void connectDatabase() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, username, password);
    }

    private HumanResourceService(){
        try{
            connectDatabase();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void storeResume(){
        //将内存中的简历信息存入文件
        try{
            if(conn != null){
                conn.close();
            }
            if(st != null){
                st.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public int addStudent(Resume resume){
        listLock.lock();
        int flag = 0;
        sql = "INSERT INTO resume_list (name, school, status) VALUES (?, ?, ?)";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, resume.getName());
            st.setString(2, resume.getSchool());
            st.setString(3, resume.getStatus());
            flag = st.executeUpdate();
            if(st != null){
                st.close();
            }
            System.out.println("添加成功");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            listLock.unlock();
            return flag;
        }
    }
    public int deleteStudent(String studentName){
        listLock.lock();
        int flag = 0;
        try {
            sql = "UPDATE resume_list SET status = '7' WHERE name = ?";
            st = conn.prepareStatement(sql);
            st.setString(1, studentName);
            flag = st.executeUpdate();
            if(flag == 1){
                System.out.println("删除成功");
            }else{
                System.out.println("系统中查无此人");
            }
            if(st != null){
                st.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            listLock.unlock();
            return flag;
        }
    }
    public ResultInfo queryAllResume(){
        sql = "SELECT * FROM resume_list";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            rl = new LinkedList<>();
            while(rs.next()){
                if(rs.getString("status").equals("7")){
                    continue;
                }
                Resume curResume = new Resume(null);
                curResume.setId(Integer.valueOf(rs.getString("id")));
                curResume.setName(rs.getString("name"));
                curResume.setSchool(rs.getString("school"));
                curResume.setStatus(rs.getString("status"));
                rl.add(curResume);
                System.out.println("简历编号： " + rs.getString("id"));
                System.out.println("姓名：" + rs.getString("name"));
                System.out.println("所属学校： " + rs.getString("school"));
                System.out.println("简历状态： " + rs.getString("status"));
            }
            if(st != null){
                st.close();
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResultInfo(0);
        }finally {
            return new ResultInfo(rl);
        }
    }
    public ResultInfo queryStudent(String studentName){
        try {
            sql = "SELECT * FROM resume_list WHERE name = ?";
            st = conn.prepareStatement(sql);
            st.setString(1, studentName);
            rs = st.executeQuery();
            rl = new LinkedList<>();
            if(rs != null && rs.next() && !rs.getString("status").equals("7")){
                Resume curResume = new Resume(null);
                curResume.setId(Integer.valueOf(rs.getString("id")));
                curResume.setName(rs.getString("name"));
                curResume.setSchool(rs.getString("school"));
                curResume.setStatus(rs.getString("status"));
                rl.add(curResume);
                System.out.println("简历编号： " + rs.getString("id"));
                System.out.println("姓名：" + rs.getString("name"));
                System.out.println("所属学校： " + rs.getString("school"));
                System.out.println("简历状态： " + rs.getString("status"));
            }else{
                System.out.println("系统中查无此人");
            }
            if(st != null){
                st.close();
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResultInfo(0);
        }finally {
            return new ResultInfo(rl);
        }
    }
    public int modifyStudent(String oldStudentName, String newStudentName, String newSchool, String newStatus){
        listLock.lock();
        int flag = 0;
        try {
            sql = "UPDATE resume_list SET name = ?, school = ?, status = ? WHERE name = ?";
            st = conn.prepareStatement(sql);
            st.setString(1, newStudentName);
            st.setString(2, newSchool);
            st.setString(3, newStatus);
            st.setString(4, oldStudentName);
            flag = st.executeUpdate();
            if(flag == 1){
                System.out.println("更新成功");
            }else{
                System.out.println("系统中查无此人");
            }
            if(st != null){
                st.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            listLock.unlock();
            return flag;
        }
    }
}
