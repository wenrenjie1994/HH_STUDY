package sys;

import bean.employee;
import bean.employeeList;

import java.util.ArrayList;
import java.util.Scanner;


public class HRS {

	private int MAXSIZE=100;
	private employee[] employeeList=new employee[MAXSIZE];

	ArrayList<employee> employeeArrayList=new ArrayList();
	bean.employeeList employees=new employeeList();



	private int employeeCount=0;//防止越界
	//获取标准输入流
	private Scanner input=new Scanner(System.in);


	public HRS(){

		while(true)
		{
//			Scanner input=new Scanner(System.in);
			System.out.println("-----欢迎进入浦发银行员工管理系统-----");
			System.out.println("添加员工请按----1");
			System.out.println("删除员工请按----2");
			System.out.println("修改员工请按----3");
			System.out.println("查询员工请按----4");
			System.out.println("退出请按-------5");


			int choice=input.nextInt();
			//用switch实现逻辑判断
			switch(choice) {
				case 1:
					addEmployee();
					break;
				case 2:
					deleteEmployee();
					break;
				case 3:
					updateEmployee();
					break;
				case 4:
					searchEmployee();
					break;
				case 5:
					break;
				default:
					System.out.println("输入错误，请重新输入");
					break;
			}
			if (choice==5){
				break;
			}
		}
		input.close();//关闭input
		System.out.println("你已经推出浦发银行员工管理系统");
	}

	//添加员工
	void addEmployee()
	{
		System.out.println("欢迎进入添加员工界面");
		if(employeeCount<MAXSIZE)//判满操作
		{
			Scanner input=new Scanner(System.in);
			System.out.println("请依次输入需要添加的员工姓名、年龄、工号");
			String Name=input.nextLine();
			int Age=input.nextInt();
			int Num=input.nextInt();

			//get/SET
			employee employee=new employee(Name,Age,Num);

			employeeList[employeeCount]=employee;
			employeeCount++;
			System.out.println("你已经成功添加员工");
			showEmployee();
		}
		else{
			System.out.println("系统已满，无法添加");
		}
	}

	//删除员工
	void deleteEmployee()
	{
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		System.out.println("欢迎进入删除员工界面");
		System.out.println("请输入需要删除的员工名字");
		String Name=input.nextLine();
		if(employeeCount!=0)//系统不为空
		{
			for(int i=0;i<employeeCount;i++)
			{
				if(employeeList[i].Name.equals(Name))
				{
					for(int j=i;j<employeeCount-1;j++)
					{
						employeeList[j]=employeeList[j+1];
					}
					System.out.println("你已经成功删除员工");
					employeeCount--;
					break;
				}
				else if(i==employeeCount-1) {
					System.out.println("没有找到该员工");
				}
			}
			showEmployee();
		}
		else{
			System.out.println("员工系统为空");
		}
//	input.close();
	}

	//修改员工
	void updateEmployee()
	{
		Scanner input=new Scanner(System.in);
		System.out.println("欢迎进入员工修改界面");
		System.out.println("请输入需要修改的员工姓名");
		String Name=input.nextLine();
		if(employeeCount!=0)//员工系统不为空
		{
			for(int i=0;i<employeeCount;i++)
			{
				if(employeeList[i].Name.equals(Name))
				{
					System.out.println("请输入修改后的员工名字、年龄、工号");
					String newName=input.nextLine();
					int newAge=input.nextInt();
					int newNum=input.nextInt();
					employee employee=new employee(newName,newAge,newNum);
					employeeList[i]=employee;
					System.out.println("修改成功");
					showEmployee();
				}
				else if(i==employeeCount-1) {
					System.out.println("没有找到该员工");
				}
			}
		}
		else{
			System.out.println("员工系统为空");
		}
//    	input.close();
	}

	//查询员工
	void searchEmployee()
	{
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		System.out.println("欢迎进入员工查询界面");
		System.out.println("请输入需要查询的员工姓名");
		String Name=input.nextLine();
		for(int i=0;i<employeeCount;i++)
		{
			if(employeeList[i].Name.equals(Name))
			{
				System.out.println("姓名"+":"+employeeList[i].Name+"\n"+
									"年龄"+":"+employeeList[i].Age+"\n"
									+"工号"+":"+employeeList[i].Num+"\n"
									+"位于第"+(i+1)+"位置");
				break;
			}
			else if(i==employeeCount-1) {
				System.out.println("没有找到该员工，请重新输入");
			}
		}
//		input.close();
	}

	//员工遍历
	void showEmployee()
	{
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		System.out.println("是否需要打印所有员工信息，是请输入Y，不用打印则输入任意");
		String XUANZE=input.nextLine();
		String Y="Y";
		if(XUANZE.equals(Y))
		{
			System.out.println("本员工系统共有"+employeeCount+"名员工");
			for(int i=0;i<employeeCount;i++) {
				System.out.println("第"+(i+1)+"名"+":"+employeeList[i].Name);
			}
		}
//		input.close();
	}

	public static void main(String[] args) {
		new HRS();
	}
}