package hrSystem;

import model.JobHunter;
import loadAndSaveDate.DateOperator;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import static dateOperator.JobHunterOperator.*;

public class HRS {
    public static void main(String[] args) throws IOException {

        LinkedList<JobHunter> jobHuntersList = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        DateOperator.loadData(jobHuntersList);
        //DateOperator.savaData(jobHuntersList);
        int count = 1;

        do{
            System.out.println("************欢迎来到HR管理系统version2版本(基于TXT文件)************");
            System.out.println("增加求职者请按----------1");
            System.out.println("删除求职者请按----------2");
            System.out.println("修改求职者请按----------3");
            System.out.println("查询求职者请按----------4");
            System.out.println("退出HR管理系统请按------5");
            //if语句指令判断
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addJobHunter(jobHuntersList);
                    break;
                case 2:
                    deleteJobHunter(jobHuntersList);
                    break;
                case 3:
                    updateJobHunter(jobHuntersList);
                    break;
                case 4:
                    searchJobHunter(jobHuntersList);
                    break;
                case 5:
                    System.out.println("您已经退出HR系统version2版本");
                    count = 0;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        }while(count == 1);

        //DateOperator.loadData(jobHuntersList);
        DateOperator.savaData(jobHuntersList);
        sc.close();
        System.out.println("您已退出图书管理系统");
    }

}
