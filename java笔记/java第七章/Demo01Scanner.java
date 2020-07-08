package basic.method.demo1.day2;
import java.util.Scanner;
public class Demo01Scanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        System.out.println("输入的数字1是："+num1);
        int num2 = sc.nextInt();
        System.out.println("输入的数字2是："+num2);
        int sum = num1+num2;
        System.out.println("和是："+sum);
        System.out.println("======================");
        if(num1>=num2){
            System.out.println("最大数是："+num1);

        }
        else{
            System.out.println("最大数是"+num2);
        }
    }
}
