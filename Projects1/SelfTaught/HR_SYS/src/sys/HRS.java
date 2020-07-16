package sys;

import bean.Resume;
import utils.DataOperate;
import utils.ResumeOperate;

import java.util.LinkedList;
import java.util.Scanner;

public class HRS {
    public static void main(String[] args) {
        LinkedList<Resume> resumes = new LinkedList<>();
        boolean isExitRequested = false;
        Scanner sc = new Scanner(System.in);
        DataOperate.loadData(resumes);
        while (true) {
            System.out.println("***** 欢迎进入简历管理系统 *****");
            System.out.println("展示简历：0");
            System.out.println("添加简历：1");
            System.out.println("删除简历：2");
            System.out.println("修改简历：3");
            System.out.println("查询简历：4");
            System.out.println("退出请按：5");
            switch (sc.nextInt()) {
                case 0:
                    ResumeOperate.showResume(resumes);
                    break;
                case 1:
                    ResumeOperate.addResume(resumes);
                    break;
                case 2:
                    ResumeOperate.deleteResume(resumes);
                    break;
                case 3:
                    ResumeOperate.updateResume(resumes);
                    break;
                case 4:
                    ResumeOperate.searchResume(resumes);
                    break;
                case 5:
                    isExitRequested = true;
                    break;
                default:
                    System.out.println("输入有误，请重新输入");
            }
            if (isExitRequested) {
                DataOperate.saveData(resumes);
                break;
            }
        }
        sc.close();
        System.out.println("已退出！");
    }
}
