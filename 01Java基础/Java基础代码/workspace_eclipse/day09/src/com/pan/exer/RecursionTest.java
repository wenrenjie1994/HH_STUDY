package com.pan.exer;
/*
 * 已知一个数列：f(20) = 1,f(21) = 4,f(n+2) = 2*f(n+1)+f(n), 
 * 其中n是大于0的整数，求f(10)的值。
 * 
 */
public class RecursionTest {
	public static void main(String[] args) {
		RecursionTest test = new RecursionTest();
		System.out.println(test.f(10));
		
		System.out.println(test.fab(6));
		
	}
	
	public int f(int n) {
		
		if (n==0) {
			return 1;
		}
		else if(n==1) {
			return 4;
		}
		else {
			return 2*f(n-1)+f(n-2);
		}
	}
	
	/*
	 * 输入一个数据n，计算斐波那契数列(Fibonacci)的第n个值 
	 * 1  1  2  3  5  8  13  21  34  55 
	 * 规律：一个数等于前两个数之和 要求：计算斐波那契数列(Fibonacci)的第n个值，并将整个数列打印出来
	 */
	public int fab(int n) {
		int sum=0;
		if(n==1||n==2) {
			sum=1;
			return sum;
		}
		else {
			return fab(n-1)+fab(n-2);
		}
		
	}
	
	
}
