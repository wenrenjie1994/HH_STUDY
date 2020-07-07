package com.caorui.hr;



import com.caorui.service.ApplicantService;

import java.io.IOException;
import java.util.Scanner;

public class Console {

    public static void choice() throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("输入1录入招聘者");
        System.out.println("输入2查询招聘者");
        System.out.println("输入3删除招聘者");
        System.out.println("输入4更改招聘者");
        int ch = sc.nextInt();
        if (ch == 1) {
            ApplicantService.insert();
        } else if (ch == 2) {
            ApplicantService.select();
        } else if (ch == 3) {
            ApplicantService.delete();
        } else if (ch == 4) {
            ApplicantService.update();
        }  else {
            System.out.println("输入有误，请重新输入");
        }

    }
    public static void main(String[] args) throws IOException {
        while (true) {
            choice();
        }
    }
}
