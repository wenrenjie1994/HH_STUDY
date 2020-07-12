package day07.demo;

import java.util.Scanner;

/*
题目：
键盘输入一个字符串，并统计各种字符出现的次数
种类有：大写字母、小写字母、数字、其他
*/
public class practice02 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        method(str);

    }

    public static  void method(String str){
       int len=str.length();
       int d=0;
       int x=0;
       int n=0;
       int q=0;
        for (int i = 0; i < len; i++) {
            char a=str.charAt(i);
            if(a>='A'&&a<='Z'){
                d++;
            }else if(a>='a'&&a<='z') {
                x++;
            }else if(a>='0'&&a<='9'){
                n++;
            }else{
                q++;
            }
        }
        System.out.println("大写字母有："+d+"个");
        System.out.println("小写字母有："+x+"个");
        System.out.println("数字有："+n+"个");
        System.out.println("其他有："+q+"个");

    }
}
