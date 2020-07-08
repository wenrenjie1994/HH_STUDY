package basic.method.demo1.day2;
/*
用代码模拟猜数字小游戏
*/

import java.util.Random;
import java.util.Scanner;

public class Demo02Random {
    public static void main(String[] args) {
        Random r = new Random();
        int randomNum = r.nextInt(100) + 1;

        Scanner src = new Scanner(System.in);

        while (true) {
            System.out.println("请输入你要猜测的数字");
            int guessNum = src.nextInt();

            if (guessNum > randomNum) {
                System.out.println("太大了请重试");
            } else if (guessNum < randomNum) {
                System.out.println("太小了请重试");
            } else {
                System.out.println("恭喜你猜中了");
                break;
            }

        }
        System.out.println("游戏结束");
    }
}
