package com.pan.exer;
/*
 * 定义类KidsTest，
 * 在类的main方法中实例化Kids的对象someKid，
 * 用该对象访问 其父类的成员变量及方法。
 */
public class KidsTest {
	public static void main(String[] args) {
		Kids someKid = new Kids();
		someKid.setSex(0);
		someKid.setSalary(0);
		someKid.setYearsOld(12);
		someKid.employeed();
		someKid.manOrWomen();
		someKid.printAge();
		
	}

}
