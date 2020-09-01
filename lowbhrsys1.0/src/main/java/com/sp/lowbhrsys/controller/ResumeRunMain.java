package com.sp.lowbhrsys.controller;

import com.sp.lowbhrsys.utils.ResumeFileDataOperate;
import com.sp.lowbhrsys.utils.ResumeMemory;

import java.util.Scanner;

/**
 * @author: libobo
 * @create: 2020-07-03 15:47
 * @description:
 **/

public class ResumeRunMain {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        //基于文件保存数据需要以下两行
        ResumeFileDataOperate r=new ResumeFileDataOperate();
        r.downloadData(ResumeMemory.list);

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
                    ResumeRunController.addResume();
                    break;
                case 2:
                    ResumeRunController.delResume();
                    break;
                case 3:
                    ResumeRunController.updateResume();
                    break;
                case 4:
                    ResumeRunController.findResume();
                    break;
                case 5:
                    ResumeRunController.showStudent();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
            }
            if (choice==6){
                //基于文件保存数据需要该行，将内存中的数据进行文件持久化
                r.saveData(ResumeMemory.list);
                break;
            }


        }
        input.close();
        System.out.println("您已经退出系统！");
    }

}
