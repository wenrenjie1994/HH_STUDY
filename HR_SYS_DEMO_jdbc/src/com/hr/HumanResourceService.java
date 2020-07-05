package com.hr;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
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
    String url = "jdbc:mysql://localhost:3306/spdb_hr_sys?serverTimezone=GMT";
    String username = "root";
    String password = "xxz358";

    Connection conn = null;
    String sql = null;
    PreparedStatement st = null;
    ResultSet rs = null;

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
            FileOutputStream fos = new FileOutputStream("resume-data.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(Resume curResume : resumeList) oos.writeObject(curResume);
            oos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addStudent(Resume resume){
        listLock.lock();
        sql = "INSERT INTO resume_list (name, school, status) VALUES (?, ?, ?)";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, resume.getName());
            st.setString(2, resume.getSchool());
            st.setString(3, resume.getStatus());
            st.execute();
            System.out.println("添加成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        listLock.unlock();
    }
    public void deleteStudent(String studentName){
        listLock.lock();
        for (Resume resume : resumeList){
            if(resume.getName().equals(studentName)){
                resumeList.remove(resume);
                System.out.println("删除成功");
                listLock.unlock();
                return;
            }
        }
        System.out.println("系统中查无此人");
        listLock.unlock();
    }
    public void queryAllResume(){
        sql = "SELECT * FROM resume_list";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("id"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("school"));
                System.out.println(rs.getString("status"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void queryStudent(String studentName){
        for (Resume resume : resumeList){
            if(resume.getName().equals(studentName)){
                System.out.println("简历姓名：" + resume.getName());
                System.out.println("简历编号：" + resume.getId());
                System.out.println("所属学校：" + resume.getSchool());
                return;
            }
        }
        System.out.println("系统中查无此人");
    }
    public void modifyStudent(String oldStudentName, String newStudentName, String newStatus, String newSchool){
        listLock.lock();
        for (Resume resume : resumeList){
            if(resume.getName().equals(oldStudentName)){
                resume.setName(newStudentName);
                resume.setStatus(newStatus);
                resume.setSchool(newSchool);
                System.out.println("修改成功");
                listLock.unlock();
                return;
            }
        }
        listLock.unlock();
        System.out.println("系统中查无此人");
    }
}
