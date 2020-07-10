package com.pan.exer1;

public class Account {
	private double balance;
	
	public Account(double init_balance) {
		balance=init_balance;
	}
	
	public double getBanlance() {
			return balance;
	}
	
	public void deposit(double amt) {
		if (amt > 0) {
			balance += amt;
			System.out.println("存钱成功！");
			return;
		}
		System.out.println("存钱失败！");
	}
	
	public void withdraw(double amt) {
		if(amt > 0 && amt <= balance ) {
			balance -= amt;
			System.out.println("取钱成功！");
			return;
		}
		System.out.println("取钱失败！");
	}

}
