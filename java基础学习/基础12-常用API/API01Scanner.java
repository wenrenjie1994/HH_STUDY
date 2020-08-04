package highLevel;

import java.util.Scanner;

/*
Scanner类:一个可以解析基本类型和字符串的简单文本扫描器，用于实现从键盘录入数据

引用类型的一般使用步骤：
	1、导包：import 包路径.类名称;
		a.如果需要导入的类和当前类位于同一个包下，则可以省略导包语句不写
		b.只有java.lang包下的内容不需要导包，其他的包都需要import语句
	2、创建new：类名称 对象名 = new 类名称();
	3、使用：对象名.成员方法名();
		
*/
public class API01Scanner {

	public static void main(String[] args) {
		/*
		题目一：
			键盘输入两个int数字，并求出和值
		思路：
			1、要键盘输入就要适用Scanner类
			2、Scanner的使用步骤：导包、创建、使用
			3、需要两个数字则需调用两次nextInt()方法
			4、两个数字求和
			5、将结果打印输出
		 */
		Scanner sc1 = new Scanner(System.in);
		
		System.out.println("请输入第一个数字：");
		int a = sc1.nextInt();
		System.out.println("请输入第二个数字：");
		int b = sc1.nextInt();
		
		int result = a + b;
		System.out.println("结果是：" + result);
		System.out.println("===============");
		
		/*
		题目二：
			键盘输入三个int数字，并求出最大值
		思路：
			1、要键盘输入就要适用Scanner类
			2、Scanner的使用步骤：导包、创建、使用
			3、需要三个数字则需调用三次nextInt()方法
			4、三个数字比较最大值
			5、将结果打印输出
		 */
		Scanner sc2 = new Scanner(System.in);
		
		System.out.println("请输入第一个数字：");
		int h = sc2.nextInt();
		System.out.println("请输入第二个数字：");
		int j = sc2.nextInt();
		System.out.println("请输入第三个数字：");
		int k = sc2.nextInt();
		
		int temp = h > j ? h : j;
		int max = temp > k ? temp : k;
		
		System.out.println("最大值是：" + max);
	}

}
