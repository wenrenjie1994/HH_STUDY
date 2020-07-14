package service;

import dao.ResumeDao;
import main.HRS;
import model.Resume;
import java.util.Scanner;
import java.util.UUID;

/**
 * 简历信息业务处理
 * @author 杜波
 * @version 创建时间: 2020/7/13 15:00
 */
public class ResumeSevice {

    /**
     * 添加简历信息业务方法
     */
    public static void addResume() {
        System.out.println("欢迎来到添加简历界面");
        System.out.println("请依次输入需要添加的简历信息:姓名，身份证号，学校，简历状态( 0:已申请,1:简历通过,2:笔试通过," +
                "3:体检通过,4:背调通过,5:已签约,6:已入职)");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        String id = input.nextLine();
        String school = input.nextLine();
        int process = Integer.parseInt(input.nextLine());
        Resume resume = new Resume(UUID.randomUUID().toString(),name, id, school, process);
        new ResumeDao().addResume(resume);
    }

    /**
     * 删除简历信息业务方法
     */
    public static void deleteResume() {
        System.out.println("欢迎来到删除简历界面");
        ResumeDao resumeDao=new ResumeDao();
        outloop:
        while (true) {

            System.out.println("-----欢迎进入HR系统-----");
            System.out.println("通过简历ID删除请按----1");
            System.out.println("通过简历姓名删除请按----2");
            System.out.println("通过简历身份证号删除请按----3");
            System.out.println("通过简历学校名称删除请按----4");
            System.out.println("通过简历状态删除请按----5");
            System.out.println("退出请按--------6");

            int choice = Integer.parseInt(HRS.scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("请输入简历id");
                    String resumeId = HRS.scanner.nextLine();
                    resumeDao.deleteResumeByResumeId(resumeId);
                    break;
                case 2:
                    System.out.println("请输入简历姓名");
                    String name = HRS.scanner.nextLine();
                    resumeDao.deleteResumeByName(name);
                    break;
                case 3:
                    System.out.println("请输入简历身份证号码");
                    String id = HRS.scanner.nextLine();
                    resumeDao.deleteResumeById(id);
                    break;
                case 4:
                    System.out.println("请输入简历学校名称");
                    String school = HRS.scanner.nextLine();
                    resumeDao.deleteResumeBySchool(school);
                    break;
                case 5:
                    System.out.println("请输入简历状态");
                    int process = Integer.parseInt(HRS.scanner.nextLine());
                    resumeDao.deleteResumeByProcess(process);
                    break;
                case 6:
                    break outloop;
                default:
                    System.out.println("输入错误，请重新输入!");
            }
        }
    }

    /**
     * 修改简历信息业务方法
     */
    public static void updateResume() {
        System.out.println("欢迎来到修改简历界面");
        ResumeDao resumeDao=new ResumeDao();
        outloop:
        while (true) {

            System.out.println("-----欢迎进入HR系统-----");
            System.out.println("修改指定简历姓名请按----1");
            System.out.println("修改指定简历身份证号码请按----2");
            System.out.println("修改指定简历学校请按----3");
            System.out.println("修改指定简历状态请按----4");
            System.out.println("修改指定简历的姓名、身份证号码、学校名称、状态请按----5");
            System.out.println("退出请按--------6");

            int choice = Integer.parseInt(HRS.scanner.nextLine());
            Resume resume=new Resume();
            if(choice==1 || choice==2 || choice==3 || choice==4 || choice==5){
                System.out.println("请输入需要修改的简历id");
                String resumeId = HRS.scanner.nextLine();
                resume.setResumeId(resumeId);
            }
            switch (choice) {
                case 1:
                    System.out.println("请输入修改后简历的姓名");
                    String name = HRS.scanner.nextLine();
                    resume.setName(name);
                    resumeDao.updateResumeName(resume);
                    break;
                case 2:
                    System.out.println("请输入修改后简历的身份证号码");
                    String id = HRS.scanner.nextLine();
                    resume.setId(id);
                    resumeDao.updateResumeIdCard(resume);
                    break;
                case 3:
                    System.out.println("请输入修改后简历的学校名称");
                    String school = HRS.scanner.nextLine();
                    resume.setSchool(school);
                    resumeDao.updateResumeSchool(resume);
                    break;
                case 4:
                    System.out.println("请输入修改后简历的状态(0:已申请,1:简历通过,2:笔试通过,3:体检通过,4:背调通过,5:已签约,6:已入职)");
                    int process = Integer.parseInt(HRS.scanner.nextLine());
                    resume.setProcess(process);
                    resumeDao.updateResumeProcess(resume);
                    break;
                case 5:
                    System.out.println("请输入修改后简历的姓名、身份证号码、学校名称、状态(0:已申请,1:简历通过,2:笔试通过,3:体检通过,4:背调通过,5:已签约,6:已入职)");
                    String name1 = HRS.scanner.nextLine();
                    resume.setName(name1);
                    String id1 = HRS.scanner.nextLine();
                    resume.setId(id1);
                    String school1 = HRS.scanner.nextLine();
                    resume.setSchool(school1);
                    int process1 = Integer.parseInt(HRS.scanner.nextLine());
                    resume.setProcess(process1);
                    resumeDao.updateResumeAll(resume);
                    break;
                case 6:
                    break outloop;
                default:
                    System.out.println("输入错误，请重新输入!");
            }
        }
    }

    /**
     * 查询简历信息业务方法
     */
    public static void queryResume() {
        System.out.println("欢迎来到查询简历界面");
        ResumeDao resumeDao=new ResumeDao();
        outloop:
        while (true) {

            System.out.println("-----欢迎进入HR系统-----");
            System.out.println("通过姓名查询请按----1");
            System.out.println("通过身份证号查询请按----2");
            System.out.println("通过学校名称查询请按----3");
            System.out.println("通过简历状态查询请按----4");
            System.out.println("查询所有请按----5");
            System.out.println("退出请按--------6");

            int choice = Integer.parseInt(HRS.scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("请输入姓名");
                    String name = HRS.scanner.nextLine();
                    resumeDao.queryResumeByName(name);
                    break;
                case 2:
                    System.out.println("请输入身份证号码");
                    String id = HRS.scanner.nextLine();
                    resumeDao.queryResumeById(id);
                    break;
                case 3:
                    System.out.println("请输入学校名称");
                    String school = HRS.scanner.nextLine();
                    resumeDao.queryResumeBySchool(school);
                    break;
                case 4:
                    System.out.println("请输入简历的状态( 0:已申请,1:简历通过,2:笔试通过,\" +\n" +
                            "                \"3:体检通过,4:背调通过,5:已签约,6:已入职)");
                    int process = Integer.parseInt(HRS.scanner.nextLine());
                    resumeDao.queryResumeByProcess(process);
                    break;
                case 5:
                    resumeDao.queryResumeAll();
                    break;
                case 6:
                    break outloop;
                default:
                    System.out.println("输入错误，请重新输入!");
            }
        }
    }

}
