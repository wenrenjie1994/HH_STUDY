package day06.demo;

import java.util.Random;
import java.util.Scanner;

/*随机数练习题：模拟猜数字小游戏*/
public class Demo2 {
    public static void main(String[] args) {
        Random random = new Random();
        int num = random.nextInt(100) + 1;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("请输入你的猜测的数字：");
            int guessnum = sc.nextInt();
            if (guessnum < num) {
                System.out.println("你输入的数字太小");
            } else if (guessnum > num) {
                System.out.println("你输入的数字太大");
            } else {
                System.out.println("恭喜你猜中了！");
                break;
            }


        }

        System.out.println("游戏结束");

    }
}
