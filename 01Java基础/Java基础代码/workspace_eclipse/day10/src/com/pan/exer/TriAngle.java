package com.pan.exer;
/*
 * 编写两个类，TriAngle和TriAngleTest，
 * 其中TriAngle类中声明私有的底 边长base和高height，同时声明公共方法访问私有变量。
 * 此外，提供类 必要的构造器。
 * 另一个类中使用这些公共方法，计算三角形的面积。
 * 
 */
public class TriAngle {
	private double base;
	private double height;
	
	public TriAngle(double m, double n) {
		base = m;
		height = n;
	}
	
	
	public double getBase() {
		return base;
	}
	
	public double getHeight() {
		return height;
	}

}
