package com.testHR.web;

import com.testHR.service.ResumeService;
import com.testHR.service.impl.ResumeServiceImpl;

import java.util.Scanner;

/**
 * @description:
 * @author: zeng
 * @modified By:
 */
public class HrSystem {
    HrSystem(){
        Scanner input = new Scanner(System.in);
        ResumeService resumeService = new ResumeServiceImpl();
        while (true){
            System.out.println("-------欢迎来到HR系统 1.0-------");
            System.out.println("-------添加简历请输入1----------");
            System.out.println("-------删除简历请输入2----------");
            System.out.println("-------修改简历请输入3----------");
            System.out.println("-------查找简历请输入4----------");
            System.out.println("-------退出系统请输入5----------");
            int choice = input.nextInt();
            switch (choice){
                case 1:
                    resumeService.addResume();
                    break;//直接跳出switch
                case 2:
                    resumeService.deleteResume();
                    break;
                case 3:
                    resumeService.updateResume();
                    break;
                case 4:
                    resumeService.searchResume();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("您的输入有误，请重新输入！");
            }
            if(choice == 5){
                break;//跳出while循环
            }
        }
        input.close();//关闭输入流
        System.out.println("您已经退出招聘系统！");
    }

    public static void main(String[] args) {
        new HrSystem();
    }
}
