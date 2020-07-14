package util;

import medol.Book;
import medol.BookList;
import medol.ReturnResult;

public class Parser
{
	public Parser()
	{
		
	}
	static String[] amessage;
	static String head;
	static ReturnResult ss;
	static String message;
	public ReturnResult parser(String str)
	{
		/*
		 * 先按“/n”劈开得到想要的操作和操作数据
		 * if语句判断操作
		 * 把操作数据用相应的parser方法解析存到BookList中
		 * 令ReturnResult的head=劈开得到的head
		 * 令ReturnResult的resultData等于BookList
		 * */
		amessage=str.split("/n");
		head=amessage[0];
		message=amessage[1];
		ss=new ReturnResult();
		ss.head=head;
		if(head.equals("add"))
		{
			BookList bookList=parserAdd(message);
			ss.resultData=bookList;
		}
		else if(head.equals("deletebyname"))
		{
			BookList bookList=parserDeleteByName(message);
			ss.resultData=bookList;
		}
		else if(head.equals("deletebyauthor"))
		{
			BookList bookList=parserDeleteByAuthor(message);
			ss.resultData=bookList;
		}
		else if(head.equals("change"))
		{
			BookList bookList=parserChangeBook(message);
			ss.resultData=bookList;
		}
		else if(head.equals("searchbyname"))
		{
			BookList bookList=parserSearchByName(message);
			ss.resultData=bookList;
		}
		else if(head.equals("searchbyauthor"))
		{
			BookList bookList=parserSearchByAuthor(message);
			ss.resultData=bookList;
		}
		else if(head.equals("searchbyprice"))
		{
			BookList bookList=parserSearchByPrice(message);
			ss.resultData=bookList;
		}
		else if(head.equals("searchbykeyword"))
		{
			BookList bookList=parserSearchByKeyWord(message);
			ss.resultData=bookList;
		}
		return ss;
		
	}
	/*
	 * “;”劈开得到Book的三个属性
	 * 	","劈开book的三个属性存在Book中
	 * 最后都存在BookList中返回
	 * * */
	public BookList parserAdd(String message) {
		String[] str=message.split(",");
		String bookName=str[0];
		String bookAuthor=str[1];
		double bookPrice=Double.parseDouble(str[2]);
		Book book=new Book(bookName,bookAuthor,bookPrice);
		BookList bookList=new BookList();
		bookList.add(book);
		return bookList;
		
	}
	public BookList parserDeleteByName(String message) {
		String bookName=message;
		String bookAuthor=null;
		double bookPrice=0;
		Book book=new Book(bookName,bookAuthor,bookPrice);
		BookList bookList=new BookList();
		bookList.add(book);
		return bookList;
		
	}
	public BookList parserDeleteByAuthor(String message) {
		String bookName=null;
		String bookAuthor=message;
		double bookPrice=0;
		Book book=new Book(bookName,bookAuthor,bookPrice);
		BookList bookList=new BookList();
		bookList.add(book);
		return bookList;
		
	}
	public BookList parserChangeBook(String message) {
		String[] str=message.split(";");
		String[] oldbookmessage=str[0].split(",");
		String oldbookName=oldbookmessage[0];
		String oldbookAuthor=oldbookmessage[1];
		double oldbookPrice=Double.parseDouble(oldbookmessage[2]);
		String[] bookmessage=str[1].split(",");
		String bookName=bookmessage[0];
		String bookAuthor=bookmessage[1];
		double bookPrice=Double.parseDouble(bookmessage[2]);
		Book oldbook=new Book(oldbookName,oldbookAuthor,oldbookPrice);
		BookList bookList=new BookList();
		bookList.add(oldbook);
		Book book=new Book(bookName,bookAuthor,bookPrice);
		bookList.add(book);
		return bookList;
	}
	public BookList parserSearchByName(String message) {
		String bookName=message;
		Book book=new Book(bookName,null,0);
		BookList bookList=new BookList();
		bookList.add(book);
		return bookList;
		
	}
	public BookList parserSearchByAuthor(String message) {
		String bookAuthor=message;
		Book book=new Book(null,bookAuthor,0);
		BookList bookList=new BookList();
		bookList.add(book);
		return bookList;
		
	}
	public BookList parserSearchByPrice(String message) {
		double bookPrice=Double.parseDouble(message);
		Book book=new Book(null,null,bookPrice);
		BookList bookList=new BookList();
		bookList.add(book);
		return bookList;
	}
	public BookList parserSearchByKeyWord(String message) {
		String bookName=message;
		Book book=new Book(bookName,null,0);
		BookList bookList=new BookList();
		bookList.add(book);
		return bookList;
	}

}
