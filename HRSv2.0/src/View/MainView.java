package View;

import java.util.*;
import Resume.StudentInformation;
import Service.Service;
import Service.ReadWrite;

public class MainView {
    public static void main(String[] args) {
        ArrayList<StudentInformation> stinfo= new ArrayList<>();
        HRS_v1(stinfo);
    }

    public static void HRS_v1(ArrayList<StudentInformation> stinfo){
        //读取txt文件
        ReadWrite.ReadData(stinfo);
        //接收键盘输入
        Scanner sc = new Scanner(System.in);
        //设置flag判断是否退出系统
        boolean flag = true;
        while(flag){
            System.out.println("---------欢迎进入HR系统v2.0---------");
            System.out.println("添加简历请按-----1");
            System.out.println("修改简历请按-----2");
            System.out.println("删除简历请按-----3");
            //查询所有简历若想按id顺序排序该如何实现：是不是可以把arraylist换成properties或map，遍历有序的key
            System.out.println("查询简历请按-----4");
            System.out.println("保存现有数据请按-----5");
            System.out.println("退出系统请按-----6");
            System.out.println("请输入要进行的操作【1-6】：");
            int op = sc.nextInt();
            switch (op){
                case 1:
                    Service.addResume(stinfo);
                    break;
                case 2:
                    Service.editResume(stinfo);
                    break;
                case 3:
                    Service.deleteResume(stinfo);
                    break;
                case 4:
                    Service.selectResume(stinfo);
                    break;
                case 5:
                    ReadWrite.WriteData(stinfo);
                    System.out.println("数据已存档！");
                    break;
                case 6:
                    ReadWrite.WriteData(stinfo);
                    flag = false;
                    System.out.println("感谢使用，您已退出HR系统v2.0！");
                    break;
                default:
                    System.out.println("你的输入有误，请重新输入！");
            }
        }
    }

}
