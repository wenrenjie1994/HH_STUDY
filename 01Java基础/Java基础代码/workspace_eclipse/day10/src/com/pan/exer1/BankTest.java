package com.pan.exer1;
/*
 * 写一个测试程序。 
 * （1） 创建一个 Customer ，名字叫 Jane Smith, 
 * （2） 对 Jane Smith 操作。 存入 100 元，再取出 960 元。再取出 2000 元。 
 * （3）打印出 Jane Smith 的基本信息 
 */
public class BankTest {
	public static void main(String[] args) {
		Bank bank = new Bank();
		bank.addCustomer("Jane", "Smith");
		
		//难点：连续操作
		bank.getCustomer(0).setAccount(new Account(2000));
		bank.getCustomer(0).getAccount().withdraw(500);
		double balance = bank.getCustomer(0).getAccount().getBanlance();
		
		System.out.println("客户："+bank.getCustomer(0).getFirstName()+"的账户余额为："+balance);
	}
}
