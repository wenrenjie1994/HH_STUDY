package practice;
/*
注意：
	1、对于有返回值的方法，可以使用单独调用、打印调用、或者赋值调用
	2、对于无返回值的方法，只能试用单独调用，不能试用打印调用和赋值调用

题目要求:1、定义一个方法，求出两个数字之和，并返回结果（属于有返回值的类型）
		2、定义一个方法，打印出两个数字之和（属于无返回值的类型）
 */
public class Demo20MethodReturn {

	public static void main(String[] args) {
		//getSum(10,20)的结果返回给num
		int num = getSum(10,20);
		
		//无返回值的打印结果
		printSum(10,20);

	}
	
	//定义一个方法，求出两个数字之和，并返回结果（属于有返回值的类型）
	public static int getSum(int a,int b) {
		int result = a + b;
		return result;
	}
	
	//定义一个方法，打印出两个数字之和（属于无返回值的类型）
	public static void printSum(int a,int b) {
		int result = a + b;
		System.out.println("结果是:"+ result);
	}

}
