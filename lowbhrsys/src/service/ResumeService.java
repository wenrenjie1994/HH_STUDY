package service;

import java.util.LinkedList;
import java.util.Scanner;
import model.Resume;
public class ResumeService
{
	public static void addResume(LinkedList<Resume> resumeList)
	{
		System.out.println("欢迎来到添加简历界面");
		Scanner input = new Scanner(System.in);
		System.out.println("请依次输入需要添加学生名，学生ID，学校， 简历状态(以空格分隔)");
		String studentName =input.next();
		int studentID =input.nextInt();
		String studentSchool =input.next();
		int process = input.nextInt();
		Resume resume = new Resume(studentName,studentID,studentSchool,process);
		resumeList.add(resume);
		System.out.println("您已成功添加简历");
		showBook(resumeList);
	}

	public static void deleteResume(LinkedList<Resume> resumeList)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("欢迎来到删除简历界面");
		System.out.println("请输入需要删除的学生名");
		String resumeName =input.nextLine();
		int resumeCount = resumeList.size();
		for(int i=0;i<resumeCount;i++)
		{
			if(resumeList.get(i).studentName.equals(resumeName))
			{
				resumeList.remove(i);
				System.out.println("您已成功删除简历");
				break;
			}
			else if(i==resumeCount-1) {
				System.out.println("没有查找到该简历");
			}
		}
		 showBook(resumeList);
	}


	public static void updateBook(LinkedList<Resume> resumeList)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("欢迎来到修改简历界面");
		System.out.println("请输入需要修改的简历名");
		String resumeName=input.nextLine();
		int resumeCount = resumeList.size();
		for(int i=0;i<resumeCount;i++)
		{
			if(resumeList.get(i).studentName.equals(resumeName))
			{
				System.out.println("请依次输入新的学生名，ID，学校， 简历状态码(以空格分隔)");
				String newresumeName=input.next();
				int newresumeID=input.nextInt();
				String newresumeSchool=input.next();
				int newProcess = input.nextInt();
				Resume resume =new Resume(newresumeName,newresumeID,newresumeSchool,newProcess);
				resumeList.set(i, resume);
				System.out.println("您已成功修改");
				showBook(resumeList);
			}
			else if(i==resumeCount-1||resumeCount==0) {
				System.out.println("没有查找到该简历");
			}
		}
		System.out.println("没有查找到该简历");
	}

	public static void showBook(LinkedList<Resume> resumeList)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("是否需要打印所有简历，是请输入Y，不用打印则输入任意");
		String XUANZE=input.nextLine();
		String Y ="Y";
		if(XUANZE.equals(Y))
		{
			System.out.println("本简历管理系统共有"+ resumeList.size()+"份简历");
			int bookCount = resumeList.size();
			for(int i=0;i<bookCount;i++) {
				System.out.println("第"+(i+1)+"份"+"---------"+"<<"+ resumeList.get(i).studentName+resumeList.get(i).studnetID+resumeList.get(i).studentSchool+resumeList.get(i).process+">>");
			}

		}
	}
}
