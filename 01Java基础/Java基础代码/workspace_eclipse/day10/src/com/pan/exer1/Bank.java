package com.pan.exer1;

public class Bank {
	
	private Customer[] customers;//存放多个客户的数组
	//难点：对象数组
	private int numberOfCustomer;//记录客户的个数（和数组长度不相同）
	
	public Bank() {
		customers = new Customer[10];
	}
	
	//添加客户
	public void addCustomer(String f,String l) {

		//我的写法
//		customers[numberOfCustomer]= new Customer(f,l);
//		numberOfCustomer += 1;
		
		//老师的写法一：
//		Customer cust=new Customer(f,l);
//		customers[numberOfCustomer]=cust;
//		numberOfCustomer++;
		
		//老师的写法二：
		Customer cust=new Customer(f,l);
		customers[numberOfCustomer++]=cust;
		
		
	}
	
	//获取客户的个数
	public int getNumberOfCustomers() {
		return numberOfCustomer;
	}
	
	//获取指定位置上的客户
	public Customer getCustomer(int index) {
		if(index>=0 && index <numberOfCustomer) {
			return customers[index];
		}
		else {
			return null;
		}
		
		
		
	}

}
