package util;

import model.Resume;
import model.ResumeList;
import model.ReturnResult;

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
			ResumeList bookList=parserAdd(message);
			ss.resultData=bookList;
		}
		return ss;
		
	}
	/*
	 * “;”劈开得到Book的三个属性
	 * 	","劈开book的三个属性存在Book中
	 * 最后都存在BookList中返回
	 * * */
	public ResumeList parserAdd(String message) {
		String[] str=message.split(",");
		String bookName=str[0];
		String bookAuthor=str[1];
		String bookPrice=str[2];
		/*double bookPrice=Double.parseDouble(str[2]);*/
		Resume book=new Resume(bookName,bookAuthor,bookPrice);
		ResumeList bookList=new ResumeList();
		bookList.add(book);
		return bookList;
		
	}

}
