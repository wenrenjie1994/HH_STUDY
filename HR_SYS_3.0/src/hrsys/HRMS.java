package hrsys;


import bean.Resume;
import bean.ResumeList;
import work.Action;

import java.sql.SQLOutput;
import java.util.Scanner;

public class HRMS {
    public static void main(String[] args) {
        //主程序入口
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("************欢迎进入xxx简历管理系统************");
            System.out.println("简历信息录入请按----1");
            System.out.println("简历信息删除请按----2");
            System.out.println("简历信息修改请按----3");
            System.out.println("简历信息查询请按----4");
            System.out.println("简历数据库查询请按--5");
            System.out.println("退出请按-----------6");
            int choice = input.nextInt();
            if (choice == 1) {
                addResume();
            } else if (choice == 2) {
                deleteResume();
            } else if (choice == 3) {
                updateResume();
            } else if (choice == 4) {
                searchResume();
            } else if(choice==5){
                searchResumeAll();
            }
            else if (choice == 6) {
                break;

            } else {
                System.out.println("输入错误，请重新输入");
            }
        }
        //关闭输入流
        System.out.println("您已经退出xxx简历管理系统");

    }

    private static void searchResumeAll() {
        Action s = new Action();
        ResumeList resumelist=s.searchResumeAll();
        int resumeCount = resumelist.size();
        if(resumeCount>0)
        {
            for(int i=0;i<resumeCount;i++) {
                System.out.println("姓名："+resumelist.get(i).getName()+"  "
                        +"身份证号"+"："+resumelist.get(i).getId()+"  "
                        +"毕业院校"+"："+resumelist.get(i).getSchool()+"  "
                        +"简历进程："+resumelist.get(i).getProcess()+"  "
                        +"简历显示状态："+resumelist.get(i).getDeleteStatus());
            }
        }
        else {
            System.out.println("对不起，简历数据库为空");
        }

    }

    public static void addResume() {
        System.out.println("************欢迎进入简历管理系统的录入界面*************");
        Scanner input = new Scanner(System.in);
        System.out.println("请依次输入需要录入学生信息的姓名、身份证号、毕业院校");
        String Name = input.nextLine();
        String Id = input.nextLine();
        String School = input.nextLine();
        Resume resume = new Resume(Name, Id, School);
        Action a = new Action();
        int line = a.addresume(resume);
        if (line > 0) {
            System.out.println("添加图书成功");
        } else {
            System.out.println("添加图书失败");
        }
    }

    public static void deleteResume() {
        System.out.println("************欢迎进入删除学生信息界面************");
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要删除学生信息的身份证号");
        String id = input.nextLine();
        Action d = new Action();
        int line = d.deleteResumeByid(id);
        System.out.println("删除图书成功");
    }

    public static void updateResume() {


        Scanner input = new Scanner(System.in);
        System.out.println("************欢迎进入学生信息修改界面************");
        System.out.println("请输入需要修改学生信息的身份证号");
        String oldId = input.nextLine();
        System.out.println("请依次输入该学生修改后的学生姓名、身份证号、毕业院校、简历进程状态、显示状态。");
        System.out.println(
                "其中简历进程有：" +
                        " 0：已申请 " +
                        " 1：简历通过 " +
                        " 2：笔试通过 " +
                        " 3：体检通过 " +
                        " 4：背调通过 " +
                        " 5：已签约 " +
                        " 6：已入职");
        System.out.println(
                "显示状态有：" +
                        "0 :不展示 " +
                        "1 :展示");
        String newname = input.nextLine();
        String newid = input.nextLine();
        String newschool = input.nextLine();
        int newprocess = input.nextInt();
        int newdeleteStatus = input.nextInt();
        Resume resume=new Resume(newname,newid,newschool);
        resume.setProcess(newprocess);
        resume.setDeleteStatus(newdeleteStatus);
        Action d = new Action();
        int line = d.changeResume(resume,oldId);
        System.out.println("更新成功");
    }

    public static void searchResume() {

        while(true)
        {
            System.out.println("************欢迎来到简历查询************");
            System.out.println("按学生姓名查询请输入----------1");
            System.out.println("按学生身份证查询请输入----------2");
            System.out.println("按学生毕业院校查询请输入------------3");
            System.out.println("按学生简历进程查询请输入----------4");
            System.out.println("模糊查询请输入------------5");
            System.out.println("退出请按----------------6");
            Scanner input = new Scanner(System.in);
            int choice =input.nextInt();
            if(choice==1)
            {
                searchResumeByName();

            }
            else if(choice==2)
            {
                searchResumeById();
            }
            else if(choice==3)
            {
                searchResumeBySchool();
            }
            else if(choice==4)
            {
                searchResumeByProcess();
            }
            else if(choice==5)
            {
                searchResumeByPointword();
            }
            else if(choice==6){
                break;
            }
            else{
                System.out.println("请确认后重新输入");
            }
        }


    }

    private static void searchResumeByPointword() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要查询简历的学生姓名：");
        String burname =input.nextLine();
        Action s = new Action();
        ResumeList resumelist=s.searchResumeByPointword(burname);
        int resumeCount = resumelist.size();
        if(resumeCount>0)
        {
            for(int i=0;i<resumeCount;i++) {
                System.out.println("姓名："+resumelist.get(i).getName()+"  "
                        +"身份证号"+"："+resumelist.get(i).getId()+"  "
                        +"毕业院校"+"："+resumelist.get(i).getSchool()+"  "
                        +"简历进程："+resumelist.get(i).getProcess()+"  "
                        +"简历显示状态："+resumelist.get(i).getDeleteStatus());
            }
        }
        else {
            System.out.println("对不起，没有找到");
        }

    }

    private static void searchResumeByName() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要查询简历的学生姓名：");
        String name =input.nextLine();
        Action s = new Action();
        ResumeList resumelist=s.searchResumeByName(name);
        int resumeCount = resumelist.size();
        if(resumeCount>0)
        {
            for(int i=0;i<resumeCount;i++) {
                System.out.println("姓名："+resumelist.get(i).getName()+"  "
                        +"身份证号"+"："+resumelist.get(i).getId()+"  "
                        +"毕业院校"+"："+resumelist.get(i).getSchool()+"  "
                        +"简历进程："+resumelist.get(i).getProcess()+"  "
                        +"简历显示状态："+resumelist.get(i).getDeleteStatus());
            }
        }
        else {
            System.out.println("没有找到姓名为"+name+"的职工简历");
        }

    }

    private static void searchResumeById() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要查询简历的职工身份证号：");
        String id =input.nextLine();
        Action s = new Action();
        ResumeList resumelist=s.searchResumeByid(id);
        int resumeCount = resumelist.size();
        if(resumeCount>0)
        {
            for(int i=0;i<resumeCount;i++) {
                System.out.println("姓名："+resumelist.get(i).getName()+"  "
                        +"身份证号"+"："+resumelist.get(i).getId()+"  "
                        +"毕业院校"+"："+resumelist.get(i).getSchool()+"  "
                        +"简历进程："+resumelist.get(i).getProcess()+"  "
                        +"简历显示状态："+resumelist.get(i).getDeleteStatus());
            }
        }
        else {
            System.out.println("没有找到身份证号为"+id+"的学生简历");
        }
    }

    private static void searchResumeBySchool() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要查询职工简历的毕业院校：");
        String school =input.nextLine();
        Action s = new Action();
        ResumeList resumelist=s.searchResumeByschool(school);
        int resumeCount = resumelist.size();
        if(resumeCount>0)
        {
            for(int i=0;i<resumeCount;i++) {
                System.out.println("姓名："+resumelist.get(i).getName()+"  "
                        +"身份证号"+"："+resumelist.get(i).getId()+"  "
                        +"毕业院校"+"："+resumelist.get(i).getSchool()+"  "
                        +"简历进程："+resumelist.get(i).getProcess()+"  "
                        +"简历显示状态："+resumelist.get(i).getDeleteStatus());
            }
        }
        else {
            System.out.println("没有找到毕业院校为"+school+"的职工简历");
        }

    }

    private static void searchResumeByProcess() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要查询职工简历的进程：");
        String  process =input.nextLine();
        Action s = new Action();
        ResumeList resumelist=s.searchResumeByprocess(process);
        int resumeCount = resumelist.size();
        if(resumeCount>0)
        {
            for(int i=0;i<resumeCount;i++) {
                System.out.println("姓名："+resumelist.get(i).getName()+"  "
                        +"身份证号"+"："+resumelist.get(i).getId()+"  "
                        +"毕业院校"+"："+resumelist.get(i).getSchool()+"  "
                        +"简历进程："+resumelist.get(i).getProcess()+"  "
                        +"简历显示状态："+resumelist.get(i).getDeleteStatus());
            }
        }
        else {
            System.out.println("目前简历中还没有进程是"+process+"的简历");
        }
    }


}
