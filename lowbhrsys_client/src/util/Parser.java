package util;

import model.Book;
import model.BookList;
import model.ReturnResult;

public class Parser 
{
	/**先以“/n”劈开得到是否成功和成功结果或者失败原因
	 * 如果失败 returnResult.isSuccess=false returnResult.failReason为劈开的第二部分
	 * 成功了returnResult.isSuccess=true
	 * 再以“;”劈开各本书
	 * 再以“，”劈开每本书的三个属性分别赋给Book存到BookList
	 * 再把BookList放到returnResult.resultData里
	 * 返回returnResult
	 * */
	public ReturnResult parserAdd(String message)
	{
		ReturnResult returnResult = new ReturnResult();
		String[] amessage=message.split("/n");
		if(amessage[0].equals("Success"))
		{
			returnResult.isSuccess = true;
		}
		else
		{
			returnResult.failReason=amessage[1];
		}
		return returnResult;
	}
	public ReturnResult parserDelete(String message)
	{
		ReturnResult returnResult = new ReturnResult();
		String[] amessage=message.split("/n");
		if(amessage[0].equals("Success"))
		{
			returnResult.isSuccess = true;
		}
		else
		{
			returnResult.failReason=amessage[1];
		}
		return returnResult;
	}
	public ReturnResult parserChange(String message)
	{
		ReturnResult returnResult = new ReturnResult();
		String[] amessage=message.split("/n");
		if(amessage[0].equals("Success"))
		{
			returnResult.isSuccess = true;
		}
		else
		{
			returnResult.failReason=amessage[1];
		}
		return returnResult;
	}
	public ReturnResult parserSearch(String message)
	{  
		ReturnResult returnResult = new ReturnResult();
		String[] amessage=message.split("/n");
		if(amessage[0].equals("Success"))
		{
			returnResult.isSuccess = true;
			String[] bookinfo=amessage[1].split(";");
			BookList bookList=new BookList();
			int bookSize=bookinfo.length;
			for(int i=0;i<bookSize;i++)
			{
				String[] book=bookinfo[i].split(",");
				String bookName=book[0];
				String bookAuthor=book[1];
				double bookPrice=Double.parseDouble(book[2]);
				Book Book=new Book(bookName,bookAuthor,bookPrice);
				bookList.add(Book);
			}
			returnResult.resultData=bookList;
		}
		else
		{
			returnResult.isSuccess = false;
			BookList bookList=new BookList();
			returnResult.failReason =amessage[1];
			returnResult.resultData=bookList;
		}
		return returnResult;
	}

}