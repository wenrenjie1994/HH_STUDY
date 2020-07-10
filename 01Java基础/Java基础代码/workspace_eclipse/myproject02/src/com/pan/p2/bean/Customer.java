package com.pan.p2.bean;

/**
 * 
 * Description Customer为实体对象，用来封装客户信息
 * 
 * @author Pan Email:zhaopan1848@163.com
 * @version
 * @date 2020年3月24日下午5:02:12
 */
public class Customer {
	private String name;
	private char gender; // 性别
	private int age;// 年龄
	String phone;// 电话号码
	String email;// 电子邮箱

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

}
