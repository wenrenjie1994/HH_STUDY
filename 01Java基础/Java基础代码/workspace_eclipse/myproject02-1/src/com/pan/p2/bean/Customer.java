package com.pan.p2.bean;
/*
 * Customer为实体类，用来封装客户信息
	 该类封装客户的以下信息：
	String name ：客户姓名
	char gender  ：性别
	int age          ：年龄
	String phone：电话号码
	String email ：电子邮箱
	 提供各属性的get/set方法
	 提供所需的构造器（可自行确定）
 */
public class Customer {
	private String name;
	private char gender;
	private int age;
	private String phone;
	private String email;
	
	public Customer() {
	
	}

	public Customer(String name, char gender, int age, String phone, String email) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	//main方法写在里面也可以
//	public static void main(String[] args) {
//		Customer cust = new Customer("Tom", '男', 18, "1331232", "123");
//		System.out.println(cust.name);
//	}
	
}

//为什么不能在下面造一个类来调用main函数呢？
//在包中另写一个CustomerTest类就可以
//class CustomerTest{
//	public static void main(String[] args) {
//		Customer cust = new Customer();
//		System.out.println(cust.name);
//	}
//}



