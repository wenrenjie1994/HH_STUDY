/**
 * A program for JAVA作业---图书管理系统
 * @version 2.0 2016-03-23
 * @author 文仁杰 2014214225
 */
package library06;
import bean.Book;
import bean.BookList;
import work.Action;

import java.util.Scanner;


public class LMS06
{
	public LMS06()
	{
		Scanner input = new Scanner(System.in);
		//*************************主页面提示*******************************
		while(true)
		{
			
			//.openData();
			System.out.println("************欢迎来到图书管理系统************");
			System.out.println("增加图书请按----------1");
			System.out.println("删除图书请按----------2");
			System.out.println("修改图书请按----------3");
			System.out.println("查询图书请按----------4");
			System.out.println("退出请按--------------5");
		//if语句指令判断
			int choice =input.nextInt();
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

			}
			else if(choice==4)
			{
				searchBook();
			}
			else if(choice==5)
			{
				break;
			}
			else {
				System.out.println("输入错误，请确认后从新输入");
			}
		}
		System.out.println("您已退出图书管理系统");
	}
	//*************************添加图书*******************************
	void addBook()
	{
		System.out.println("欢迎来到添加图书界面");
		Scanner input = new Scanner(System.in);
		System.out.println("请依次输入需要添加图书名，作者，价格");
		String bookName=input.nextLine();
		String bookAuthor =input.nextLine();
		double bookPrice =input.nextDouble();
		Book book=new Book(bookName,bookAuthor,bookPrice);
		Action a =new Action();
		int line=a.addbook(book);
		if(line>0){
			System.out.println("添加图书成功");
		}
		else
		{
			System.out.println("添加图书失败");
		}
	}
	//*************************删除图书*******************************
	void deleteBook() 
	{
		while(true)
		{
		Scanner input = new Scanner(System.in);
		System.out.println("************欢迎来到删除图书界面************");
		System.out.println("按书名删除请按----------1");
		System.out.println("按作者删除请按----------2");
		System.out.println("退出请按--------------3");
		int choice =input.nextInt();
		if(choice==1)
		{
			deleteByName();
		}
		else if(choice==2)
		{
			deleteByAuthor();
		}
		else if(choice==3)
		{
			break;
		}
		}
		
	}

	void deleteByName() {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入需要删除的图书名");
		String bookName =input.nextLine();
		Book book=new Book(bookName,null,0);
		Action d =new Action();
		int line=d.deleteBookByName(book);
		if(line>0)
		{
			System.out.println("删除图书成功");
		}
		else
		{
			System.out.println("没有找到该图书，无法删除");
		}
		
	}
	void deleteByAuthor() {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入需要删除的图书作者");
		String bookAuthor =input.nextLine();
		Book book=new Book(null,bookAuthor,0);
		Action d =new Action();
		int line=d.deleteBookByAuthor(book);
		if(line>0)
		{
			System.out.println("删除图书成功");
		}
		else
		{
			System.out.println("没有找到相应图书，无法删除");
		}
	}
	//*************************查询图书*******************************
	void searchBook()
	{
		while(true)
		{
		System.out.println("************欢迎来到查询图书界面************");
		System.out.println("按书名查找请按----------1");
		System.out.println("按作者查找请按----------2");
		System.out.println("按价格查找请按----------3");
		System.out.println("模糊查找请按------------4");
		System.out.println("退出请按----------------5");
		Scanner input = new Scanner(System.in);
		int choice =input.nextInt();
		if(choice==1)
		{
			searchBookByName();
		}
		else if(choice==2)
		{
			searchBookByAuthor();
		}
		else if(choice==3)
		{
			searchBookByPrice();
		}
		else if(choice==4)
		{
			searchBookByPointword();
		}
		else if(choice==5)
		{
			break;
		}
		else{
			System.out.println("别瞎几把输入");
		}
		}
			
	}

	void searchBookByName() 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("请输入需要查询的图书名");
		String bookName =input.nextLine();
		Book book=new Book(bookName,null,0);
		Action s = new Action();
		BookList booklist=s.searchBookByName(book);
		int bookCount = booklist.size();
		if(bookCount>0)
		{
		for(int i=0;i<bookCount;i++) {
			System.out.println("<<"+booklist.get(i).bookName+">>"+"  "
								+"作者"+"："+booklist.get(i).bookAuthor+"  "
								+"价格"+"："+booklist.get(i).bookPrice+"  ");
		}
		}
		else {
			System.out.println("没有找到书名为"+bookName+"的图书");
		}
		
	}
	void searchBookByAuthor() 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("请输入需要查询的图书的作者");
		String bookAuthor =input.nextLine();
		Book book=new Book(null,bookAuthor,0);
		Action s = new Action();
		BookList booklist=s.searchBookByAuthor(book);
		int bookCount = booklist.size();
		if(bookCount>0)
		{
		for(int i=0;i<bookCount;i++)
			System.out.println("<<"+booklist.get(i).bookName+">>"+"  "
								+"作者"+"："+booklist.get(i).bookAuthor+"  "
								+"价格"+"："+booklist.get(i).bookPrice+"  ");
		}
		else
			System.out.println("没有找到作者为"+bookAuthor+"的图书");
		
	}
	void searchBookByPrice()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("请输入需要查询的图书的价格");
		Double bookPrice =input.nextDouble();
		Book book=new Book(null,null,bookPrice);
		Action s = new Action();
		BookList booklist=s.searchBookByPrice(book);
		int bookCount = booklist.size();
		if(bookCount>0)
		{
		for(int i=0;i<bookCount;i++) {
			System.out.println("<<"+booklist.get(i).bookName+">>"+"  "
								+"作者"+"："+booklist.get(i).bookAuthor+"  "
								+"价格"+"："+booklist.get(i).bookPrice+"  ");
		}
		}
		else {
			System.out.println("没有找到价格为"+bookPrice+"的图书");
		}
	}
	void searchBookByPointword()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("请输入关键字");
		String bookName=input.nextLine();
		Book book=new Book(bookName,null,0);
		Action s = new Action();
		BookList booklist=s.searchBookByPointword(book);
		int bookCount = booklist.size();
		if(bookCount>0)
		{
		for(int i=0;i<bookCount;i++) {
			System.out.println("<<"+booklist.get(i).bookName+">>"+"  "
								+"作者"+"："+booklist.get(i).bookAuthor+"  "
								+"价格"+"："+booklist.get(i).bookPrice+"  ");
		}
		}
		else {
			System.out.println("没有找到与"+bookName+"相关的图书");
		}
	}

	public static void main(String[] args)
	{
		new LMS06();
	}
}