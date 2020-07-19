package com.wtp.action;

import com.wtp.dutil.DataOperate;
import com.wtp.model.Resume;
import com.wtp.service.ResumeService;

import java.util.LinkedList;
import java.util.Scanner;

public class ResumeManage {
    public static void main(String[] args) {
        LinkedList<Resume> resumeList = new LinkedList<Resume>();;
        DataOperate.loadData(resumeList);
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("************欢迎来到简历管理系统************");
            System.out.println("增加简历请按----------1");
            System.out.println("删除简历请按----------2");
            System.out.println("修改简历请按----------3");
            System.out.println("查询简历请按----------4");
            System.out.println("退出请按--------------5");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    ResumeService.addResume(resumeList);
                    break;
                case 2:
                    ResumeService.deleteResume(resumeList);
                    break;
                case 3:
                    ResumeService.updateResume(resumeList);
                    break;
                case 4:
                    ResumeService.showResume(resumeList);
                    break;
                case 5:
                    DataOperate.saveData(resumeList);
                    System.out.println("您将退出简历管理系统！谢谢使用！");
                    System.exit(0);
                default:
                    System.out.println("输入错误，请确认后从新输入");
                    break;
            }
        }
    }
}
