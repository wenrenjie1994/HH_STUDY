package com.pan.exer;

public class Person1 {
	/*
	 * 1.创建Person类的对象，
	 * 设置该对象的name、 age和sex属性
	 */
	String name;
	int age;
	/**
	 * sex=0:男性
	 * sex=1:女性
	 */

	int sex;

	/*
	 * 2.调用study方法，输出字符串 “studying”
	 */
	public void study() {
		System.out.println("studing!");
	}

	/*
	 * 3.调用showAge方法，显示age值
	*/	
	public void showAge() {
		System.out.println("age is "+age);
	}

	
	/*
	 * 4.调用 addAge()方法给对象的age属性值增加2岁。
	 */
	public int addAge(int i) {
		age+=i;
		return age;
	}

}
