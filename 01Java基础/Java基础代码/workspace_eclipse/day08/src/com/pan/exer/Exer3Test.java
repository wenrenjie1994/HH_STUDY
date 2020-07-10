package com.pan.exer;

/*3.1 编写程序，声明一个method方法，在方法中打印一个10*8 的*型矩形， 在main方法中调用该方法
 *3.2 修改上一个程序，在method方法中，除打印一个10*8的*型矩形外，再 计算该矩形的面积，并将其作为方法返回值。
 *	在main方法中调用该方法， 接收返回的面积值并打印。
 *3.3 修改上一个程序，在method方法提供m和n两个参数，方法中打印一个 m*n的*型矩形，并计算该矩形的面积，
 *  将其作为方法返回值。在main方法 中调用该方法，接收返回的面积值并打印
 */

public class Exer3Test {
	public static void main(String[] args) {
		Exer3 exer = new Exer3();
		//3.1
//		exer.method();
		
		//3.2
//		int area = exer.method();
//		System.out.println(area);
		
		//3.3
		int area = exer.method(12, 5);
		System.out.println(area);
	}

}
