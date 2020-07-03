package sys;

import java.util.Scanner;

import bean.Resume;
import bean.ResumeList;

public class HRS {

    ResumeList resumeList=new ResumeList();
    //获取标准输入流
    private Scanner input=new Scanner(System.in);


    HRS(){

        while(true)
        {

            System.out.println("-----欢迎进入HR招聘系统-----");
            System.out.println("添加简历信息请按----1");
            System.out.println("删除简历信息请按----2");
            System.out.println("修改简历信息请按----3");
            System.out.println("查询简历信息请按----4");
            System.out.println("退出请按--------5");


            int choice=input.nextInt();
            boolean flag=false;
            switch (choice){
                case 1:
                    addResume();
                    break;
                case 2:
                    deleteResume();
                    break;
                case 3:
                    updateResume();
                    break;
                case 4:
                    searchResume();
                    break;
                case 5:
                    flag=true;
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
                    break;
            }
            if(flag){
                break;
            }

        }
        input.close();//流啊 连接啊 这些东西 用完记得关；要么记得还（那么什么地方是需要还的，什么地方是关的）；
        System.out.println("您已经退出HR招聘系统");
    }

    //添加
    void addResume()
    {
        System.out.println("欢迎进入添加简历界面");

            Scanner input=new Scanner(System.in);
            System.out.println("请依次输入需要添加的名称，身份证号，学校");
            String Name=input.nextLine();
            String id=input.nextLine();
            String school=input.nextLine();

            //get/SET
            Resume resume=new Resume(Name,id,school);

            resumeList.add(resume);
            System.out.println("您已经成功添加简历");
        showResumeList();
    }

    //删除
    void deleteResume()
    {
        @SuppressWarnings("resource")
        Scanner input=new Scanner(System.in);
        System.out.println("欢迎进入删除简历界面");
        System.out.println("请输入需要删除的学生姓名");
        String studentName=input.nextLine();
        if(resumeList.size()!=0)//图书管理系统不为空
        {
            for(int i=0;i<resumeList.size();i++)
            {
                if(resumeList.get(i).getName().equals(studentName))
                {
                    resumeList.remove(i);
                    System.out.println("您已经成功删除");
                    break;
                }
                else if(i==resumeList.size()-1) {
                    System.out.println("没有找到该学生的简历");
                }
            }
            showResumeList();
        }
        else{
            System.out.println("HR招聘系统为空，没有找到该简历");
        }
//		input.close();
    }

    //修改图书
    void updateResume()
    {
        Scanner input=new Scanner(System.in);
        System.out.println("欢迎进入修改简历界面");
        System.out.println("请输入需要修改的学生姓名");
        String studentName=input.nextLine();
        if(resumeList.size()!=0)//图书管理系统不为空
        {
            for(int i=0;i<resumeList.size();i++)
            {
                if(resumeList.get(i).getName().equals(studentName))
                {
                    System.out.println("请依次输入新的姓名，身份证号，学校");
                    String name=input.nextLine();
                    String id=input.nextLine();
                    String school=input.nextLine();
                  resumeList.get(i).setName(name);
                    resumeList.get(i).setId(id);
                    resumeList.get(i).setSchool(school);
                            System.out.println("您已经修改成功");
                    showResumeList();
                }
                else if(i==resumeList.size()-1) {
                    System.out.println("没有查找到该简历");
                }
            }
        }
        else{
            System.out.println("系统为空，没有查找到该简历");
        }
//		input.close();
    }

    //查询图书
    void searchResume()
    {
        @SuppressWarnings("resource")
        Scanner input=new Scanner(System.in);
        System.out.println("欢迎进入查询简历界面");
        System.out.println("请输入需要查询的学生姓名");
        String studentName=input.nextLine();
        for(int i=0;i<resumeList.size();i++)
        {
            if(resumeList.get(i).getName().equals(studentName))
            {
                System.out.println("学生"+resumeList.get(i).getName()+"\n"+
                        "身份证"+":"+resumeList.get(i).getId()+"\n"
                        +"学校"+":"+resumeList.get(i).getSchool()+"\n"
                        +"位于第"+(i+1)+"位置");
                break;
            }
            else if(i==resumeList.size()-1) {
                System.out.println("没有查找到该简历，请重新输入");
            }
        }
//		input.close();
    }

    //简历遍历
    void showResumeList()
    {
        @SuppressWarnings("resource")
        Scanner input=new Scanner(System.in);
        System.out.println("是否需要打印所有简历，是请输入Y，不用打印则输入任意");
        String XUANZE=input.nextLine();
        String Y="Y";
        if(XUANZE.equals(Y))
        {
            System.out.println("本HR招聘系统共有"+resumeList.size()+"份简历");
            for(int i=0;i<resumeList.size();i++) {
                System.out.println("第"+(i+1)+"份简历"+"----"+"<<"+resumeList.get(i).getName()+">>");
            }
        }
//		input.close();
    }

    public static void main(String[] args)
    {
        new HRS();
    }
}
