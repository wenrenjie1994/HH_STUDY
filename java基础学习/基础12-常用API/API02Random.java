package highLevel;

import java.util.Random;

/*
Random类用来生成随机数字
Random类使用步骤：
	1、导包：import java.util.Random
	2、创建：Random r = new Random();
	3、使用：
		a.获取一个随机的int数字(范围是int的取值范围，正负都有)：int num = r.nextInt();
		b.获取一个随机的int数字（参数代表了范围，左闭右开区间）：int num = r.nextInt(3);//实际代表取[0,3)，即0-2
 */
public class API02Random {

	public static void main(String[] args) {
		//创建一个范围不限的随机数
		Random r1 = new Random();
		int num1 = r1.nextInt();
		System.out.println("随机数是：" + num1);
		System.out.println("============");
		
		//创建限制范围以内的一个随机数
		Random r2 = new Random();
		int num2 = r2.nextInt(24);//范围0-23
		System.out.println("随机数是：" + num2);
		
/*
* 题目：根据int变量n的值，获取随机数字，范围是[1,n]
* 思路：
* 	1、定义一个int变量n，随意赋值
* 	2、使用Random类，导包、创建、使用
* 	3、如果写写nextInt(10)，那随机范围是[0,9),想要1-10则整体+1即可
* 	4、打印随机数字
*/
		Random r3 = new Random();
		int n = 10;
		
		int result = r3.nextInt(n) + 1; //本来范围是[0,n)，整体+1以后变成了[1,n+1),也就是[1,n]
		System.out.println("随机数是：" + result);
		
	}

}
