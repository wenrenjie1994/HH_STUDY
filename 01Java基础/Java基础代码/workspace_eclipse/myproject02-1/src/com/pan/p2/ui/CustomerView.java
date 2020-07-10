package com.pan.p2.ui;

import com.pan.p2.bean.Customer;
import com.pan.p2.service.CustomerList;
import com.pan.p2.utlity.CMUtility;

/*
 * CustomerView为主模块，负责菜单的显示和处理用户操作
	本类封装以下信息：
	CustomerList customerList = new CustomerList(10);
	创建最大包含10个客户对象的CustomerList 对象，供以下各成员方法使用。
	该类至少提供以下方法：
	public void enterMainMenu() 
	private void addNewCustomer() 
	private void modifyCustomer()
	private void deleteCustomer()
	private void listAllCustomers()
	public static void main(String[] args)
 * 
 * 
 * 
 */
public class CustomerView {
	CustomerList customerList = new CustomerList(10);

	/*
	 * 用途：显示主菜单，响应用户输入， 根据用户操作分别调用其他相应的成员方法（如addNewCustomer）， 以完成客户信息处理
	 */
	/**
	 * 
	 * Description 显示主菜单，响应用户输入
	 * 
	 * @author Pan Email:zhaopan1848@163.com
	 * @date 2020年3月29日上午9:49:44
	 */
	public void enterMainMenu() {
		boolean loopFlag = true;
		while (loopFlag) {
			System.out.println("\n-----------------客户信息管理软件-----------------\n");
			System.out.println("                   1 添 加 客 户");
			System.out.println("                   2 修 改 客 户");
			System.out.println("                   3 删 除 客 户");
			System.out.println("                   4 客 户 列 表");
			System.out.println("                   5 退       出\n");
			System.out.print("                   请选择(1-5)：");

			char key = CMUtility.readMenuSelection();
			switch (key) {
			// 注意单引号
			case '1':
				addNewCustomer();
				break;// 不让继续往下走
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
				// 补充：
				System.out.print("确认是否删除(Y/N):");
				char isExit = CMUtility.readConfirmSelection();
				if (isExit == 'Y') {
					loopFlag = false;
				}
//				break;//最后了，有没有无所谓

			}

		}

	}

	private void addNewCustomer() {
//		System.out.println("添加客户");
		System.out.println("---------------------添加客户---------------------");
		System.out.print("姓名：");
		String name = CMUtility.readString(10);
		System.out.print("性别：");
		char gender = CMUtility.readChar();
		System.out.print("年龄：");
		int age = CMUtility.readInt();
		System.out.print("电话：");
		String phone = CMUtility.readString(15);
		System.out.print("邮箱：");
		String email = CMUtility.readString(30);
		Customer customer = new Customer(name, gender, age, phone, email);

		// 补充：有可能添加失败，所以要判断一下
		boolean isSuccess = customerList.addCustomer(customer);
		if (isSuccess) {
			System.out.println("---------------------添加完成---------------------");
		} else {
			System.out.println("-----------------客户目录已满，添加失败！-----------------");
		}

	}

