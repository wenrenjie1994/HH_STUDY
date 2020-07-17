package  HRS;

import java.util.Scanner;
import model.JobHunter;
import model.Operate;
public class HRS
{
    public static void main(String[] args)
    {
        //创建系统选项
        System.out.println("----------欢迎使用该HR系统！----------");
        System.out.println("添加求职者信息：1");
        System.out.println("删除求职者信息：2");
        System.out.println("修改求职者信息：3");
        System.out.println("查询求职者信息：4");
        System.out.println("退出系统：5");
        Scanner scan = new Scanner(System.in);//获取用户输入
        String ui = null;
        Boolean run = true;
        do
        {
            ui = scan.next();
            switch(ui)
            {
                case "1":
                    Operate.addJobHunterInf(); break;
                case "2":
                   Operate.deleteJobHunterInf(); break;
                case "3":
                    Operate.changeJobHunterInf(); break;
                case "4":
                    Operate.queryJobHunterInf(); break;
                case "5":
                    run = false; break;
                default:
                    System.out.println("输入指令错误");
            }
        }while (run);
        scan.close();
        System.out.println("您已退出系统");
    }
}
