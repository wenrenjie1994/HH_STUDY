package sys;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import bean.JobHunter;
import bean.JobHunterOperator;

import static bean.JobHunterOperator.*;

public class HRS {
    public static void main(String[] args) {
        LinkedList<JobHunter> jobHunterList = new LinkedList<>();
        //获取标准输入流
        Scanner sc = new Scanner(System.in);
        int count = 1;

        do{
            System.out.println("-----欢迎进入HR系统version1版本-----");
            System.out.println("添加求职者请按----1");
            System.out.println("删除求职者请按----2");
            System.out.println("修改求职者请按----3");
            System.out.println("查询求职者请按----4");
            System.out.println("退出请按---------5");


            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addJobHunter(jobHunterList);
                    break;
                case 2:
                    deleteJobHunter(jobHunterList);
                    break;
                case 3:
                    updateJobHunter(jobHunterList);
                    break;
                case 4:
                    searchJobHunter(jobHunterList);
                    break;
                case 5:
                    System.out.println("您已经退出HR系统version1版本");
                    count = 0;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        }while(count == 1);

        sc.close();
    }
}
