package com.pan.exer;
/*
 * 另一个类中使用这些公共方法，计算三角形的面积。
 */
public class TriAngleTest {
	public static void main(String[] args) {
		TriAngle t = new TriAngle(3.5,5);
		double m=t.getBase();
		double n=t.getHeight();
		System.out.println("面积为："+m*n/2);
		
	}

}
