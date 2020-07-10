package com.pan.exer;

public class AreaTest {
public static void main(String[] args) {
	Area a = new Area();
	a.r = 2.1;
	//方法调用方式一：
//	double area = a.findArea();
//	System.out.println("面积为：" + area);
//	
	//方法调用方式二：
	a.findArea();
}
}
