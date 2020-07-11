package service;

import model.Resume;
import model.ResumeList;

import java.util.Scanner;

/**
 * @author liudeqing4191
 * @date 2020/07/06
 * @project HR_SYS_1.0
 **/
public class ResumeService {

    public static void addResume() {
        //UI
        System.out.println("欢迎进入添加学生信息界面");
        Scanner input = new Scanner(System.in);
        System.out.println("请依次输入需要添加的姓名和id");
        String resumeName = input.nextLine();
        String resumeId = input.nextLine();

        Resume resume = new Resume(resumeName, resumeId);

        Action a =new Action();
        if(a.addResume(resume)>0){
            System.out.println("您已经成功添加学生信息");
        }
        else
        {
            System.out.println("添加学生信息失败");
        }
    }

    public static void deleteResume(){
        while (true){
            //UI
            Scanner input=new Scanner(System.in);
            System.out.println("欢迎进入删除学生信息界面");
            System.out.println("请输入需要删除的学生id");
            System.out.println("退出请按-1");
            String resumeId=input.nextLine();
            int q=Integer.parseInt(resumeId);
            if(q==-1){
                break;
            }

            //
            Action d=new Action();
            if(d.deleteResume(resumeId)>0){
                System.out.println("您已经成功删除学生信息");
            }
            else
            {
                System.out.println("没有找到该学生信息，无法删除");
            }
        }
    }

    public static void updateResume(){
        while (true){
            //UI
            Scanner input=new Scanner(System.in);
            System.out.println("欢迎进入删除学生信息界面");
            System.out.println("请输入需要更新的学生id、和他的新姓名、新学校、新进度、新deleteStatus");
            System.out.println("退出请按-1");
            String resumeId=input.nextLine();
            int q=Integer.parseInt(resumeId);
            if(q==-1){
                break;
            }

            String newName=input.nextLine();
            String newSchool=input.nextLine();
            int newProcess=input.nextInt();
            int newDeleteStatus=input.nextInt();

            Action u=new Action();
            if(u.updataResume(resumeId,newName,newSchool,newProcess,newDeleteStatus)>0){
                System.out.println("您已经成功更新学生信息");
            }
            else
            {
                System.out.println("没有找到该学生信息，无法更新");
            }
        }
    }

    public static void searchResume() {
        boolean c=true;
        while (c){
            Scanner input=new Scanner(System.in);
            System.out.println("欢迎进入查询学生信息界面");
            System.out.println("按姓名名查找请按----------1");
            System.out.println("按ID查找请按----------2");
            System.out.println("按学校查找请按----------3");
            System.out.println("按进度查找请按----------4");
            System.out.println("模糊查找请按------------5");
            System.out.println("退出请按----------------6");
            int choice =input.nextInt();
            input.nextLine();
            ResumeList resumes = null;
            Action s=new Action();
            switch (choice){
                case 1:
                    System.out.println("请输入学生姓名：");
                    String resumeName =input.nextLine();
                    System.out.println(resumeName);
                    resumes=s.searchResume("name =",resumeName);
                    break;
                case 2:
                    System.out.println("请输入学生身份证号：");
                    String resumeId =input.next();
                    resumes=s.searchResume("id =",resumeId);
                    break;
                case 3:
                    System.out.println("请输入学生学校：");
                    String resumeSchool =input.nextLine();
                    resumes=s.searchResume("school =",resumeSchool);
                    break;
                case 4:
                    System.out.println("请输入学生进度：");
                    String resumeProcess =input.nextLine();
                    resumes=s.searchResume("process =",resumeProcess);
                    break;
                case 5:
                    System.out.println("请输入关键字：");
                    String point =input.nextLine();
                    resumes=s.searchResume("name like","%"+point+"%");
                    break;
                case 6:
                    c=false;
                    break;
                default:System.out.println("输入错误，请重新输入");
            }
            //输出
            if(choice<6){
                int resumeCount = resumes.size();
                if(resumeCount>0)
                {
                    System.out.println("共找到" + resumeCount + "个同学");
                    for (int i = 0; i < resumeCount; i++) {
                        System.out.println("第" + (i + 1) + "个同学:");
                        System.out.println("姓名为"+ "----" + resumes.get(i).getName());
                        System.out.println("身份证号为"+ "----" + resumes.get(i).getId());
                        System.out.println("进度为"+ "----" + resumes.get(i).getProcess());
                        System.out.println("学校为"+ "----" + resumes.get(i).getSchool());
                    }
                }
                else {
                    System.out.println("没有找到这种同学");
                }
            }
        }
    }
}


