package service;

import model.Resume;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author liudeqing4191
 * @date 2020/07/06
 * @project HR_SYS_1.0
 **/
public class ResumeService {

    public static void addResume(LinkedList<Resume> resumeList) {
        System.out.println("欢迎进入添加学生信息界面");
        Scanner input = new Scanner(System.in);
        System.out.println("请依次输入需要添加的姓名和id");
        String resumeName = input.nextLine();
        String resumeId = input.nextLine();

        //get/SET
        Resume resume = new Resume(resumeName, resumeId);

        resumeList.add(resume);
        System.out.println("您已经成功添加学生信息");
        showResume(resumeList);
//        input.close();
    }

    public static void deleteResume(LinkedList<Resume> resumeList){
        Scanner input=new Scanner(System.in);
        System.out.println("欢迎进入删除学生信息界面");
        System.out.println("请输入需要删除的学生id");
        String resumeId=input.nextLine();
        int resumeCount=resumeList.size();
        for(int i=0;i<resumeCount;i++)
        {
            if(resumeList.get(i).getId().equals(resumeId))
            {
                resumeList.remove(i);
                System.out.println("您已经成功删除学生信息");
                break;
            }
            else if(i==resumeCount-1) {
                System.out.println("没有找到该学生");
            }
        }
        showResume(resumeList);
//        input.close();
    }

    public static void updateResume(LinkedList<Resume> resumeList)
    {
        Scanner input=new Scanner(System.in);
        System.out.println("欢迎进入修改学生信息界面");
        System.out.println("请输入需要修改的学生Id");
        String resumeId=input.nextLine();
        int resumeCount=resumeList.size();
        if(resumeCount!=0)//hr系统不为空
        {
            for(int i=0;i<resumeCount;i++)
            {
                if(resumeList.get(i).getId().equals(resumeId))
                {
                    System.out.println("请依次输入新的姓名，id，学校，进度");
                    String newresumeName=input.nextLine();
                    String newresumeId=input.nextLine();
                    String newresumeSchool=input.nextLine();
                    int newresumeProcess=input.nextInt();

                    Resume resume=new Resume(newresumeName,newresumeId);
                    resume.setSchool(newresumeSchool);
                    resume.setProcess(newresumeProcess);
                    resumeList.set(i,resume);

                    System.out.println("您已经修改成功");
                    showResume(resumeList);

                    break;
                }
                else if(i==resumeCount-1||resumeCount==0) {
                    System.out.println("没有查找到该学生");
                }
            }
        }
        else{
            System.out.println("系统为空，没有查找到该学生");
        }
//		input.close();
    }

    public static void searchResume(LinkedList<Resume> resumeList) {
        Scanner input=new Scanner(System.in);
        System.out.println("欢迎进入查询学生信息界面");
        System.out.println("请输入需要查询的学生id");
        String resumeId=input.nextLine();

        int resumeCount=resumeList.size();
        for(int i=0;i<resumeCount;i++)
        {
            if(resumeList.get(i).getId().equals(resumeId))
            {
                Resume resume=resumeList.get(i);
                System.out.println("姓名："+resume.getName()+"\n"+
                        "ID"+":"+resume.getId()+"\n"
                        +"学校"+":"+resume.getSchool()+"\n"
                        +"进度："+resume.getProcess());
                break;
            }
            else if(i==resumeCount-1) {
                System.out.println("没有查找到该学生，请重新输入");
            }
        }
//		input.close();
    }



    private static void showResume(LinkedList<Resume> resumeList) {
        Scanner input = new Scanner(System.in);
        System.out.println("是否需要打印所有学生信息，是请输入Y，不用打印则输入任意");
        String XUANZE = input.nextLine();
        String Y = "Y";
        if (XUANZE.equals(Y)) {
            System.out.println("本hr系统共有" + resumeList.size() + "个同学");
            int resumeCount = resumeList.size();
            for (int i = 0; i < resumeCount; i++) {
                System.out.println("第" + (i + 1) + "个同学" + "----" + resumeList.get(i).getName());
            }
        }
//        input.close();
    }


}


