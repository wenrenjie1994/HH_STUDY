package com.pan.p2.service;

import com.pan.p2.bean.Customer;

/**
 * 
 * Description CustomerList为Customer对象的管理模块， 内部用数组管理一组Customer对象，
 * 并提供相应的添加、修改、删除和遍历方法， 供CustomerView调用
 * 
 * @author Pan Email:zhaopan1848@163.com
 * @version
 * @date 2020年3月24日下午5:03:15
 */
public class CustomerList {

	private Customer[] customers; // 用来保存客户对象的数组
	private int total = 0; // 记录已保存客户对象的数量

	/**
	 * 构造器，用来初始化customers数组
	 * 
	 * @param totalCustomer 指定customers数组的最大空间/指定数组的长度
	 */
	public CustomerList(int totalCustomer) {
		// 初始化数组
		customers = new Customer[totalCustomer];
	}

	/**
	 * 
	 * Description 将指定的客户添加到数组中
	 * 
	 * @author Pan Email:zhaopan1848@163.com
	 * @date 2020年3月25日上午12:23:12
	 * @param customer
	 * @return true:添加成功 false：添加失败（满了）
	 */
	public boolean addCustomer(Customer customer) {
//		判断是否满了
		if (total >= customers.length) {
			return false;
		} else {
			customers[total] = customer;
			total += 1;
//			老师的写法
//			customers[total++]=customer;
			return true;
		}

	}

	/**
	 * 
	 * Description 修改指定索引位置上的客户信息
	 * 
	 * @author Pan Email:zhaopan1848@163.com
	 * @date 2020年3月25日上午12:28:57
	 * @param index
	 * @param cust
	 * @return true：修改成功 false：修改失败
	 */
	public boolean replaceCustomer(int index, Customer cust) {
		if (index < 0 || index >= total) {
			return false;
		}
		customers[index] = cust;
		return true;
	}

	/**
	 * 
	 * Description 删除指定索引位置上的值
	 * 
	 * @author Pan Email:zhaopan1848@163.com
	 * @date 2020年3月25日上午12:34:18
	 * @param index
	 * @return ture:删除成功 false:删除失败
	 */
	public boolean deleteCustomer(int index) {
		if (index < 0 || index >= total) {
			return false;
		}

		for (int i = index; i < total - 1; i++) {
			customers[i] = customers[i + 1];

		}
		//最后有数据的元素需要置空
		customers[total - 1] = null;
		//总数减少一个
		total--;
		
		//合并
		//customers[--total] = null;
		return true;

	}

	/**
	 * 
	 * Description 获取所有的客户信息
	 * @author Pan  Email:zhaopan1848@163.com
	 * @date 2020年3月25日上午12:47:34
	 * @return
	 */
	public Customer[] getAllCustomers() {
	//不能直接 return customers;因为数组好多是空的
		//new一个新数组
		Customer[] custs = new Customer[total];
		for(int i=0;i<total;i++) {
			custs[i]=customers[i];
		}
		return custs;
		
	}

	/**
	 * 
	 * Description 获取指定索引位置上的客户
	 * @author Pan  Email:zhaopan1848@163.com
	 * @date 2020年3月25日上午12:51:54
	 * @param index
	 * @return 找到元素返回元素，找不到返回null
	 */
	public Customer getCustomer(int index) {

		if (index < 0 || index >= total) {
			return null;
		}
		return customers[index];
	}

	/**
	 * 
	 * Description 获取存储客户的数量
	 * @author Pan  Email:zhaopan1848@163.com
	 * @date 2020年3月25日上午12:54:28
	 * @return
	 */
	public int getTotal() {
		
		return total;
//		return customers.length;//是错误的

	}

}
