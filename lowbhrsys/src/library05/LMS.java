/**
 * A program for JAVA第一节课作业---图书管理系统
 * @version 1.2 2016-03-11
 * @author 文仁杰 2014214225
 */
package library05;
import java.util.LinkedList;
import java.util.Scanner;
import loadandsaveData.DataOperate;
import model.Book;
import service.BookService;

public class LMS
{
	public static void main(String[] args) {

		LinkedList<Book> bookList = new LinkedList<Book>();
		Scanner input = new Scanner(System.in);
		DataOperate.loadData(bookList);//下载所有图书
		while(true)
		{
			System.out.println("************欢迎来到陈老板图书管理系统************");
			System.out.println("增加图书请按----------1");
			System.out.println("删除图书请按----------2");
			System.out.println("修改图书请按----------3");
			System.out.println("查询图书请按----------4");
			System.out.println("退出请按--------------5");
		//if语句指令判断
			int choice =input.nextInt();
			if(choice==1)
			{
				BookService.addBook(bookList);
			}
			else if(choice==2)
			{
				BookService.deleteBook(bookList);
			}
			else if(choice==3)
			{
				BookService.updateBook(bookList);
			}
			else if(choice==4)
			{
				BookService.showBook(bookList);
			}
			else if(choice==5)
			{
				DataOperate.saveData(bookList);
				break;
			}
			else {
				System.out.println("输入错误，请确认后从新输入");
			}
		}
		System.out.println("您已退出图书管理系统");
	}
}