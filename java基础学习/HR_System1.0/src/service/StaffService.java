package service;

import java.util.LinkedList;
import java.util.Scanner;

import model.Staff;

public class StaffService {
	//员工信息添加
	public static void addStaff(LinkedList<Staff> staffList) {
		System.out.println("现在开始添加新员工");
		Scanner input = new Scanner(System.in);
		System.out.println("请依次输入新员工年龄、工号、姓名、性别");
		int age = input.nextInt();
		String staffId = input.nextLine();
		String name = input.nextLine();
		String sex = input.nextLine();
		
		Staff staff = new Staff(age, staffId, name, sex);
		staffList.add(staff); //添加新员工信息到集合中
		System.out.println("工号："+staffId);
		System.out.println("该新员工添加成功！");
	}
	
	//员工信息删除
	public static void delStaff(LinkedList<Staff> staffList) {
		System.out.println("删除员工信息");
		Scanner input = new Scanner(System.in);
		System.out.println("请输入要删除员工的工号：");
		String staffId = input.nextLine();
		
		for(int i = 0; i < staffList.size();i++) {
			if(staffList.get(i).getStaffId().equals(staffId)) { //如果输入的员工工号与集合中的员工工号相等，则从集合中删除该条员工信息
				staffList.remove(i);
				System.out.println("工号为：" + staffId + "的员工信息删除成功！");
				break;
			}else if (i == staffList.size() - 1) {
				System.out.println("未找到该员工信息!");
			}
		}
	}
	
	//修改员工信息
	public static void updateStaff(LinkedList<Staff> staffList) {
		System.out.println("修改员工信息");
		Scanner input = new Scanner(System.in);
		System.out.println("请输入要修改员工的工号：");
		String staffId = input.nextLine();
		
		for(int i = 0; i < staffList.size();i++) {
			if(staffList.get(i).getStaffId().equals(staffId)) { //如果输入的员工工号与集合中的员工工号相等，则从集合中删除该条员工信息
				System.out.println("请依次输入您要修改的员工信息的年龄、工号、姓名、性别");
				int newAge = input.nextInt();
				String newStaffId = input.nextLine();
				String newName = input.nextLine();
				String newSex = input.nextLine();
				Staff newStaff = new Staff(newAge, newStaffId, newName, newSex);
				staffList.set(i, newStaff);//修改对应集合编号中的员工信息
				System.out.println("原工号为：" + staffId + "的员工信息修改成功！");
				break;
			}else if (i == staffList.size() - 1 || staffList.size() == 0) {
				System.out.println("未找到该员工信息!");
			}
		}
	}
	
	//显示员工信息
	public static void showStaff(LinkedList<Staff> staffList) {
		System.out.println("所有员工信息如下：");
		for(int i = 0; i < staffList.size(); i++) {
			int age = staffList.get(i).getAge();
			String staffId = staffList.get(i).getStaffId();
			String name = staffList.get(i).getName();
			String sex = staffList.get(i).getSex();
			System.out.println("年龄：" + age + " " + "工号：" + staffId + " " + "姓名：" + name + " " +"性别：" + sex );
		}
	}
	
}
