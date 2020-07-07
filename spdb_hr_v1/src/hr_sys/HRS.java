package hr_sys;

import bean.Resume;
import service.ResumeService;
import tool.DataOperate;

import java.util.LinkedList;
import java.util.Scanner;

public class HRS {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LinkedList<Resume> resumeList = DataOperate.loadData();
        Boolean flag = true;
        while (flag){
            System.out.println("************欢迎来到简历管理系统************");
            System.out.println("增加简历请按----------1");
            System.out.println("删除简历请按----------2");
            System.out.println("修改简历请按----------3");
            System.out.println("查询简历请按----------4");
            System.out.println("退出请按--------------5");
            int index = sc.nextInt();
            switch (index){
                case 1:
                    ResumeService.addResume(resumeList);break;
                case 2:
                    ResumeService.deleteResume(resumeList);break;
                case 3:
                    ResumeService.updateResume(resumeList);break;
                case 4:
                    ResumeService.showResume(resumeList);break;
                case 5:
                    DataOperate.saveData(resumeList);
                    flag = false;
                    break;
                default:
                    System.out.println("输入错误，重新输入");
            }
        }

    }
}
