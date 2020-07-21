package sys;

import pojo.Resume;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * User: Alex FAN
 * Date: 2020/7/21
 * Time: 23:14
 * Description:
 */
public class HRS {

    InitResumeList initResumeList = new InitResumeList();
    ArrayList<Resume>list = initResumeList.initResume();
    /*System.out.println(list.size());*/

    private Scanner input=new Scanner(System.in);

    HRS() {


        while (true) {

            System.out.println("-----欢迎进入HR_ver1.0系统-----");
            System.out.println("查看申请中的简历请按------1");
            System.out.println("看简历通过的简历请按------2");
            System.out.println("看笔试通过的简历请按------3");
            System.out.println("看面试通过的简历请按------4");
            System.out.println("查看已签约的简历请按------5");
            System.out.println("退出请按--------6");


            int choice = input.nextInt();

            if (choice == 1) {

            } else if (choice == 2) {

            } else if (choice == 3) {

            } else if (choice == 4) {

            } else if (choice == 5) {

            } else if (choice == 6) {
                System.out.println("您已经退出HR_ver1.0系统");
                input.close();
                break;
            } else {
                System.out.println("输入错误，请重新输入");
            }


        }

    }
    public static void main(String[] args) {
       new HRS();

    }

}
