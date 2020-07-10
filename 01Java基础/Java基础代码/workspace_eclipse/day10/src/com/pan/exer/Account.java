package com.pan.exer;
/*
 * 写一个名为 Account 的类模拟账户。该类的属性和方法如下图所示。
 * 该类包括的属性： 账号 id，余额 balance，年利率 annualInterestRate；
 * 包含的方法：访问器方法（getter 和 setter 方法），取款方法 withdraw()，存款方法 deposit()。 
 */
public class Account {
	private int id;
	private double balance;
	private double annualInterstRate;
	
	

	public Account() {
		
	}

	public Account(int id, double balance, double annualInterstRate) {
		this.id = id;
		this.balance = balance;
		this.annualInterstRate = annualInterstRate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterstRate() {
		return annualInterstRate;
	}

	public void setAnnualInterstRate(double annualInterstRate) {
		this.annualInterstRate = annualInterstRate;
	}
	
	public void withdraw (double amount) {//取钱 
	if(amount > balance) {
		System.out.println("余额不足，取款失败");
		return;
	}
	balance -= amount;
	System.out.println("成功取出："+amount);
	}
	
	public void deposit (double amount) {//存钱 
		System.out.println("成功存入："+amount);
		balance += amount;
	}
}
