package com.lihang.operate;

import com.lihang.pojo.Resume;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.BufferedReader;
import java.util.*;

public class HRS {

    Map<String, Resume> resumes = new HashMap<>();
    private Scanner input = new Scanner(System.in);//不能关
    private Scanner sc = new Scanner(System.in);//不能关

    public void operate() {
        out:while (true) {
            System.out.println("-----欢迎进入李航版HR系统-----");
            System.out.println("增加简历信息----1");
            System.out.println("查询简历信息----2");
            System.out.println("修改简历信息----3");
            System.out.println("删除简历信息----4");
            System.out.println("显示所有简历信息----5");
            System.out.println("退出系统--------6");
            int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        addResume();break;
                    case 2:
                        searchResume();break;
                    case 3:
                        updateResume();break;
                    case 4:
                        deleteResume();break;
                    case 5:
                        showAll();break;
                    case 6:
                        input.close();sc.close();break out;
                }
        }
    }

    void addResume() {
            //Scanner sc = new Scanner(System.in);
            System.out.println("欢迎您进入添加简历页面");
            System.out.println("请输入姓名，身份证号，学校名称，以‘#’分割");
            String information = sc.nextLine();
            String[] detail =  information.split("#");
            Resume resume = new Resume(detail[0],detail[1],detail[2],0,1);
            resumes.put(detail[0],resume);
           // sc.close();
    }
    //假删除
    void deleteResume() {
        //Scanner sc = new Scanner(System.in);
        System.out.println("欢迎您进入删除简历页面");
        System.out.println("请输入需删除的姓名");
        String name = sc.nextLine();
        Resume resume = isExist(name);
        if (resume!=null){
            resume.setDeleteStatus(0);
            resumes.replace(name,resume);
        }
		//input.close();
    }


    void updateResume() {
        //Scanner sc = new Scanner(System.in);
        System.out.println("欢迎进入更新页面");
        System.out.println("请输入需要修改的姓名");
        String name = sc.nextLine();
        Resume resume = isExist(name);
        if (resume!=null){
            System.out.println("请输入姓名，身份证号，学校名称，以‘，’分割");
            String information = input.nextLine();
            String[] detail =  information.split(",");
            resume = new Resume(detail[0],detail[1],detail[2],0,1);
            resumes.replace(name,resume);
        }
	//input.close();
    }

    void searchResume() {
       // Scanner sc = new Scanner(System.in);
        System.out.println("欢迎进入更新页面");
        System.out.println("请输入需要查询的姓名");
        String name = sc.nextLine();
        Resume resume = isExist(name);
        if (resume != null){
            System.out.println(resume);
        }
		//input.close();
    }

    void showAll() {
        System.out.println("以下是所有简历");
        Collection<Resume> list =  resumes.values();
        list.forEach(System.out::println);
    }
    //根据姓名判断是否存在此人，或被删除
    //resume：存在;null:不存在
    public Resume isExist(String name){
        Resume resume = resumes.get(name);
        if(resume == null){
            System.out.println("未找到相关简历，请核对姓名");
            return null;
        }
        else if (resume.getDeleteStatus()==0){
            System.out.println("此人已被删除");
            return null;
        }else {
            return resume;
        }
    }
    public static void main(String[] args) {
       new HRS().operate();
    }
}