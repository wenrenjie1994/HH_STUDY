package sys;


import Work.Action;
import bean.Resume;
import bean.ResumeList;

import java.util.Scanner;

public class Hrsys {
	public Hrsys() {

		Scanner input = new Scanner(System.in);
		int count = 1;

		do{
			System.out.println("########## 欢迎来到人事管理系统(基于Mysql数据库) ##########");
			System.out.println("##########[增加应聘者请按----------1]：");
			System.out.println("##########[删除应聘者请按----------2]：");
			System.out.println("##########[修改应聘者请按----------3]：");
			System.out.println("##########[查询应聘者请按----------4]：");
			System.out.println("##########[退出请按--------------0]：");
			// switch语句进行选项判断
			int choice = input.nextInt();
			switch(choice) {
				case 1:
					addResume();
					break;

				case 2:
					deleteResume();
					break;

				case 3:
					updateResume();
					break;

				case 4:
					searchBook();
					break;

				default:
					System.out.println("输入格式错误，请确认后从新输入！");
					break;

				case 0:
					System.out.println("(您已退出简历管理系统");
					count = 0;

			}

		}while (count == 1);
	}
	static void addResume()
	{
		System.out.println("欢迎来到添加应聘者界面");
		Scanner input = new Scanner(System.in);
		System.out.println("请依次输入应聘者的姓名，性别，年龄，学历");
		String RName=input.nextLine();
		String RGender =input.nextLine();
		String RAge =input.nextLine();
		String REdu = input.nextLine();
		Resume r=new Resume(RName,RGender,RAge,REdu);
		Action a =new Action();
		int line=a.addResume(r);
		if(line>0){
			System.out.println("添加应聘者成功");
		}
		else
		{
			System.out.println("添加失败,清重新输入");
		}
	}

	//*************************删除应聘者*******************************
	static void deleteResume()
	{

		Scanner input = new Scanner(System.in);
		System.out.println("************欢迎来到删除应聘者界面************");
		System.out.println("请输入需要删除的应聘者*姓名*");
		String RName =input.nextLine();
		Resume r=new Resume(RName,null,null,null);
		Action d =new Action();
		int line=d.deleteResumeByName(r);
		if(line>0)
		{
			System.out.println("删除应聘者成功");
		}
		else
		{
			System.out.println("没有找到该应聘者，无法删除");
		}

	}


	//*************************查询应聘者*******************************
	static void searchBook() {
		while (true) {
			System.out.println("************欢迎来到查询应聘者界面************");
			System.out.println("请输入需要查询的应聘者姓名");
			Scanner input = new Scanner(System.in);

			String Name = input.nextLine();
			Resume r = new Resume(Name, null, null, null);
			Action s = new Action();
			ResumeList list = s.searchResumeByName(r);
			int Count = list.size();
			if (Count > 0) {
				for (int i = 0; i < Count; i++) {
					System.out.println("姓名:" + list.get(i).getName() + ">>" + "  "
							+ "性别" + "：" + list.get(i).getGender() + "  "
							+ "年龄" + "：" + list.get(i).getAge() + "  "
							+ "学历" + "：" + list.get(i).getEducation() + "  ");
				}
			} else {
				System.out.println("没有找到姓名为" + Name + "的应聘者");
			}

		}
	}

	//*************************修改应聘者信息*******************************
	static void updateResume(){
		System.out.println("************欢迎来到修改应聘者信息界面************");
		System.out.println("请输入需要修改的应聘者姓名");
		Scanner input = new Scanner(System.in);
		String oldName = input.nextLine();
		System.out.println("请依次输入修改过后的应聘者的姓名，性别，年龄，学历");
		String RName=input.nextLine();
		String RGender =input.nextLine();
		String RAge =input.nextLine();
		String REdu = input.nextLine();
		//原来的信息和新的应聘者信息
		Resume oldR = new Resume(oldName, null, null, null);
		Resume newR = new Resume(RName,RGender,RAge,REdu);

		Action a = new Action();
		int line=a.changeResume(newR, oldR);
		if(line>0)
		{
			System.out.println("修改成功");
		}
		else
		{
			System.out.println("修改失败，请检查后再重新输入");
		}

	}


	public static void main(String[] args)
	{
		new Hrsys();
	}
}