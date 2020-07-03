package sys;

import java.util.Scanner;

import bean.Resume;

public class HRS_T {

	private int MAXSIZE=100;
	//在数组初始化的时候，限制了数组的大小，有没有别的方式更好呢？--用linkedlist
	private Resume[] resumeList=new Resume[MAXSIZE];


	private int resumeCount=0;//都是数组带来的烦恼？还得防止越界；
	//获取标准输入流
	private Scanner input=new Scanner(System.in);



	HRS_T(){
		boolean c=true;
		while(c)
		{

			System.out.println("-----欢迎进入idcard的hr系统-----");
			System.out.println("添加学生信息请按----1");
			System.out.println("删除学生信息请按----2");
			System.out.println("修改学生信息请按----3");
			System.out.println("查询学生信息请按----4");
			System.out.println("退出请按--------5");


			int choice=input.nextInt();
			//除了用if 还能用什么方式可以实现逻辑判断？

			switch(choice){
				case 1 :
					addResume();
					break;
				case 2 :
					deleteResume();
					break;
				case 3 :
					updateResume();
					break;
				case 4 :
					searchResume();
					break;
				case 5 :
					c=false;
					break;
				default :
					System.out.println("输入错误，请重新输入");
			}
		}
		input.close();//流啊 连接啊 这些东西 用完记得关；要么记得还（那么什么地方是需要还的，什么地方是关的）；
		System.out.println("您已经退出hr系统");
	}

	//添加学生信息
	void addResume()
	{
		System.out.println("欢迎进入添加学生信息界面");
		if(resumeCount<MAXSIZE)//判断图书管理系统是否未满
		{
			Scanner input=new Scanner(System.in);
			System.out.println("请依次输入需要添加的姓名和id");
			String resumeName=input.nextLine();
			String resumeId=input.nextLine();

			//get/SET
			Resume resume=new Resume(resumeName,resumeId);

			resumeList[resumeCount]=resume;
			resumeCount++;
			System.out.println("您已经成功添加学生信息");
			showResume();
		}
		else{
			System.out.println("hr系统已满，无法添加学生信息");
		}
	}

	//删除学生信息
	void deleteResume()
	{
		@SuppressWarnings("resource")//java注解，不会，加入学习列表
		Scanner input=new Scanner(System.in);
		System.out.println("欢迎进入删除学生信息界面");
		System.out.println("请输入需要删除的学生id");
		String resumeId=input.nextLine();

		if(resumeCount!=0)//hr系统不为空
		{
			for(int i=0;i<resumeCount;i++)
			{
				if(resumeList[i].getId().equals(resumeId))
				{
					for(int j=i;j<resumeCount-1;j++)
					{
						resumeList[j]=resumeList[j+1];
					}
					System.out.println("您已经成功删除学生信息");
					resumeCount--;
					break;
				}
				else if(i==resumeCount-1) {
					System.out.println("没有找到该学生");
				}
			}
			showResume();
		}
		else{
			System.out.println("学生信息系统为空，没有找到该学生");
		}
//		input.close();
	}

	//修改学生信息
	void updateResume()
	{
		Scanner input=new Scanner(System.in);
		System.out.println("欢迎进入修改学生信息界面");
		System.out.println("请输入需要修改的学生Id");
		String resumeId=input.nextLine();
		if(resumeCount!=0)//hr系统不为空
		{
			for(int i=0;i<resumeCount;i++)
			{
				if(resumeList[i].getId().equals(resumeId))
				{
					System.out.println("请依次输入新的姓名，id，学校，进度");
					String newresumeName=input.nextLine();
					String newresumeId=input.nextLine();
					String newresumeSchool=input.nextLine();
					int newresumeProcess=input.nextInt();
					{
						resumeList[i].setName(newresumeName);
						resumeList[i].setId(newresumeId);
						resumeList[i].setSchool(newresumeSchool);
						resumeList[i].setProcess(newresumeProcess);
					}
					System.out.println("您已经修改成功");
					showResume();
				}
				else if(i==resumeCount-1||resumeCount==0) {
					System.out.println("没有查找到该学生");
				}
			}
		}
		else{
			System.out.println("系统为空，没有查找到该学生");
		}
//		input.close();
	}

	//查询学生信息
	void searchResume()
	{
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		System.out.println("欢迎进入查询学生信息界面");
		System.out.println("请输入需要查询的学生id");
		String resumeId=input.nextLine();
		for(int i=0;i<resumeCount;i++)
		{
			if(resumeList[i].getId().equals(resumeId))
			{
				System.out.println("姓名："+resumeList[i].getName()+"\n"+
									"ID"+":"+resumeList[i].getId()+"\n"
									+"学校"+":"+resumeList[i].getSchool()+"\n"
									+"进度："+resumeList[i].getProcess());
				break;
			}
			else if(i==resumeCount-1) {
				System.out.println("没有查找到该学生，请重新输入");
			}
		}
//		input.close();
	}

	//学生信息遍历
	void showResume()
	{
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		System.out.println("是否需要打印所有学生信息，是请输入Y，不用打印则输入任意");
		String XUANZE=input.nextLine();
		String Y="Y";
		if(XUANZE.equals(Y))
		{
			System.out.println("本hr系统共有"+resumeCount+"个同学");
			for(int i=0;i<resumeCount;i++) {
				System.out.println("第"+(i+1)+"个同学"+"----"+resumeList[i].getName());
			}
		}
//		input.close();
	}
	
	public static void main(String[] args)
	{
		new HRS_T();
	}
}