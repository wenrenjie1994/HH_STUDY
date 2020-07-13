package hr_sys;

import service.HrService;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by guyaren
 */
public class HRS_v3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
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
                    HrService.addResume();break;
                case 2:
                    HrService.deleteResume();break;
                case 3:
                    HrService.updateResume();break;
                case 4:
                    HrService.SearchResume();break;
                case 5:
                    flag = false;
                    break;
                default:
                    System.out.println("输入错误，重新输入");
            }
        }

    }
}
