package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HumanResourceService {
    private static List<Student> studentList = new ArrayList<Student>();
    private static HumanResourceService humanResource = new HumanResourceService();
    private static Lock listLock = new ReentrantLock();
    public static HumanResourceService getInstance(){
        return humanResource;
    }
    public void addStudent(Student student){
        listLock.lock();
        studentList.add(student);
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
                System.out.println(student.toString());
                listLock.unlock();
                return;
            }
        }
        System.out.println("系统中查无此人");
    }
}
