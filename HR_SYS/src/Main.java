import sys.HRS;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HRS hrs = new HRS();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("-----欢迎进入lowB简历管理系统-----");
            System.out.println("添加简历请按----1");
            System.out.println("删除简历请按----2");
            System.out.println("修改简历请按----3");
            System.out.println("查询简历请按----4");
            System.out.println("所有简历请按----5");
            System.out.println("退出请按--------6");

            int operate = scanner.nextInt();

            switch (operate){
                case 1:
                    hrs.addResume();
                    break;
                case 2:
                    hrs.deleteResume();
                    break;
                case 3:
                     hrs.updateResume();
                    break;
                case 4:
                    hrs.selectResume();
                    break;
                case 5:
                    hrs.showResume();
                    break;
                case 6:
                    System.out.println("欢迎下次使用");
                    scanner.close();
                    return;

                default:
                    System.out.println("输入错误请重新输入");
            }

        }
    }
}
