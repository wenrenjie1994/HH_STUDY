package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HumanResourceService {
    private List<Student> studentList = new ArrayList<Student>();

    private static HumanResourceService humanResource = new HumanResourceService();
    private Lock listLock = new ReentrantLock();
    private HumanResourceService(){}
    public static HumanResourceService getInstance(){
        return humanResource;
    }
    public void addStudent(Student student){
        listLock.lock();
        studentList.add(student);
        System.out.println("添加成功");
        listLock.unlock();
    }
    public void deleteStudent(String studentName){
        listLock.lock();
        for (Student student : studentList){
            if(student.getName().equals(studentName)){
                studentList.remove(student);
                System.out.println("删除成功");
                listLock.unlock();
                return;
            }
        }
        System.out.println("系统中查无此人");
        listLock.unlock();
    }
    public void queryStudent(String studentName){
        for (Student student : studentList){
            if(student.getName().equals(studentName)){
                System.out.println("学生姓名：" + student.getName());
                System.out.println("学生编号：" + student.getId());
                return;
            }
        }
        System.out.println("系统中查无此人");
    }
    public void modifyStudent(String oldStudentName, String newStudentName, String newStudentId){
        listLock.lock();
        for (Student student : studentList){
            if(student.getName().equals(oldStudentName)){
                student.setName(newStudentName);
                student.setId(newStudentId);
                System.out.println("修改成功");
                listLock.unlock();
                return;
            }
        }
        listLock.unlock();
        System.out.println("系统中查无此人");
    }
}
