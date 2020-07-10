package com.pan.exer;
/*
 * a. 声明三个私有对象属性：firstName、lastName 和 account。 
 * b. 声明一个公有构造器，这个构造器带有两个代表对象属性的参数（f 和 l） 
 * c. 声明两个公有存取器来访问该对象属性，方法 getFirstName 和 getLastName 返回相应的属 性。 
 * d. 声明 setAccount 方法来对 account 属性赋值。
 * e. 声明 getAccount 方法以获取 account 属性。 
 * 
 * 
 */
public class Customer {
	private String firstName; 
	private String lastName ;
	private Account account ;
	
	


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
