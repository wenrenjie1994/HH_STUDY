package  HRS;

import java.util.Scanner;
import model.JobHunter;
import model.Operator;
import model.HRSDatabase;

public class HRS
{
    public static void main(String[] args)
    {
        //HRSDatabase.CreateDatabase("hrsdatabase");
        //HRSDatabase.CreateTable("hrsdatabase","jobhunter");
        //创建系统选项
        System.out.println("----------欢迎使用该HR系统！----------");
        System.out.println("*************功能表***********");
        System.out.println("添加求职者信息：1");
        System.out.println("删除求职者信息：2");
        System.out.println("修改求职者信息：3");
        System.out.println("查询求职者信息：4");
        System.out.println("退出系统：q");
        System.out.println("*****************************");
        Scanner scan = new Scanner(System.in);//获取用户输入
        String ui = null;
        Operator operator = new Operator();
        Boolean run = true;
        do
        {
            System.out.println("请选择功能：");
            ui = scan.next();
            switch(ui)
            {
                case "1":
                {
                    operator.addJobHunterInf("hrsdatabase","jobhunter");

                }break;
                case "2":
                {
                    operator.deleteJobHunterInf("hrsdatabase","jobhunter");
                }break;
                case "3":
                {
                    operator.changeJobHunterInf("hrsdatabase","jobhunter");
                }break;
                case "4":
                {
                    operator.queryJobHunterInf("hrsdatabase","jobhunter");
                }break;
                case "q":
                    run = false; break;
                default:
                    System.out.println("输入指令错误,请重新输入：");
            }
        }while (run);
        scan.close();
        System.out.println("您已退出系统");
    }
}
