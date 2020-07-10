package com.pan.exer;

public class PersonTest {
	public static void main(String[] args) {
		Person p1 = new  Person();
		//调用属性
		p1.name = "Tom";
		p1.age = 18;
		p1.sex = 1;

		//调用方法
		p1.study();
		p1.showAge();
		
		p1.addAge(2);
		p1.showAge();
		
		
//		Person p2 = new Person();
//		p2.showAge(4);
//		
	}
	

}
