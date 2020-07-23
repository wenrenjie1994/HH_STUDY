package hrsys;

import LoadAndSaveDate.DataOperate;
import model.Candidate;
import service.CandidateService;

import java.util.LinkedList;
import java.util.Scanner;

public class LHS {
    public static void printHRSys() {
        System.out.println("============欢迎来到简单招聘系统2.0(基于文本)==============");
        System.out.println("增加应聘者请输入-----1");
        System.out.println("删除应聘者请输入-----2");
        System.out.println("更新应聘者请输入-----3");
        System.out.println("查询应聘者请输入-----4");
        System.out.println("打印应聘者列表请输入-----5");
        System.out.println("退出招聘系统-----0");
    }

    public static void main(String[] args) {
        LinkedList<Candidate> candidates = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        DataOperate.loadData(candidates);
        boolean flag = true;//用于标志是否退出系统
        while (flag) {
            printHRSys();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    CandidateService.addCandidate(candidates);
                    break;
                case 2:
                    CandidateService.deleteCandidate(candidates);
                    break;
                case 3:
                    CandidateService.updateCandidate(candidates);
                    break;
                case 4:
                    CandidateService.searchCandidate(candidates);
                    break;
                case 5:
                    CandidateService.printCandidates(candidates);
                    break;
                case 0:
                    System.out.println("感谢使用简单招聘系统1.0，已退出...");
                    flag = false;
                    break;
                default:
                    System.out.println("输入格式错处，请重新输入！");
                    break;
            }
        }
        DataOperate.saveData(candidates);
    }
}
