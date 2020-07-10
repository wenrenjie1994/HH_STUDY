package com.pan.p2.bean;

public class CustomerTest {
	public static void main(String[] args) {
		Customer cust = new Customer("Tom", '男', 18, "1331232", "123");
		System.out.println(cust.getAge());
		
	}

}
