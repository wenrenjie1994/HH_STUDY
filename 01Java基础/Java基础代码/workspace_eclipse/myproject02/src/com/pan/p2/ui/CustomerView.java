package com.pan.p2.ui;

import com.pan.p2.bean.Customer;
import com.pan.p2.service.CustomerList;
import com.pan.p2.util.CMUtility;

/**
 * 
 * Description CustomerView为主模块，负责菜单的显示和处理用户操作
 * 
 * @author Pan Email:zhaopan1848@163.com
 * @version
 * @date 2020年3月24日下午5:04:14
 */
public class CustomerView {
	CustomerList customerList = new CustomerList(10);

	// 构造器**************不太理解
	public CustomerView() {
		Customer customer = new Customer("王涛", '男', 18, "13256323456", "wt@126.com");
		// 注意性别是char不是String
		customerList.addCustomer(customer);
	}

	/**
	 * 
	 * Description 显示主菜单，响应用户输入， 根据用户操作分别调用其他相应的成员方法 （如addNewCustomer），以完成客户信息处理。
	 * 
	 * @author Pan Email:zhaopan1848@163.com
	 * @date 2020年3月25日上午8:36:16
	 */
	public void enterMainMenu() {
		// 我是在每个方法后面加enterMainMenu()
		// 老师是将这段话放进一个循环内部
		boolean isFlag = true;
		while (isFlag) {
			System.out.println("--------------客户信息管理软件--------------");
			System.out.println("\t\t1 添加客户");
			System.out.println("\t\t2 修改客户");
			System.out.println("\t\t3 删除客户");
			System.out.println("\t\t4 客户列表");
			System.out.println("\t\t5 退        出");
			System.out.println();
			System.out.print("\t请选择(1-5):");

			char menu = CMUtility.readMenuSelection();
			switch (menu) {
			case '1':
				addNewCustomer();
				break;
			case '2':
				modifyCustomer();
				break;
			case '3':
				deleteCustomer();
				break;
			case '4':
				listAllCustomers();
				break;
			case '5':
				System.out.println("确认是否退出(Y/N)：");
				char isExit = CMUtility.readConfirmSelection();
				// 我写的
//				if (isExit == 'N') {
//					enterMainMenu();
//				}
//				else {
//					isFlag = false;
//				}
				// 老师写的
				if (isExit == 'Y') {
					isFlag = false;
				}

			}
		}

	}

	/**
	 * 
	 * Description 完成“添加客户”的菜单功能，仅供enterMainMenu()方法调用。
	 * 
	 * @author Pan Email:zhaopan1848@163.com
	 * @date 2020年3月25日上午8:37:09
	 */
	private void addNewCustomer() {
		System.out.println("--------------添加客户--------------");
		System.out.print("姓名：");
		String name = CMUtility.readString(10);

		System.out.print("性别：");
		char gender = CMUtility.readChar();
		System.out.print("年龄：");
		int age = CMUtility.readInt();
		System.out.print("电话：");
		String phone = CMUtility.readString(13);
		System.out.print("邮箱：");
		String email = CMUtility.readString(30);

		// 数组是Customer类型的，所以首先要将上述数据封装到对象当中*****难点！！
		Customer customer = new Customer(name, gender, age, phone, email);
		boolean isSuccess = customerList.addCustomer(customer);
		if (isSuccess) {
			System.out.println("--------------添加完成--------------");
		} else {
			System.out.println("System.out.println(\"----------客户目录已满，添加失败---------\");");
		}

	}

