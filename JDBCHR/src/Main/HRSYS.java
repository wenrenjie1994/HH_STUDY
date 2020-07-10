package Main;

import Dao.Candidate;
import Dao.CandidateService;

import java.util.LinkedList;
import java.util.Scanner;

public class HRSYS {
    public static void main(String[] args) {
        LinkedList<Candidate> candidateList = new LinkedList<Candidate>();
        Scanner input = new Scanner(System.in);
        //   DataOperate.loadData(candidateList);
        while (true) {
            System.out.println("************张某人基于数据库的HR管理系统************");
            System.out.println("增加应聘者请按----------1");
            System.out.println("删除应聘者请按----------2");
            System.out.println("修改应聘者请按----------3");
            System.out.println("查询应聘者请按----------4");
            System.out.println("退出请按--------------5");
            //if语句指令判断
            int choice = input.nextInt();
            if (choice == 1) {
                CandidateService.addCandidate(candidateList);
            } else if (choice == 2) {
                CandidateService.deleteCandidate(candidateList);
            } else if (choice == 3) {
                CandidateService.updateCandidate(candidateList);
            } else if (choice == 4) {
                CandidateService.showCandidate(candidateList);
            } else if (choice == 5) {
                //  DataOperate.saveCandidate(candidateList);
                break;
            } else {
                System.out.println("输入错误，请确认后从新输入");
            }
        }
        System.out.println("您已退出简历管理系统");
    }
}

