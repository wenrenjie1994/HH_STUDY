package practice;
/*
练习题1：定义一个方法，用来判断两个数字是否相同
练习题2：定义一个方法，求出1-100之间所有数字的和
练习题3：定义一个方法，打印指定次数的java
 */
public class Demo21MethodPractice {

	public static void main(String[] args) {
		//调用isSame()方法
		boolean same = isSame(10,20);
		System.out.println(same);
		
		System.out.println("==========");
		
		//调用sum()方法
		System.out.println("1-100之间求和结果是：" + sum());
		
		System.out.println("==========");
		
		//调用print()方法
		print(3);
	}
	
	//定义一个方法，用来判断两个数字是否相同
	public static boolean isSame(int a, int b) {
		return a==b;
	}
	
	//定义一个方法，求出1-100之间所有数字的和
	public static int sum() {
		int sum1 = 0;
		for(int i = 1; i<=100;i++) {
			sum1 +=i;
		}
		return sum1;	
	}
	
	//定义一个方法，打印指定次数的java
	public static void print(int num) {
		for(int i = 1; i <= num; i++) {
			System.out.println("java" + i);
		}
	}

}
