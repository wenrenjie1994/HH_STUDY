package com.spdb.lowbhrsys.client.operator;

import com.spdb.lowbhrsys.client.net.Client;
import com.spdb.lowbhrsys.controller.ResumeRunController;
import com.spdb.lowbhrsys.utils.ResumeFileDataOperate;
import com.spdb.lowbhrsys.utils.ResumeMemory;

import java.util.Scanner;

/**
 * @author: libobo
 * @create: 2020-07-15 19:16
 * @description:
 **/
public class Operator {
    public static Client client=new Client();

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        while(true){
            System.out.println("-----欢迎进入李伯伯的low逼hr系统-----");
            System.out.println("添加简历请按----1");
            System.out.println("删除简历请按----2");
            System.out.println("修改简历请按----3");
            System.out.println("查询简历请按----4");
            System.out.println("查看所有简历----5");
            System.out.println("退出请按--------6");
            int choice=input.nextInt();
            switch (choice){
                case 1:
                    ResumeController.addResume();
                    break;
                case 2:
                    ResumeController.delResume();
                    break;
                case 3:
                    ResumeController.updateResume();
                    break;
                case 4:
                    ResumeController.findResume();
                    break;
                case 5:
                    ResumeController.showAllResume();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
            }
            if (choice==6){
                ResumeController.closeServer();
                client.closeClient();
                break;
            }


        }
        input.close();
        System.out.println("您已经退出系统！");
    }
}
