package util;

import medol.ActionResult;
import medol.BookList;

public class Protocol {
	public Protocol()
	{
		
	}
	/*
	 * 把ActionResult的三个属性按ActionResult.isSuccess+"/n"+failReason或者ActionResult.isSuccess+"/n"+（ActionResult.resultData
	 * 得到的字符串）格式编写
	 * 在for循环里得到ActionResult.resultData的字符串
	 * */
	public String AddBookMessage(ActionResult ar)
	{	
		String str;
		String isSuccess=ar.isSuccess;
		if(isSuccess.equals("Success"))
		{
			str=isSuccess+"/n";
		}
		else
		{
			str=isSuccess+"/n"+ar.failReason;
		}
		return str;
	}
	public String deleteBookByNameMessage(ActionResult ar)
	{
		String str;
		String isSuccess=ar.isSuccess;
		if(isSuccess.equals("Success"))
		{
			str=isSuccess+"/n";
		}
		else
		{
			str=isSuccess+"/n"+ar.failReason;
		}
		return str;
	}
	public String deleteBookByAuthorMessage(ActionResult ar)
	{
		String str;
		String isSuccess=ar.isSuccess;
		if(isSuccess.equals("Success"))
		{
			str=isSuccess+"/n";
		}
		else
		{
			str=isSuccess+"/n"+ar.failReason;
		}
		return str;
	}
	public String changeBookMessage(ActionResult ar)
	{
		String str;
		String isSuccess=ar.isSuccess;
		if(isSuccess.equals("Success"))
		{
			str=isSuccess+"/n";
		}
		else
		{
			str=isSuccess+"/n"+ar.failReason;
		}
		return str;
	}
	public String searchBookByNameMessage(ActionResult ar)
	{
		String str;
		String isSuccess=ar.isSuccess;
		if(isSuccess.equals("Success"))
		{
			BookList bookList=(BookList)ar.resultData;
			str=isSuccess+"/n";
			//for循环得到ActionResult.resultData字符对应的字符串
			int booksize=bookList.size();
			for(int i=0;i<booksize;i++)
			{
				String bookstring=bookList.get(i).bookName+","+bookList.get(i).bookAuthor+","+bookList.get(i).bookPrice+";";
				str=str+bookstring;
			}
		}
		else
		{
			str=isSuccess+"/n"+ar.failReason;
		}
		return str;
	}
	public String searchBookByAuthorMessage(ActionResult ar)
	{
		String str;
		String isSuccess=ar.isSuccess;
		if(isSuccess.equals("Success"))
		{
			BookList bookList=(BookList)ar.resultData;
			str=isSuccess+"/n";
			//for循环得到ActionResult.resultData字符对应的字符串
			int booksize=bookList.size();
			for(int i=0;i<booksize;i++)
			{
				String bookstring=bookList.get(i).bookName+","+bookList.get(i).bookAuthor+","+bookList.get(i).bookPrice+";";
				str=str+bookstring;
			}
		}
		else
		{
			str=isSuccess+"/n"+ar.failReason;
		}
		return str;
	}
	public String searchBookByPriceMessage(ActionResult ar)
	{	
		String str;
		
		String isSuccess=ar.isSuccess;
		if(isSuccess.equals("Success"))
		{
			BookList bookList=(BookList)ar.resultData;
			str=isSuccess+"/n";
			//for循环得到ActionResult.resultData字符对应的字符串
			int booksize=bookList.size();
			for(int i=0;i<booksize;i++)
			{
				String bookstring=bookList.get(i).bookName+","+bookList.get(i).bookAuthor+","+bookList.get(i).bookPrice+";";
				str=str+bookstring;
			}
		}
		else
		{
			str=isSuccess+"/n"+ar.failReason;
		}
		return str;

	}
	public String searchBookByKeyWordMessage(ActionResult ar)
	{
		String str;
		String isSuccess=ar.isSuccess;
		if(isSuccess.equals("Success"))
		{
			BookList bookList=(BookList)ar.resultData;
			str=isSuccess+"/n";
			//for循环得到ActionResult.resultData字符对应的字符串
			int booksize=bookList.size();
			for(int i=0;i<booksize;i++)
			{
				String bookstring=bookList.get(i).bookName+","+bookList.get(i).bookAuthor+","+bookList.get(i).bookPrice+";";
				str=str+bookstring;
			}
		}
		else
		{
			str=isSuccess+"/n"+ar.failReason;
		}
		return str;
	}
}
