package main;

import service.ResumeSevice;
import java.util.Scanner;

/**
 * 系统启动入口类
 * @author 杜波
 * @version 创建时间: 2020/7/13 15:40
 */
public class HRS {
    /**
     * 获取标准输入流
     */
    public static Scanner scanner = new Scanner(System.in);

    HRS() {
        outloop:
        while (true) {

            System.out.println("-----欢迎进入HR系统-----");
            System.out.println("添加简历信息请按----1");
            System.out.println("删除简历信息请按----2");
            System.out.println("修改简历信息请按----3");
            System.out.println("查询简历信息请按----4");
            System.out.println("退出请按--------5");


            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    ResumeSevice.addResume();
                    break;
                case 2:
                    ResumeSevice.deleteResume();
                    break;
                case 3:
                    ResumeSevice.updateResume();
                    break;
                case 4:
                    ResumeSevice.queryResume();
                    break;
                case 5:
                    break outloop;
                default:
                    System.out.println("输入错误，请重新输入!");

            }
        }
        scanner.close();//流啊 连接啊 这些东西 用完记得关；要么记得还（那么什么地方是需要还的，什么地方是关的
        System.out.println("您已经退出HR管理系统");
    }
    public static void main(String[] args) {
        new HRS();
    }
}