	/**
	 * 
	 * Description 完成“修改客户”的菜单功能，仅供enterMainMenu()方法调用。
	 * 
	 * @author Pan Email:zhaopan1848@163.com
	 * @date 2020年3月25日上午8:38:18
	 */
	private void modifyCustomer() {
		System.out.println("--------------修改客户--------------");

		Customer cust;// 这样定义在for循环之外，那break之后也可以调用了（妙啊）
		int number;// 同上
		for (;;) {

			System.out.print("请选择待修改客户编号(-1退出)：");
			number = CMUtility.readInt();
			if (number == -1) {
				// 此方法结束，回到主界面
				return;
			}
			cust = customerList.getCustomer(number - 1);
			// 找指定位置上的客户，找不到就返回null
			// 所以就可以根据是不是空来判断写的是不是靠谱
			// number对普通用户而言是从1开始的
			// 所以是customerList.getCustomer(number-1)
			if (cust == null) {
				System.out.println("无法找到指定客户！");
				// 无法找到就只能重新进入循环再执行
			} else {
				// 找到了指定编号的客户，可以在下面继续写
				// 但是里面会比较复杂，还有循环，看着不清晰
				// 所以就写break,意味着结束循环(秒啊)
				break;
			}

		}
		// break结束for循环，开始执行这段代码
		// 也就是找到客户了，开始修改指定位置上的客户信息
		System.out.print("姓名：(" + cust.getName() + ")");
		String name = CMUtility.readString(10, cust.getName());
		System.out.print("性别：(" + cust.getGender() + ")");
		char gender = CMUtility.readChar(cust.getGender());
		System.out.print("年龄：(" + cust.getAge() + ")");
		int age = CMUtility.readInt(cust.getAge());
		System.out.print("电话：(" + cust.getPhone() + ")");
		String phone = CMUtility.readString(15, cust.getPhone());
		System.out.print("邮箱：(" + cust.getEmail() + ")");
		String email = CMUtility.readString(30, cust.getEmail());

		Customer newCust = new Customer(name, gender, age, phone, email);
		// 改完的新的对象,做个替换
		boolean isReplaced = customerList.replaceCustomer(number - 1, newCust);// 注意还是number-1
		if (isReplaced) {
			System.out.println("--------------修改完成--------------");
		} else {
			System.out.println("--------------修改失败--------------");
		} // 其实这个else不会执行，没找到都在for循环中过滤掉了

	}

	/**
	 * 
	 * Description 完成“删除客户”的菜单功能，仅供enterMainMenu()方法调用。
	 * 
	 * @author Pan Email:zhaopan1848@163.com
	 * @date 2020年3月25日上午8:38:41
	 */
	private void deleteCustomer() {
		System.out.println("--------------删除客户--------------");
		Customer cust;// 这样定义在for循环之外，那break之后也可以调用了（妙啊）
		int number;// 同上
		for (;;) {

			System.out.print("请选择待删除客户编号(-1退出)：");
			number = CMUtility.readInt();
			if (number == -1) {
				// 此方法结束，回到主界面
				return;
			}
			cust = customerList.getCustomer(number - 1);
			// 找指定位置上的客户，找不到就返回null
			// 所以就可以根据是不是空来判断写的是不是靠谱
			// number对普通用户而言是从1开始的
			// 所以是customerList.getCustomer(number-1)
			if (cust == null) {
				System.out.println("无法找到指定客户！");
				// 无法找到就只能重新进入循环再执行
			} else {
				// 找到了指定编号的客户，可以在下面继续写
				// 但是里面会比较复杂，还有循环，看着不清晰
				// 所以就写break,意味着结束循环(秒啊)
				break;
			}

		}
		// break结束for循环，开始执行这段代码
		// 也就是找到客户了，开始删除指定位置上的客户信息
		System.out.print("确认是否删除(Y/N)：");
		char isDelete = CMUtility.readConfirmSelection();
		if (isDelete == 'Y') {
			boolean deleteSuccess = customerList.deleteCustomer(number - 1);// 删除
			if (deleteSuccess) {
				System.out.println("--------------删除完成--------------");

			} else {
				System.out.println("--------------删除失败--------------");
			}

		} else {
			return;// 回到主界面，可以把else省略，自动就会回答主界面
		}

	}

	/**
	 * 
	 * Description 完成“客户列表”的菜单功能，仅供enterMainMenu()方法调用。
	 * 
	 * @author Pan Email:zhaopan1848@163.com
	 * @date 2020年3月25日上午8:39:10
	 */
	private void listAllCustomers() {
		System.out.println("--------------客户列表--------------");
		// 判断有几个客户
		int total = customerList.getTotal();
		if (total == 0) {
			System.out.println("没有客户记录");
		} else {
			System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t邮箱");
			Customer[] custs = customerList.getAllCustomers();
			for (int i = 0; i < total; i++) {
				// custs.length
				Customer cust = custs[i];
				System.out.println((i + 1) + "\t" + cust.getName() + "\t" + cust.getGender() + "\t" + cust.getAge()
						+ "\t" + cust.getPhone() + "\t" + cust.getEmail());
			}

		}

		System.out.println("--------------客户列表完成--------------");
		enterMainMenu();

	}

	public static void main(String[] args) {
		CustomerView view = new CustomerView();
		view.enterMainMenu();

	}

}
