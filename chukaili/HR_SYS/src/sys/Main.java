package sys;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //创建管理系统对象
        HRSYS hrsys = new HRSYS();
        //获取标准输入流
        Scanner input = new Scanner(System.in);

        flag:
        while (true) {
            System.out.println("-----欢迎进入内存控制台的HR管理系统-----");
            System.out.println("-----添加学生信息请按----1");
            System.out.println("-----删除学生信息请按----2");
            System.out.println("-----修改学生信息请按----3");
            System.out.println("-----查询学生信息请按----4");
            System.out.println("-----展示所有学生信息请按-5");
            System.out.println("-----退出请按----------6");

            //此处用switch代替if实现逻辑判断
            switch (input.nextInt()) {
                case 1:
                    hrsys.addCandidate();
                    break;
                case 2:
                    hrsys.deleteCandidate();
                    break;
                case 3:
                    hrsys.updateCandidate();
                    break;
                case 4:
                    hrsys.searchCandidate();
                    break;
                case 5:
                    hrsys.showCandidate();
                    break;
                case 6:
                    break flag;
                default:
                    System.out.println("输入错误，请重新输入");
            }
        }
        System.out.println("您已经退出图书管理系统");
        input.close(); //关闭输入流
    }
}
