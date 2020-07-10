package com.pan.exer;

public class Person1Test {
	public static void main(String[] args) {
		//1.创建类，设计类的成员（已在Person1类中完成）
		//2.创建类的对象
		Person1 p1 = new Person1();
		//3.调用类的属性和方法
		p1.name="panppy";
		p1.age=18;
		p1.sex=1;
		
		p1.study();
		p1.showAge();
		int newAge =p1.addAge(3);
		System.out.println(p1.name+"的新年龄为"+ newAge);
		System.out.println(p1.age);//21
		
		//**********************************************
		//4.创建第二个对象，重复以上操作，体会类中不同对象之间的关系
		Person1 p2=new Person1();
		p2.showAge();//0----->默认值（内存解析）
		p2.addAge(2);//2----->在默认值的基础上加2
		
		
	}

}
