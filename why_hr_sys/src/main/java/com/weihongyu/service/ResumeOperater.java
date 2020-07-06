package com.weihongyu.service;

import com.weihongyu.entity.Resume;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/6 11:44
 * @Description:简历操作类，控制台版本
 */
public class ResumeOperater {

    Map<String, Resume> resumes = new HashMap<>();

    private Scanner input = new Scanner(System.in);//不能关
    private Scanner sc = new Scanner(System.in);//不能关


    public void run() {
        out:while (true) {
            System.out.println("-----欢迎进入HR系统控制台版本-----");
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

    /**
     * 显示所有简历信息
     */
    private void showAll() {
        Set<String> keys = resumes.keySet();
        for (String key : keys) {
            Resume resume = resumes.get(key);
            if (resume.getShowStatus()==1){
                System.out.println(resume);
            }

        }
    }

    private void deleteResume() {
        System.out.println("欢迎您进入删除简历页面");
        System.out.println("请输入需删除的姓名");
        String name = sc.nextLine();

        Resume resume = getResumeByName(name);

        if (resume!=null){
            resume.setShowStatus(0);
            resumes.replace(name,resume);
        }

    }

    /**
     * 更新简历
     */
    private void updateResume() {
        System.out.println("欢迎进入更新页面");
        System.out.println("请输入需要修改的姓名");
        String name = sc.nextLine();

        Resume resume = getResumeByName(name);

        if (resume!=null){
            System.out.println("请输入姓名，身份证号，学校名称，以‘#’分割");
            String information = input.nextLine();
            String[] infos =  information.split("#");
            resume = new Resume();

            resume.setName(infos[0]);
            resume.setId(infos[1]);
            resume.setSchool(infos[2]);
            //初始状态为已申请 0
            resume.setProcess(0);
            //默认展示简历 1
            resume.setShowStatus(1);
            resumes.replace(name,resume);
        }
    }

    private void searchResume() {
        System.out.println("欢迎进入搜索简历页面");
        System.out.println("请输入姓名进行搜索");
        String name = sc.nextLine();
        Resume resume = getResumeByName(name);

        if (resume!=null){
            System.out.println(resume);
        }
    }

    /**
     * 增加简历
     * 姓名，身份证号，学校名称，以‘#’分割
     */
    private void addResume() {
        System.out.println("欢迎进入添加简历页面");
        System.out.println("请输入姓名，身份证号，学校名称，以‘#’分割");
        String info = sc.nextLine();
        String[] infos = info.split("#");

//        if (infos.length<3){
//            System.out.println("输入有误，请重新输入");
//            throw new RuntimeException("输入数据有误");
//        }

        Resume resume = new Resume();
        resume.setName(infos[0]);
        resume.setId(infos[1]);
        resume.setSchool(infos[2]);
        //初始状态为已申请 0
        resume.setProcess(0);
        //默认展示简历 1
        resume.setShowStatus(1);

        resumes.put(infos[0],resume);
    }

    private Resume getResumeByName(String name){
        Resume resume = resumes.get(name);
        if (resume==null||resume.getShowStatus()==0){
            System.out.println("没有找到对应姓名的简历或简历已经被删除");
            return null;
        }
        return resume;

    }
}
