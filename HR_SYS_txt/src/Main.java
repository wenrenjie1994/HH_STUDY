import bean.ResumeList;
import sys.HRS;
import utils.DataOperate;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //HRS hrs = new HRS();
        ResumeList resumeList = new ResumeList();
        DataOperate.loadData(resumeList);
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
                    HRS.addResume(resumeList);
                    break;
                case 2:
                    HRS.deleteResume(resumeList);
                    break;
                case 3:
                    HRS.updateResume(resumeList);
                    break;
                case 4:
                    HRS.selectResume(resumeList);
                    break;
                case 5:
                    HRS.showResume(resumeList);
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
