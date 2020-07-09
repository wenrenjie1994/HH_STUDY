package service;

import java.util.LinkedList;
import java.util.Scanner;
import model.Resume;
//简历服务类：主要负责简历的各种操作：删除、修改、查找、添加、显示等
public class ResumeService {

    public static void addResume(LinkedList<Resume> resumeList)
    {
        System.out.println("欢迎进入简历管理系统的录入界面");
        Scanner input=new Scanner(System.in);
        System.out.println("请依次输入需要录入学生信息的姓名、身份证号、毕业院校");
        String Name=input.nextLine();
        String Id=input.nextLine();
        String School=input.nextLine();
        Resume resume=new Resume(Name,Id,School);
        resumeList.add(resume);
        System.out.println("您已经成功录入学生信息");
        showResume(resumeList);
    }

    public static void deleteResume(LinkedList<Resume> resumeList)
    {
        Scanner input=new Scanner(System.in);
        System.out.println("欢迎进入删除学生信息界面");
        System.out.println("请输入需要删除的学生身份证号");

        String studentId=input.nextLine();
        int resumeCount=resumeList.size();
        for(int i=0;i<resumeCount;i++){
            if(resumeList.get(i).getId().equals(studentId)){
                resumeList.remove(i);
                System.out.println("您已经成功删除改学生信息");
                break;
            }else if(i==resumeCount-1){
                System.out.println("没有找到该学生信息，请核实后删除");
            }
        }
        showResume(resumeList);
    }


    public static void updateResume(LinkedList<Resume> resumeList)
    {
        Scanner input=new Scanner(System.in);
        System.out.println("欢迎进入学生信息修改界面");
        System.out.println("请输入需要修改学生的身份证号");
        String studentId=input.nextLine();
        int resumeCount = resumeList.size();
        for(int i=0;i<resumeCount;i++)
        {
            if(resumeList.get(i).getId().equals(studentId))
            {
                System.out.println("请依次输入该学生修改后的学生姓名、身份证号、毕业院校、简历进程状态、显示状态。");
                System.out.println(
                        "其中简历进程有："+
                                " 0：已申请 " +
                                " 1：简历通过 " +
                                " 2：笔试通过 " +
                                " 3：体检通过 " +
                                " 4：背调通过 " +
                                " 5：已签约 " +
                                " 6：已入职");
                System.out.println(
                        "显示状态有："+
                                "0 :不展示 " +
                                "1 :展示");
                String newname=input.nextLine();
                String newid=input.nextLine();
                String newschool=input.nextLine();
                int newprocess=input.nextInt();
                int newdeleteStatus=input.nextInt();
                resumeList.get(i).setName(newname);
                resumeList.get(i).setId(newid);
                resumeList.get(i).setSchool(newschool);
                resumeList.get(i).setProcess(newprocess);
                resumeList.get(i).setDeleteStatus(newdeleteStatus);
                System.out.println("您已经修改成功");
                showResume(resumeList);
            }
            else if(i==resumeCount-1||resumeCount==0) {
                System.out.println("没有查找到该学生的简历信息");
            }
        }
        System.out.println("系统为空，没有查找到该学生的简历信息");
    }

    public static void searchResume(LinkedList<Resume> resumeList){

        Scanner input=new Scanner(System.in);
        System.out.println("欢迎进入学生信息查询界面");
        System.out.println("请输入需要查询的学生身份证号");
        String studentId=input.nextLine();
        int resumeCount = resumeList.size();
        for(int i=0;i<resumeCount;i++)
        {
            if(resumeList.get(i).getId().equals(studentId))
            {
                System.out.println("学生姓名:"+resumeList.get(i).getName()+" "+
                        "身份证号"+":"+resumeList.get(i).getId()+" "
                        +"毕业院校"+":"+resumeList.get(i).getSchool()+" "
                        +"简历进程:"+resumeList.get(i).getProcess()+" "
                        +"简历显示状态:"+resumeList.get(i).getDeleteStatus());
                break;
            }
            else if(i==resumeCount-1) {
                System.out.println("没有查找到该学生，请重新输入");
            } else if (resumeCount==0){
                System.out.println("系统为空，没有查找到该学生的简历信息");
            }
        }

    }



    public static void showResume(LinkedList<Resume> resumeList) {
        int resumeCount=resumeList.size();
        Scanner input = new Scanner(System.in);
        System.out.println("是否需要打印所有学生信息，是请输入Y，不用打印则输入任意");
        String XUANZE = input.nextLine();
        String Y = "Y";
        if (XUANZE.equals(Y)) {
            System.out.println("本简历管理系统共有" + resumeCount + "份学生简历信息");
            for (int i = 0; i < resumeCount; i++) {
                System.out.println("学生姓名:" + resumeList.get(i).getName() + " " +
                        "身份证号" + ":" + resumeList.get(i).getId() + " "
                        + "毕业院校" + ":" + resumeList.get(i).getSchool() + " "
                        + "简历进程:" + resumeList.get(i).getProcess() + " "
                        + "简历显示状态:" + resumeList.get(i).getDeleteStatus());
            }
        }
    }
}
