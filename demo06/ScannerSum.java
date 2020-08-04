package fu.day04.demo06;
/*
题目：键盘输入两个int数字，并且求出和值。

思路：

 */
import java.util.Scanner;
public class ScannerSum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num1=sc.nextInt(),num2=sc.nextInt();
        int sum=num1+num2;
        System.out.println("结果是："+sum);

    }
}
