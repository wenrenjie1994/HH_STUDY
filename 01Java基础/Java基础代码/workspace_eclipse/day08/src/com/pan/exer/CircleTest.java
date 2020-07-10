package com.pan.exer;

//测试类
public class CircleTest {
	public static void main(String[] args) {
		//2.创建类的对象
		Circle c1=new Circle();
		c1.radius=2.1;
		
        //对应方法一
		//double area1=c1.findArea();
		//System.out.println("圆的面积为"+area1);
		
		//方法二：
		c1.findArea();
	}

}

//circle类
//1.创建类及类的成员
class Circle{
	//属性
	double radius;
	//方法
	
	//方法一：有返回值
//	public double findArea() {
//		double area=Math.PI*radius*radius;
//		return area;
	
	//方法二：没有返回值
	public void findArea() {
		double area=Math.PI*radius*radius;
		System.out.println("圆的面积是："+area);
		return;
	}
	
}
