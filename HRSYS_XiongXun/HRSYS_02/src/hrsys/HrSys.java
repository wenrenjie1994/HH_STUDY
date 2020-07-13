package hrsys;

import dataOperate.IntervieweeOperate;
import model.Interviewee;
import service.IntervieweeService;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HrSys {
    public static void main(String[] args) {
        List<Interviewee> intervieweeList = new LinkedList<>();
        Scanner input = new Scanner(System.in);
        IntervieweeOperate.loadData(intervieweeList);//加载所有面试者信息
        boolean flag = true;

        while (flag){
            System.out.println("************欢迎来到LowBHR管理系统************");
            System.out.println("增加面试者请按----------1");
            System.out.println("删除面试者请按----------2");
            System.out.println("修改面试者请按----------3");
            System.out.println("查询面试者请按----------4");
            System.out.println("退出请按----------------0");

            int choice = input.nextInt();
            switch (choice){
                case 1:
                    IntervieweeService.addInterviewee(intervieweeList);
                    break;
                case 2:
                    IntervieweeService.deleteInterviewee(intervieweeList);
                    break;
                case 3:
                    IntervieweeService.updateInterviewee(intervieweeList);
                    break;
                case 4:
                    IntervieweeService.showInterviewee(intervieweeList);
                    break;
                case 0:
                    IntervieweeOperate.addData(intervieweeList);//保存数据
                    flag=false;
                    break;
                default:
                    System.out.println("输入错误！请重新输入：");

            }
        }
        input.close();
        System.out.println("您已退出系统！");

    }
}
