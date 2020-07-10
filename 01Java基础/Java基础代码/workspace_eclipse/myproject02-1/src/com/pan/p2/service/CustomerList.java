package com.pan.p2.service;

import com.pan.p2.bean.Customer;

/*
 * CustomerList为Customer对象的管理模块，内部使用数组管理一组Customer对象
	本类封装以下信息：
	Customer[] customers：用来保存客户对象的数组
	int total = 0                 ：记录已保存客户对象的数量
	该类至少提供以下构造器和方法：
	public CustomerList(int totalCustomer) 
	public boolean addCustomer(Customer customer) 
	public boolean replaceCustomer(int index, Customer cust)
	public boolean deleteCustomer(int index)
	public Customer[] getAllCustomers() 
	public Customer getCustomer(int index) 
	public int getTotal()

 */
public class CustomerList {

	// 用来保存客户对象的数组
	private Customer[] customers;
	// 记录已保存客户对象的数量
	//老师是在定义的时候就初始化了total的初值，我是在构造器内定义的
	private int total=0;

	/*
	 * 用途：构造器，用来初始化customers数组 参数：totalCustomer：指定customers数组的最大空间
	 */
	/**
	 * 用途：构造器，用来初始化customers数组
	 * @param totalCustomer 指定customers数组的最大空间
	 */
	public CustomerList(int totalCustomer) {
		customers = new Customer[totalCustomer];//动态初始化
//		total = 0;
		customers[0] = new Customer("Tom", '男', 18, "131", "12@123");
		total += 1;
	}

	/*
	 * 用途：将参数customer添加到数组中最后一个客户对象记录之后 参数：customer指定要添加的客户对象
	 * 返回：添加成功返回true；false表示数组已满，无法添加
	 */
	/**
	 * 
	 * Description 将参数customer添加到数组中最后一个客户对象记录之后
	 * @author Pan  Email:zhaopan1848@163.com
	 * @date 2020年3月29日上午9:33:15
	 * @param customer 指定要添加的客户对象
	 * @return 添加成功返回true；false表示数组已满，无法添加
	 */
	public boolean addCustomer(Customer customer) {
		//我写的
//		if (total + 1 <= customers.length) {
//			customers[total] = customer;
//			total += 1;
//			return true;
//		} else {
//			return false;
//		}
		//老师写的
		if(total >= customers.length) {
			return false;
		}
		customers[total++]=customer;
		return true;

	}

	/*
	 * 用途：用参数customer替换数组中由index指定的对象 参数：customer指定替换的新客户对象
	 * ,index指定所替换对象在数组中的位置，从0开始 返回：替换成功返回true；false表示索引无效，无法替换
	 */
	/**
	 * 
	 * Description 用参数customer替换数组中由index指定的对象 
	 * @author Pan  Email:zhaopan1848@163.com
	 * @date 2020年3月29日上午9:37:37
	 * @param index 指定所替换对象在数组中的位置，从0开始 返回
	 * @param cust customer指定替换的新客户对象
	 * @return 替换成功返回true；false表示索引无效，无法替换
	 */
	public boolean replaceCustomer(int index, Customer cust) {
		//我写的
//		if (index >= 0 && index <= total - 1) {
//			customers[index] = cust;
//			return true;
//		} else {
//			return false;
//		}
		//老师写的
		if(index <0 || index >=total) {
			return false;
		}
		customers[index] = cust;
		return true;

	}

	/*
	 * 用途：从数组中删除参数index指定索引位置的客户对象记录 参数： index指定所删除对象在数组中的索引位置，从0开始
	 * 返回：删除成功返回true；false表示索引无效，无法删除
	 */
	/**
	 * 
	 * Description 从数组中删除参数index指定索引位置的客户对象记录 
	 * @author Pan  Email:zhaopan1848@163.com
	 * @date 2020年3月29日上午9:40:38
	 * @param index 指定所删除对象在数组中的索引位置，从0开始
	 * @return 返回：删除成功返回true；false表示索引无效，无法删除
	 */
	public boolean deleteCustomer(int index) {
		//我写的
//		if (index >= 0 && index <= total) {
//			for (int i = index; i < total - 1; i++) {
//				customers[i] = customers[i + 1];
//			}
//			customers[total - 1] = null;
//			total -= 1;
//			return true;
//		} else {
//			return false;
//		}
		//老师写的
		if(index <0 || index >=total) {
			return false;
		}
		for (int i = index; i < total - 1; i++) {
			customers[i] = customers[i + 1];
		}
		//最后有数据的元素需要置空
		customers[total - 1] = null;
		total -= 1;
		return true;

	}

