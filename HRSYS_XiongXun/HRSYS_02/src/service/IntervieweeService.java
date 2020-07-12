package service;

import dataOperate.IntervieweeOperate;
import model.Interviewee;

import java.util.List;
import java.util.Scanner;

public class IntervieweeService {

    public static void addInterviewee(List<Interviewee> intervieweeList){
        System.out.println("1.添加面试者界面");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请依次输入面试者姓名、性别、年龄、学校：");
        String intervieweeName = scanner.nextLine();
        String intervieweeSex = scanner.nextLine();
        Integer intervieweeAge = Integer.parseInt(scanner.nextLine());
        String intervieweeSchool = scanner.nextLine();

        Interviewee interviewee = new Interviewee();
        interviewee.setIntervieweeName(intervieweeName);
        interviewee.setIntervieweeSex(intervieweeSex);
        interviewee.setIntervieweeAge(intervieweeAge);
        interviewee.setIntervieweeSchool(intervieweeSchool);

        intervieweeList.add(interviewee);

        IntervieweeOperate.addData(intervieweeList);
        System.out.println("添加成功！");

    }

    public static void deleteInterviewee(List<Interviewee> intervieweeList){
        System.out.println("2.删除面试者界面");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除面试者姓名：");
        String intervieweeName = scanner.nextLine();

        for (int i = 0; i < intervieweeList.size(); i++) {
            if (intervieweeList.get(i).getIntervieweeName().equals(intervieweeName)) {
                intervieweeList.remove(i);
                System.out.println("删除成功！");
                IntervieweeOperate.addData(intervieweeList);
                break;
            }else if(i==intervieweeList.size()-1||intervieweeList.size()==0){
                System.out.println("没有找到该面试者！");
            }

        }

    }

    public static void updateInterviewee(List<Interviewee> intervieweeList){
        System.out.println("3.修改面试者界面");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要修改面试者姓名：");
        String intervieweeName = scanner.nextLine();

        for (int i = 0; i < intervieweeList.size(); i++) {
            if (intervieweeList.get(i).getIntervieweeName().equals(intervieweeName)) {
                System.out.println("请输入新的面试者姓名、性别、年龄、学校：");
                Scanner scanner1 = new Scanner(System.in);
                String newName = scanner1.nextLine();
                String newSex = scanner1.nextLine();
                Integer newAge = Integer.parseInt(scanner1.nextLine());
                String newSchool = scanner1.nextLine();

                Interviewee interviewee = new Interviewee();
                interviewee.setIntervieweeName(newName);
                interviewee.setIntervieweeSex(newSex);
                interviewee.setIntervieweeAge(newAge);
                interviewee.setIntervieweeSchool(newSchool);


                intervieweeList.set(i,interviewee);
                System.out.println("修改成功！");
                IntervieweeOperate.addData(intervieweeList);
                break;
            }else if(i==intervieweeList.size()-1||intervieweeList.size()==0){
                System.out.println("没有该面试者！");
            }

        }

    }

    public static void showInterviewee(List<Interviewee> intervieweeList){
        System.out.println("4.查询面试者界面");
        System.out.println("是否需要查询所有面试者信息？请输入Y/N");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if(choice.equalsIgnoreCase("Y")){
            System.out.println("共有面试者"+intervieweeList.size()+"名，如下：");
            intervieweeList.forEach(interviewee -> System.out.println(interviewee.getIntervieweeName()+","+interviewee.getIntervieweeSex()+","+interviewee.getIntervieweeAge()
            +","+interviewee.getIntervieweeSchool()));

        }else if (choice.equalsIgnoreCase("N")){

        }


    }
}
