package main;

import control.Operator;
import model.ReturnResult;

import javax.swing.*;
import java.util.Scanner;
import model.Resume;
public class sysmain {
    public sysmain() {
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
            } else if (choice == 5) {
                searchResumeAll();
            } else if (choice == 6) {
                break;

            } else {
                System.out.println("输入错误，请重新输入");
            }
        }
        //关闭输入流
        System.out.println("您已经退出xxx简历管理系统");
    }
    private void addResume() {
        System.out.println("************欢迎进入简历管理系统的录入界面*************");
        Scanner input = new Scanner(System.in);
        System.out.println("请依次输入需要录入学生信息的姓名、身份证号、毕业院校");
        String Name = input.nextLine();
        String Id = input.nextLine();
        String School = input.nextLine();
        Resume resume = new Resume(Name, Id, School);
        Operator o =new Operator();
        //把Book传给Operator操作
        ReturnResult rr=o.addResume(resume);
        if(rr.isSuccess){
            JOptionPane.showMessageDialog(null, "添加成功");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "添加失败");
        }


    }
    //按照id值删除简历
    private void deleteResume() {

        System.out.println("************欢迎进入删除学生信息界面************");
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要删除学生信息的身份证号");
        String id = input.nextLine();
        Resume resume=new Resume(null,id,null);
        Operator o =new Operator();
        ReturnResult rr=o.deleteResumeById(resume);
        if(rr.isSuccess)
        {
            JOptionPane.showMessageDialog(null, "删除成功");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "删除失败");
        }

    }
    //按照id更新数据
    private void updateResume() {
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
        //把界面中得到的数据放在两个Resume里
        Resume oldResume=new Resume(null,oldId,null);
        Operator o =new Operator();
        //把Resume传给Operator操作
        ReturnResult rr=o.changeResume(resume,oldResume);
        if(rr.isSuccess)
        {
            JOptionPane.showMessageDialog(null, "更新成功");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "更新失败");
        }

    }

    private void searchResume() {

    }

    private void searchResumeAll() {

    }




    public static void main(String[] args) {
        new sysmain();
    }
}
