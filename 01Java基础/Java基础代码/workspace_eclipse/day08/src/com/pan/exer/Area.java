package com.pan.exer;
/*
 * 利用面向对象的编程方法，设计类Circle计算圆的面积
 */
public class Area {
	//定义属性
	double r;
	
	//定义方法
	//方式一：
//	public double findArea() {
//		double area = Math.PI * r * r;
//		return area;
//	}
	
	//方式二：
	public void findArea() {
		double area = Math.PI * r * r;
		System.out.println("面积为：" + area);
	}

}
