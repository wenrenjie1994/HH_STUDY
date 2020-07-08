package sys;

import java.util.ArrayList;
import java.util.Scanner;
import bean.Book;
import bean.BookList;

public class HRS {

	private int MAXSIZE=100;
	//在数组初始化的时候，限制了数组的大小，有没有别的方式更好呢？
	private Book[] bookList=new Book[MAXSIZE];

	ArrayList<Book> bookArrayList=new ArrayList<>();
	BookList books=new BookList();

//	int[]  shuzu=new int[1];
//	int[] shuzu1={1,2,3};
//	int[] shuzu3=new  int[]{1,2,3};

	private int bookCount=0;//都是数组带来的烦恼？还得防止越界；
	//获取标准输入流
	private Scanner input=new Scanner(System.in);



	HRS(){

		while(true)
		{

			System.out.println("-----欢迎进入大表锅的图书管理系统-----");
			System.out.println("添加图书请按----1");
			System.out.println("删除图书请按----2");
			System.out.println("修改图书请按----3");
			System.out.println("查询图书请按----4");
			System.out.println("退出请按--------5");


			int choice=input.nextInt();
			//除了用if 还能用什么方式可以实现逻辑判断？
			if(choice==1)
			{
				addBook();
			}
			else if(choice==2)
			{
				deleteBook();
			}
			else if(choice==3)
			{
				updateBook();
			}
			else if(choice==4)
			{
				searchBook();
			}
			else if(choice==5)
			{
				break;
			}else {
				System.out.println("输入错误，请重新输入");
			}
		}
		input.close();//流啊 连接啊 这些东西 用完记得关；要么记得还（那么什么地方是需要还的，什么地方是关的）；
		System.out.println("您已经退出图书管理系统");
	}

	//添加图书
	void addBook()
	{
		System.out.println("欢迎进入添加图书界面");
		if(bookCount<MAXSIZE)//判断图书管理系统是否未满
		{
			Scanner input=new Scanner(System.in);
			System.out.println("请依次输入需要添加的图书名，作者，价格");
			String bookName=input.nextLine();
			String bookAuthor=input.nextLine();
			float bookPrice=input.nextFloat();

			//get/SET
			Book book=new Book(bookName,bookAuthor,bookPrice);

			//如果这个时候已经有79本书了，那么第79本书的位置是几
			bookList[bookCount]=book;
			bookCount++;
			System.out.println("您已经成功添加图书");
			showBook();
		}
		else{
			System.out.println("图书管理系统已满，无法添加图书");
		}
	}

	//删除图书
	void deleteBook()
	{
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		System.out.println("欢迎进入删除图书界面");
		System.out.println("请输入需要删除的图书名");
		bookList.
		String bookName=input.nextLine();
		if(bookCount!=0)//图书管理系统不为空
		{
			for(int i=0;i<bookCount;i++)
			{
				if(bookList[i].bookName.equals(bookName))
				{
					for(int j=i;j<bookCount-1;j++)
					{
						bookList[j]=bookList[j+1];
					}
					System.out.println("您已经成功删除图书");
					bookCount--;
					break;
				}
				else if(i==bookCount-1) {
					System.out.println("没有找到该书籍");
				}
			}
			showBook();
		}
		else{
			System.out.println("图书系统为空，没有找到该书籍");
		}
//		input.close();
	}

	//修改图书
	void updateBook()
	{
		Scanner input=new Scanner(System.in);
		System.out.println("欢迎进入修改图书界面");
		System.out.println("请输入需要修改的图书名");
		String bookName=input.nextLine();
		if(bookCount!=0)//图书管理系统不为空
		{
			for(int i=0;i<bookCount;i++)
			{
				if(bookList[i].bookName.equals(bookName))
				{
					System.out.println("请依次输入新的书名，作者，价格");
					String newbookName=input.nextLine();
					String newbookAuthor=input.nextLine();
					float newbookPrice=input.nextFloat();
					Book book=new Book(newbookName,newbookAuthor,newbookPrice);
					bookList[i]=book;
					System.out.println("您已经修改成功");
					showBook();
				}
				else if(i==bookCount-1||bookCount==0) {
					System.out.println("没有查找到该书籍");
				}
			}
		}
		else{
			System.out.println("系统为空，没有查找到该书籍");
		}
//		input.close();
	}

	//查询图书
	void searchBook()
	{
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		System.out.println("欢迎进入查询图书界面");
		System.out.println("请输入需要查询的图书名");
		String bookName=input.nextLine();
		for(int i=0;i<bookCount;i++)
		{
			if(bookList[i].bookName.equals(bookName))
			{
				System.out.println("<<"+bookList[i].bookName+">>"+"\n"+
									"作者"+":"+bookList[i].bookAuthor+"\n"
									+"价格"+":"+bookList[i].bookPrice+"\n"
									+"位于第"+(i+1)+"位置");
				break;
			}
			else if(i==bookCount-1) {
				System.out.println("没有查找到该书籍，请重新输入");
			}
		}
//		input.close();
	}

	//图书遍历
	void showBook()
	{
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		System.out.println("是否需要打印所有图书，是请输入Y，不用打印则输入任意");
		String XUANZE=input.nextLine();
		String Y="Y";
		if(XUANZE.equals(Y))
		{
			System.out.println("本图书管理系统共有"+bookCount+"本书");
			for(int i=0;i<bookCount;i++) {
				System.out.println("第"+(i+1)+"本"+"----"+"<<"+bookList[i].bookName+">>");
			}
		}
//		input.close();
	}
	
	public static void main(String[] args)
	{
		new HRS();
	}
}