	private void modifyCustomer() {
		System.out.println("---------------------修改客户---------------------");

//		int number;//定义在循环体外，因为跳出循环体后还需要调用
		// 我写的，没用customerList.getCustomer(number - 1)方法
//		while (true) {
//			System.out.print("请选择待修改客户编号(-1退出)：");
//			number = CMUtility.readInt();
//			if (number == -1) {
//				return;// return是返回的意思，就是跳出当前执行的方法；
//			} else if (number < 1 || number > customerList.getTotal()) {
//				System.out.print("无法找到指定客户！");
////				number = CMUtility.readInt();		
//			} else {//找到了指定客户
//				break;// break是结束当前的循环，但是循环体后面的部分还是会执行
//			}
//		}

		// 老师写的for(;;){}，用了customerList.getCustomer(number - 1)
		int number;// 定义在循环体外，因为跳出循环体后还需要调用
		Customer cust;
		for (;;) {
			System.out.print("请选择待修改客户编号(-1退出)：");
			number = CMUtility.readInt();
			if (number == -1) {
				return;// return是返回的意思，就是跳出当前执行的方法；
			}

			cust = customerList.getCustomer(number - 1);
			if (cust == null) {
				System.out.println("无法找到指定客户！");
			} else {// 找到了指定客户
				break;// break是结束当前的循环，但是循环体后面的部分还是会执行
			}

		}

		// 找到了指定客户，修改客户信息
		// break之后，执行循环体后面的句子

		// 我写的，太长了
//		String name = customerList.getCustomer(number - 1).getName();
//		System.out.print("姓名(" + name + "):");
//		String newName = CMUtility.readString(10, name);
		// 老师写的，很简洁，要学习啊！！下面同理，不改了
		System.out.print("姓名(" + cust.getName() + "):");
		String newName = CMUtility.readString(10, cust.getName());

		char gender = customerList.getCustomer(number - 1).getGender();
		System.out.print("性别(" + gender + "):");
		char newGender = CMUtility.readChar(gender);

		int age = customerList.getCustomer(number - 1).getAge();
		System.out.print("年龄(" + age + "):");
		int newAge = CMUtility.readInt(age);

		String phone = customerList.getCustomer(number - 1).getPhone();
		System.out.print("电话(" + phone + "):");
		String newPhone = CMUtility.readString(15, phone);

		String email = customerList.getCustomer(number - 1).getEmail();
		System.out.print("邮箱(" + email + "):");
		String newEmail = CMUtility.readString(30, email);

		Customer newCustomer = new Customer(newName, newGender, newAge, newPhone, newEmail);
		// 注意：一定是number - 1
		// 补充：修改有可能失败
		boolean isReplaced = customerList.replaceCustomer(number - 1, newCustomer);
		if (isReplaced) {
			System.out.println("---------------------修改完成---------------------");

		} else {
			System.out.println("---------------------修改失败---------------------");
		} // 其实不会到这，index不靠谱在循环中已经过滤掉了，只是为了完整性写上了

	}

	private void deleteCustomer() {
		System.out.println("---------------------删除客户---------------------");

		// 我写的
//		int number;
//		while (true) {
//			System.out.print("请选择待删除客户编号(-1退出)：");
//			number = CMUtility.readInt();
//			if (number == -1) {
//				return;// return是返回的意思，就是跳出当前执行的方法；
//			} else if (number < 1 || number > customerList.getTotal()) {
//				System.out.print("选择错误，请重新输入：");
//			} else {
//				break;// break是结束当前的循环，但是循环体后面的部分还是会执行
//			}
//		}

		// 老师写的，和上面那道题一样
		int number;// 定义在循环体外，因为跳出循环体后还需要调用
		Customer cust;
		for (;;) {
			System.out.print("请选择待删除客户编号(-1退出)：");
			number = CMUtility.readInt();
			if (number == -1) {
				return;// return是返回的意思，就是跳出当前执行的方法；
			}

			cust = customerList.getCustomer(number - 1);
			if (cust == null) {
				System.out.println("无法找到指定客户！");
			} else {// 找到了指定客户
				break;// break是结束当前的循环，但是循环体后面的部分还是会执行
			}

		}

		// 找到了指定的客户执行循环体后面的句子
		System.out.print("确认是否删除(Y/N):");
		char isDelete = CMUtility.readConfirmSelection();
		if (isDelete == 'Y') {
			// 注意也是number-1
			// 补充：为了完整性，也加一个删除是否成功的判断
			boolean deleteSuccess = customerList.deleteCustomer(number - 1);
			if (deleteSuccess) {
				System.out.println("---------------------删除完成---------------------");
			} else {
				System.out.println("---------------------删除失败---------------------");
			}

		} else {
			return;
		} // 其实不用写else

	}

	private void listAllCustomers() {
//		System.out.println("客户列表");

		System.out.println("\n-----------------客户列表-----------------\n");

		if (customerList.getTotal() >= 1) {
			System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t邮箱");
			Customer[] allCustomers = customerList.getAllCustomers();
			for (int i = 0; i < allCustomers.length; i++) {
				System.out.println((i + 1) + "\t" + allCustomers[i].getName() + "\t" + allCustomers[i].getGender()
						+ "\t" + allCustomers[i].getAge() + "\t" + allCustomers[i].getPhone() + "\t\t"
						+ allCustomers[i].getEmail());
			}

		} else {
			System.out.println("没有客户信息！");
		}

		System.out.println("\n-----------------客户列表完成-----------------\n");

	}

	public static void main(String[] args) {
		CustomerView view = new CustomerView();
		view.enterMainMenu();

	}

}
