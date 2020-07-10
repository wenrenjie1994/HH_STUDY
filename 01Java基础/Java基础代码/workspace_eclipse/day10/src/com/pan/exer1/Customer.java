package com.pan.exer1;

public class Customer {
	private String firstName;
	private String lastName;
	private Account account; 
	//难点：在自定义类中，可以声明另一个类的属性——关联关系
	public Customer(String f, String l) {
		this.firstName = f;
		this.lastName = l;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
			this.account = account;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	
	
	

}
