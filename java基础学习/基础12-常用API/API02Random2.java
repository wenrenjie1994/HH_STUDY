package highLevel;

import java.util.Random;
import java.util.Scanner;

/*
题目：用代码模拟猜数字的小游戏
思路：
	1、首先需要产生一个随机数字，并且一旦产生不再变化，用Random的nextInt方法
	2、需要键盘输入，用Scanner
	3、获取键盘输入的数字，用Scanner中的nextInt方法
	4、将键盘输入的数字与随机数比较，如果太大，提示太大并重输、如果太小，提示太小并重输、如果猜中，游戏结束
	5、重输就是再来一次，循环次数不确定，用while(true)
 */
public class API02Random2 {

	public static void main(String[] args) {
		Random r = new Random();
		int randomNum = r.nextInt(100) + 1; //范围1-100
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("请输入你猜测的数字：" );
			int guessNum = sc.nextInt();
		
			
			if(guessNum > randomNum) {
				System.out.println("太大了，请重试");
			}else if(guessNum < randomNum) {
				System.out.println("太小了，请重试");
			}else {
				System.out.println("恭喜你猜对啦！");
				break; //如果猜中，不再重试
			}
		}
		
		System.out.println("游戏结束！");
		
		

	}

}
