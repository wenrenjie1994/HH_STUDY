package controller;

import java.util.LinkedList;
import java.util.Scanner;

import model.Staff;
import service.StaffService;

public class StaffController {

	public static void main(String[] args) {
		LinkedList<Staff> staffList = new LinkedList<Staff>();
		Scanner input = new Scanner(System.in);
		while(true)
		{
			System.out.println("************欢迎来到人事管理系统************");
			System.out.println("增加员工信息请按----------1");
			System.out.println("删除员工信息请按----------2");
			System.out.println("修改员工信息请按----------3");
			System.out.println("查询所有员工信息请按----------4");
			
			//switch语句指令判断
			int num =input.nextInt();
			switch(num) {
				case 1:
					StaffService.addStaff(staffList);
					break;
				case 2:
					StaffService.delStaff(staffList);
					break;
				case 3:
					StaffService.updateStaff(staffList);
					break;
				case 4:
					StaffService.showStaff(staffList);
					break;
				default:
					System.out.println("输入有误，请重试！");
					break;
			}
			
		}
	}

}
