package com.pan.exer;
/*
 * 写一个测试程序。 
 * （1） 创建一个 Customer ，名字叫 Jane Smith, 
 * 他有一个账号为 1000，余额为 2000 元， 年利率为 1.23％ 的账户。
 * （2） 对 Jane Smith 操作。 存入 100 元，再取出 960 元。再取出 2000 元。 
 * （3）打印出 Jane Smith 的基本信息 
 * 
 * 
 */

public class AccountCustomerTest {
	public static void main(String[] args) {
		Customer c1 = new Customer("Jane", "Smith");//要加双引号！！！！！

		Account a1 = new Account(1000,2000,0.0123);
		
		//我自己的做法：没把customer和account建立联系
//		a1.deposit(100);
//		a1.withdraw(960);
//		a1.withdraw(2000);
		
		//老师的做法：
		c1.setAccount(a1);
		c1.getAccount().deposit(100);
		c1.getAccount().withdraw(960);
		c1.getAccount().withdraw(2000);
		
		System.out.println("Customer ["+c1.getLastName()
		+","+c1.getFirstName()+"] has a account: id is "
		+a1.getId()+", annualInteretRate is "
		+a1.getAnnualInterstRate()*100+"%"
		+", balance is "+a1.getBalance());
		
	}

}
