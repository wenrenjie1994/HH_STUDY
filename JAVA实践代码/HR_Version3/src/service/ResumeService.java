package service;

import bean.Resume;

import java.util.Scanner;

/**
 * @author 熊彩铃
 * @program HR_Version3数据库版招聘系统
 * @description 简历信息的增删改查操作
 * @date 2020/7/11 12:35
 */
public class ResumeService {
    public void addResume() {
        System.out.println("欢迎进入添加简历信息页面");
        System.out.println("请输入姓名、身份证号码、学校、年龄");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        String ID_Number = input.nextLine();
        String school = input.nextLine();
        Integer age = input.nextInt();
        Resume resume = new Resume(name,ID_Number,school,age);
        ResumeActionService resumeActionService = new ResumeActionService();
        Integer result = resumeActionService.addResumeAction(resume);
        if (result>0){
            System.out.println("添加简历成功");
        }else{
            System.out.println("添加简历失败，请重新添加");
        }
    }

    public void deleteResume() {
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("欢迎进入删除简历信息页面");
            System.out.println("按照姓名查找简历信息并删除请按1");
            System.out.println("按照身份证号码查找简历信息并删除请按2");
            System.out.println("退出请按0");

            Integer choice = input.nextInt();
            if (choice == 1) {
                deleteResumeByName();
            }else if(choice==2){
                deleteResumeByID();
            }else if(choice==0){
                break;
            }else{
                System.out.println("输入有误，请输入0-2的整数");
            }
        }
    }


    private void deleteResumeByName() {
        System.out.println("欢迎进入按姓名查找并删除简历信息页面");
        System.out.println("请输入你待删除简历信息所属者的姓名");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        ResumeActionService resumeActionService = new ResumeActionService();
        Integer result = resumeActionService.deleteResumeByNameAction(name);
        if(result>0){
            System.out.println("按姓名删除简历信息成功");
        }else{
            System.out.println("按姓名删除简历失败，请再试一次");
        }

    }

    private void deleteResumeByID() {
        System.out.println("欢迎进入按身份证号码查找并删除简历信息页面");
        System.out.println("请输入你待删除简历信息所属者的身份证号码");
        Scanner input = new Scanner(System.in);
        String ID_Number = input.nextLine();
        ResumeActionService resumeActionService = new ResumeActionService();
        Integer result = resumeActionService.deleteResumeByIDAction(ID_Number);
        if(result>0){
            System.out.println("按身份证号码删除简历信息成功");
        }else{
            System.out.println("按身份证号码删除简历失败，请再试一次");
        }

    }


    public void modifyResume() {
        System.out.println("欢迎进入修改简历信息页面");
        System.out.println("请输入修改内容，包括姓名、身份证号码、学校、年龄");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        String ID_Number = input.nextLine();
        String school = input.nextLine();
        Integer age = input.nextInt();
        Resume resume = new Resume(name,ID_Number,school,age);
        ResumeActionService resumeActionService = new ResumeActionService();
        Integer result = resumeActionService.modifyResumeAction(resume);
        if(result>0){
            System.out.println("修改简历信息成功");
        }else{
            System.out.println("修改简历信息失败，请再试一次");
        }
    }

    public void queryResume() {
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("欢迎进入查询简历信息页面");
            System.out.println("按照姓名查找简历信息请按1");
            System.out.println("按照身份证号码查找简历信息请按2");
            System.out.println("退出请按0");

            Integer choice = input.nextInt();
            if (choice == 1) {
                queryResumeByName();
            }else if(choice==2){
                queryResumeByID();
            }else if(choice==0){
                break;
            }else{
                System.out.println("输入有误，请输入0-2的整数");
            }
        }
    }

    private void queryResumeByName() {
        System.out.println("欢迎进入按照姓名查询简历信息页面");
        System.out.println("请输入待查询简历所属者的姓名");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        ResumeActionService resumeActionService = new ResumeActionService();
        Resume resume = resumeActionService.queryResumeByNameAction(name);
        if(resume!=null){
            System.out.println("查询到的简历信息为：");
            System.out.println("姓名："+resume.getName()+",身份证号码："
                    +resume.getID_Number()+",学校："+resume.getSchool()+",年龄："+resume.getAge());
        }else{
            System.out.println("没有找到符合条件的简历");
        }
    }

    private void queryResumeByID() {
        System.out.println("欢迎进入按照身份证号码查询简历信息页面");
        System.out.println("请输入待查询简历所属者的身份证号码");
        Scanner input = new Scanner(System.in);
        String ID_Number = input.nextLine();
        ResumeActionService resumeActionService = new ResumeActionService();
        Resume resume = resumeActionService.queryResumeByIDAction(ID_Number);
        if(resume!=null){
            System.out.println("查询到的简历信息为：");
            System.out.println("姓名："+resume.getName()+",身份证号码："
                    +resume.getID_Number()+",学校："+resume.getSchool()+",年龄："+resume.getAge());
        }else{
            System.out.println("没有找到符合条件的简历");
        }
    }
}