	/*
	 * 用途：返回数组中记录的所有客户对象 返回： Customer[] 数组中包含了当前所有客户对象，该数组长度与对象个数相同。
	 * 
	 */
	/**
	 * 
	 * Description 返回数组中记录的所有客户对象
	 * @author Pan  Email:zhaopan1848@163.com
	 * @date 2020年3月29日上午9:44:03
	 * @return Customer[] 数组中包含了当前所有客户对象，该数组长度与对象个数相同。
	 */
	public Customer[] getAllCustomers() {
		//复制的只是地址值，不是每个真实的对象
		Customer[] custs = new Customer[total];
		for (int i = 0; i < total; i++) {
			custs[i] = customers[i];
		}
		return custs;

	}

	/*
	 * 用途：返回参数index指定索引位置的客户对象记录 参数： index指定所要获取的客户在数组中的索引位置，从0开始
	 * 返回：封装了客户信息的Customer对象
	 */
	/**
	 * 
	 * Description 返回参数index指定索引位置的客户对象记录
	 * @author Pan  Email:zhaopan1848@163.com
	 * @date 2020年3月29日上午9:46:10
	 * @param index 指定所要获取的客户在数组中的索引位置，从0开始
	 * @return 封装了客户信息的Customer对象
	 */
	public Customer getCustomer(int index) {
		if (index >= 0 && index < total) {
			return customers[index];
		} else {
			return null;
		}
		}


	public int getTotal() {
		return total;

	}

	/*
	 * 在CustomerList类中临时添加一个main方法中，作为单元测试方法。 在方法中创建CustomerList对象（最多存放5个客户对象），
	 * 然后分别用模拟数据调用以下各个方法，以测试各方法是否编写正确：
	 * 如果要测试，就把构造器中的customers[0]的赋值打开
	 */
//	public static void main(String[] args) {
//		CustomerList customerList = new CustomerList(5);
//		//System.out.println(customerList.customers.length);
//
//		Customer customer = new Customer("Jerry", '女', 16, "181", "14@124");
//		Customer customer1 = new Customer("Piggy", '男', 26, "151", "15@125");
//
//		// 测试addCustomer是否有用
//		customerList.addCustomer(customer);
//		customerList.addCustomer(customer1);
//		System.out.println("*******测试增加*********");
//		for (int i = 0; i < customerList.getTotal(); i++) {
//			System.out.println(customerList.getAllCustomers()[i].getName());
//		}
//		System.out.println("一共有" + customerList.getTotal() + "个客户");
//
//		// 测试replaceCustomer是否有用
//		Customer cust = new Customer("杰瑞", '女', 16, "181", "14@124");
//		customerList.replaceCustomer(1, cust);
//		System.out.println("*******测试修改*********");
//		for (int i = 0; i < customerList.getTotal(); i++) {
//			System.out.println(customerList.getAllCustomers()[i].getName());
//		}
//		System.out.println("一共有" + customerList.getTotal() + "个客户");
//
//		// 测试deleteCustomer是否有用
//		customerList.deleteCustomer(1);
//		System.out.println("*******测试删除*********");
//		for (int i = 0; i < customerList.getTotal(); i++) {
//			System.out.println(customerList.getAllCustomers()[i].getName());
//		}
//		System.out.println("一共有" + customerList.getTotal() + "个客户");
//
//		// 测试getCustomer是否有用
//		System.out.println("*******测试查找*********");
//		int index = 1;
//		Customer customer2 = customerList.getCustomer(index);
//		System.out.println(customer2.getName());
//		System.out.println("一共有" + customerList.getTotal() + "个客户,这是第" + (index + 1) + "个客户！");
//
//	}

}
