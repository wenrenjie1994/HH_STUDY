package Other;

import java.util.LinkedList;
import java.util.Scanner;

public class CandidateService {
    public static void addCandidate(LinkedList<Candidate> CandidateList) {
        System.out.println("欢迎来到添加简历界面");
        Scanner input = new Scanner(System.in);
        System.out.println("请依次输入需要添加姓名，年龄，教育情况");
        String Name = input.nextLine();
        String age = input.nextLine();
        String Education = input.nextLine();
        Candidate book = new Candidate(Name, age, Education);
        CandidateList.add(book);
        System.out.println("您已成功添加简历");
        showCandidate(CandidateList);
    }

    public static void deleteCandidate(LinkedList<Candidate> CandidateList) {
        Scanner input = new Scanner(System.in);
        System.out.println("欢迎来到删除简历界面");
        System.out.println("请输入需要删除的简历名");
        String Name = input.nextLine();
        int bookCount = CandidateList.size();
        for (int i = 0; i < bookCount; i++) {
            if (CandidateList.get(i).Name.equals(Name)) {
                CandidateList.remove(i);
                System.out.println("您已成功删除简历");
                break;
            } else if (i == bookCount - 1) {
                System.out.println("没有查找到该简历");
            }
        }
        showCandidate(CandidateList);
    }


    public static void updateCandidate(LinkedList<Candidate> CandidateList) {
        Scanner input = new Scanner(System.in);
        System.out.println("欢迎来到修改简历界面");
        System.out.println("请输入需要修改的简历名");
        String jianliName = input.nextLine();
        int bookCount = CandidateList.size();
        for (int i = 0; i < bookCount; i++) {
            if (CandidateList.get(i).Name.equals(jianliName)) {
                System.out.println("请依次输入新的姓名，年龄，教育程度");
                String newName = input.nextLine();
                String newage = input.nextLine();
                String newEducation = input.nextLine();
                Candidate d = new Candidate(newName, newage, newEducation);
                CandidateList.set(i, d);
                System.out.println("您已成功修改成功");
                showCandidate(CandidateList);
            } else if (i == bookCount - 1 || bookCount == 0) {
                System.out.println("没有查找到该简历");
            }
        }
        System.out.println("没有查找到该简历");
    }

    public static void showCandidate(LinkedList<Candidate> CandidateList) {
        Scanner input = new Scanner(System.in);
        System.out.println("是否需要打印所有简历，是请输入Y，不用打印则输入任意");
        String XUANZE = input.nextLine();
        String Y = "Y";
        if (XUANZE.equals(Y)) {
            System.out.println("本简历管理系统共有" + CandidateList.size() + "个简历");
            int CandidateCount = CandidateList.size();
            for (int i = 0; i < CandidateCount; i++) {
                System.out.println("第" + (i + 1) + "个" + "---------" + "<<" + CandidateList.get(i).Name + ">>");
            }
        }
    }
}
