package com.pan.exer;
/*
 * 在PersonTest类中实例化Person类的对象b， 调用setAge()和 getAge()方法，体会Java的封装性。 
 */
public class PersonTest {
public static void main(String[] args) {
	Person b=new Person();
	b.setAge(12);
	System.out.println(b.getAge());
	
}
}
