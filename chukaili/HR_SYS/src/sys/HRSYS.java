package sys;

import bean.Candidate;

import java.util.LinkedList;
import java.util.Scanner;

public class HRSYS {

	/*
	在数组初始化的时候，限制了数组的大小，有没有别的方式更好呢？
	private int MAXSIZE=100;
	private Book[] bookList=new Book[MAXSIZE];
	private int bookCount=0;//都是数组带来的烦恼？还得防止越界；
	*/

	//采用List代替数组，考虑到频繁的插入删除操作，此处选用LinkList
	private LinkedList<Candidate> candidateLinkedList = new LinkedList<>();

	//添加求职者
	void addCandidate() {
		System.out.println("");
		System.out.println("--欢迎进入添加求职者信息界面--");

		Scanner input = new Scanner(System.in);
		System.out.println("--请依次输入需要添加的姓名，身份证号，学校(以回车分隔)--");
		String name = input.nextLine();
		String id = input.nextLine();
		String school = input.nextLine();

		Candidate candidate = new Candidate(name, id, school);
		candidateLinkedList.add(candidate);
		System.out.println("--您已经成功添加图书--");
	}

	//删除求职者
	void deleteCandidate() {
		Scanner input=new Scanner(System.in);
		System.out.println("--欢迎进入删除信息界面--");
		System.out.println("--请输入需要删除的身份证号--");
		String id = input.nextLine();
		boolean mark = false;

		for(Candidate candidate : candidateLinkedList) {
			if (candidate.getId().equals(id)) {
				candidate.setDeleteStatus(0);
				mark = true;
				System.out.println("--删除成功--");
			}
		}
		if (!mark){
			System.out.println("--没有找到该求职者--");
		}
	}

	//修改图书
	void updateCandidate()
	{
		Scanner input=new Scanner(System.in);
		System.out.println("--欢迎进入修改信息界面--");
		System.out.println("--请输入需要修改的身份证号--");
		String id = input.nextLine();
		boolean mark = false;

		for(Candidate candidate : candidateLinkedList) {

			if (candidate.getId().equals(id)) {

				System.out.println("--请依次输入需要添加的姓名，身份证号，学校(以回车分隔)--");
				candidate.setName(input.nextLine());
				candidate.setId(input.nextLine());
				candidate.setSchool(input.nextLine());
				mark = true;
			}
		}
		if (!mark){
			System.out.println("--没有找到该求职者--");
		}
	}

	//查询
	void searchCandidate()
	{
		Scanner input=new Scanner(System.in);
		System.out.println("--欢迎进入修改信息界面--");
		System.out.println("--请输入需要查询的姓名--");
		String name = input.nextLine();
		boolean mark = false;

		for(Candidate candidate : candidateLinkedList) {

			if (candidate.getName().equals(name)) {
				System.out.println("姓名: " + candidate.getName());
				System.out.println("身份证号: " + candidate.getId());
				System.out.println("学校: " + candidate.getSchool());
				System.out.println("当前状态: " + candidate.getProcess());
				mark = true;
			}
		}
		if (!mark){
			System.out.println("--没有找到该求职者--");
		}
	}

	//遍历
	void showCandidate()
	{
		for (Candidate candidate : candidateLinkedList){
			if (candidate.getDeleteStatus() == 1){
				System.out.println("姓名: " + candidate.getName());
				System.out.println("身份证号: " + candidate.getId());
				System.out.println("学校: " + candidate.getSchool());
				System.out.println("当前状态: " + candidate.getProcess());
			}
		}
	}
}