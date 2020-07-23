package service;

import model.Candidate;

import java.util.LinkedList;
import java.util.Scanner;

public class CandidateService {
    /**
     * 添加应聘者
     *
     * @param canList 应聘者列表
     */
    public static void addCandidate(LinkedList<Candidate> canList) {
        Scanner input = new Scanner(System.in);
        System.out.println("请添加应聘者信息...");
        System.out.println("请依次输入：姓名 年龄 性别 手机号");
        String name = input.next();
        int age = input.nextInt();
        String gender = input.next();
        String phoneNumber = input.next();
        Candidate candidate = new Candidate(name, age, gender, phoneNumber);
        canList.add(candidate);
        System.out.println("已成功添加应聘者信息");
        printCandidates(canList);
    }

    /**
     * 删除应聘者
     * 当前限定用户名无重复
     *
     * @param canList 应聘者列表
     */
    public static void deleteCandidate(LinkedList<Candidate> canList) {
        if (canList.size() == 0) {
            System.out.println("当前无应聘者，请先添加应聘者信息");
            return;
        }
        Scanner input = new Scanner(System.in);
        System.out.println("请输入应聘者姓名");
        String name = input.nextLine();
        boolean flag = false;//用于标记是否成功删除应聘者
        for (int i = 0; i < canList.size(); i++) {
            if (canList.get(i).getName().equals(name)) {
                canList.remove(i);
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("已成功删除应聘者信息");
            printCandidates(canList);
        } else {
            System.out.println("不存在该应聘者");
        }
    }

    /**
     * 更新应聘者列表
     *
     * @param canList 应聘者列表
     */
    public static void updateCandidate(LinkedList<Candidate> canList) {
        if (canList.size() == 0) {
            System.out.println("当前无应聘者，请先添加应聘者信息");
            return;
        }
        Scanner input = new Scanner(System.in);
        System.out.println("请输入所需修改的应聘者姓名");
        String name = input.nextLine();
        int canCount = canList.size();
        boolean flag = false;
        for (int i = 0; i < canCount; i++) {
            if (canList.get(i).getName().equals(name)) {
                System.out.println("请重新输入应聘者信息：姓名 年龄 性别 手机号");
                String newName = input.next();
                int newAge = input.nextInt();
                String newGender = input.next();
                String newPhoneNum = input.next();
                Candidate candidate = new Candidate(newName, newAge, newGender, newPhoneNum);
                canList.set(i, candidate);
                System.out.println("已修改成功！");
                printCandidates(canList);
                flag = true;
                break;
            }
        }
        if (!flag){
            System.out.println("没有该应聘者信息");
        }
    }

    /**
     * 打印查询的应聘者信息
     *
     * @param canList
     */
    public static void searchCandidate(LinkedList<Candidate> canList) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要查找的应聘者姓名");
        String name = input.next();
        int canCount = canList.size();
        boolean flag = false;
        for (int i = 0; i < canCount; i++) {
            if (canList.get(i).getName().equals(name)) {
                System.out.println("该应聘者信息如下：");
                System.out.println("姓名：" + name + "\t年龄：" + canList.get(i).getAge() +
                        "\t性别：" + canList.get(i).getGender() +
                        "\t手机号：" + canList.get(i).getPhoneNumber());
                flag = true;
                break;
            }
        }
        if (!flag){
            System.out.println("未找到该应聘者信息");
        }
    }

    /**
     * 打印现有的应聘者列表
     *
     * @param canList 应聘者列表
     */
    public static void printCandidates(LinkedList<Candidate> canList) {
        int candidateCount = canList.size();
        System.out.println("现有应聘者数量为" + candidateCount);
        for (int i = 0; i < candidateCount; i++) {
            System.out.println("第" + (i + 1) + "个应聘者：\t姓名：" + canList.get(i).getName() + "\t电话：" + canList.get(i).getPhoneNumber());
        }
    }
}
