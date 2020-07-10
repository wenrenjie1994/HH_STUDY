package service;

import java.util.LinkedList;
import java.util.Scanner;
import model.Resume;
public class HRService
{
	//录入信息
	public static void addResume(LinkedList<Resume> resumeList)
	{
		System.out.println("欢迎来到员工信息录入界面");
		Scanner input = new Scanner(System.in);
		System.out.println("请依次输入需要录入员工的名字，身份证号，学校，申请进度");
		String workerName = input.nextLine();
		String workerId = input.nextLine();
		String workerSchool = input.nextLine();
		int preProcess = input.nextInt();
		while (preProcess > 6 || preProcess <0){
			System.out.println("申请进度只能为0-6，请重新输入：");
			preProcess = input.nextInt();
		}
		int process = preProcess;
		Resume resume = new Resume(workerName, workerId, workerSchool, process);
		resumeList.add(resume);
		System.out.println("您已成功录入员工信息");
		showResume(resumeList);
	}

	//删除信息
	public static void deleteResume(LinkedList<Resume> resumeList)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("欢迎来到员工信息删除界面");
		System.out.println("请输入需要删除的员工名字");
		String workerName =input.nextLine();
		int workerCount = resumeList.size();
		for(int i=0; i<workerCount; i++)
		{
			if(resumeList.get(i).getName().equals(workerName))
			{
				resumeList.remove(i);
				System.out.println("您已成功删除员工:" + workerName);
				break;
			}
			else if(i==workerCount-1) {
				System.out.println("没有查找到员工:" + workerName);
			}
		}
		 showResume(resumeList);
	}

	//修改信息
	public static void updateResume(LinkedList<Resume> resumeList)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("欢迎来到员工修改界面");
		showResume(resumeList);
		System.out.println("请输入需要修改的员工名字");
		String workerName = input.nextLine();
		int workerCount = resumeList.size();
		for(int i=0; i<workerCount; i++)
		{
			if(resumeList.get(i).getName().equals(workerName))
			{
				System.out.println("请依次输入新员工的名字，身份证号，学校");
				String newworkerName = input.nextLine();
				String newworkerId = input.nextLine();
				String newworkerSchool = input.nextLine();
				int process = input.nextInt();
				Resume resume = new Resume(newworkerName, newworkerId, newworkerSchool, process);
				resumeList.set(i, resume);
				System.out.println("您已成功修改成功");
				showResume(resumeList);
			}
			else if(i==workerCount-1 || workerCount==0) {
				System.out.println("没有查找到该员工");
			}
		}
		System.out.println("没有查找到该员工");
	}

	//展示信息
	public static void showResume(LinkedList<Resume> resumeList)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("是否需要打印所有员工信息，是请输入Y，不用打印则输入任意");
		String XUANZE=input.nextLine();
		String Y ="Y";
		if(XUANZE.equals(Y))
		{
			System.out.println("本HR管理系统共有" + resumeList.size() + "个员工");
			int workerCount = resumeList.size();
			for(int i=0; i<workerCount; i++) {
				System.out.println("第"+(i+1)+"个"+"---------"+"<<"+resumeList.get(i).getName()+">>");
			}
		}
	}
}
