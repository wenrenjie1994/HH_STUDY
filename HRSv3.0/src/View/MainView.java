package View;

import Control.Control;

import java.util.Scanner;

/*
    用户操作界面
    数据传递给control层来实现功能
 */
public class MainView {
    private Control control = new Control();

    public void run(){
        Scanner sc = new Scanner(System.in);
        //boolean flag = true;
        while(true){
            System.out.println("---------欢迎进入HR系统v3.0---------");
            System.out.println("添加简历请按-----1");
            System.out.println("修改简历请按-----2");
            System.out.println("删除简历请按-----3");
            System.out.println("查询简历请按-----4");
            System.out.println("退出系统请按-----5");
            System.out.println("请输入要进行的操作【1-5】：");
            int op = sc.nextInt();
            switch (op){
                case 1:
                    //增加数据
                    control.addResume();
                    break;
                case 2:
                    //修改数据
                    control.editResume();
                    break;
                case 3:
                    //删除数据
                    control.deleteResume();
                    break;
                case 4:
                    //查询数据
                    control.selectResume();
                    break;
                case 5:
                    //退出系统
                    System.out.println("感谢使用，您已退出HR系统v3.0！");
                    System.exit(0);
                    break;
                default:
                    System.out.println("你的输入有误，请重新输入！");
            }
        }
    }
}
