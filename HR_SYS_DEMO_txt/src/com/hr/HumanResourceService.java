package com.hr;

import java.io.*;
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

    private HumanResourceService(){
        //从文件中读取简历信息
        try{
            File file = new File("resume-data.txt");
            try{
                if(!file.exists()){
                    file.createNewFile();
                }
            }catch (Exception e){
                e.printStackTrace();
            }

            FileInputStream fis = new FileInputStream("resume-data.txt");
            ObjectInputStream ois = null;
            Boolean eofFlag = false;
            try {
                ois = new ObjectInputStream(fis);
            }catch (Exception e){
                if(e.toString().equals((new EOFException()).toString() )){
                    eofFlag = true;
                }else{
                    e.printStackTrace();
                }
            }

            Object curObject = null;
            while(!eofFlag){
                try {
                    curObject = ois.readObject();
                    if(curObject == null){
                        eofFlag = true;
                    }else {
                        resumeList.add((Resume)curObject);
                    }
                }catch (Exception e){
                    if(!e.toString().equals((new EOFException()).toString())){
                        e.printStackTrace();
                    }else {
                        eofFlag = true;
                    }
                }
            }
            if(ois != null) ois.close();
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
        resumeList.add(resume);
        System.out.println("添加成功");
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
        for (Resume resume : resumeList){
            System.out.println("----------------------------");
            System.out.println("简历姓名：" + resume.getName());
            System.out.println("简历编号：" + resume.getId());
            System.out.println("所属学校：" + resume.getSchool());
            System.out.println("----------------------------");
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
    public void modifyStudent(String oldStudentName, String newStudentName, String newStudentId, String newSchool){
        listLock.lock();
        for (Resume resume : resumeList){
            if(resume.getName().equals(oldStudentName)){
                resume.setName(newStudentName);
                resume.setId(newStudentId);
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
