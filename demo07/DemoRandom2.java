package fu.day04.demo07;

import java.util.Random;
import java.util.Scanner;

/*
题目：数字查找（二分法）

思路：
1.产生一个随机数，并保持不变
2.需要键盘输入，Scanner
3.获取键盘输入的数字，用Scanner.next.Int()
4.判断得到的两个数字 if
  如果大了，提示大了，重来
  如果小了，提示小了，从来
  如果对了，游戏结束
5.重试就是再来一次，循环次数不确定，用while(true)

 */
public class DemoRandom2 {
    public static void main(String[] args) {
        Random r=new Random();
        int num=r.nextInt(100)+1;//[1,100]
        Scanner sc=new Scanner(System.in);

         while (true){
             System.out.println("请输入一个数字");
             int guess=sc.nextInt();
             if (guess>num){
                 System.out.println("太大了，请重试");
             }else if (guess<num){
                 System.out.println("太小了，请重试");
             }else {
                 System.out.println("猜对了");
                 break;
             }
         }
        System.out.println("游戏结束");
    }
}
