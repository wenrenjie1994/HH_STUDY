package system;

import service.Service;

import java.util.Scanner;

public class HRS {

    private static Service service = new Service();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        while (true) {

            System.out.println();
            System.out.println("-----欢迎进入HR简历管理系统-----");
            System.out.println("添加学生简历请按----1");
            System.out.println("删除学生简历请按----2");
            System.out.println("修改学生简历信息请按----3");
            System.out.println("显示学生简历信息请按----4");
            System.out.println("退出系统请按--------5");

            int choice = input.nextInt();
            switch (choice) {

                case 1:
                    service.addResume();
                    break;

                case 2:
                    service.delResume();
                    break;

                case 3:
                    service.updateResume();
                    break;

                case 4:
                    service.showResume();
                    break;

                case 5:
                    input.close();
                    service.closeService("bye");// 流啊 连接啊 这些东西 用完记得关；要么记得还（那么什么地方是需要还的，什么地方是关的）；
                    System.out.println("您已经退出HR简历管理系统");
                    return;

                default:
                    System.out.println("输入错误，请重新输入");
                    break;
            }
        }
    }
}
