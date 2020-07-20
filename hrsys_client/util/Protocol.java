package util;

import bean.Resume;
/**
 * @program: HH_STUDY
 * @description:¸ñÊ½Æ´×°
 * @author: qiu haoran
 * @create: 2020-07-20 15:45
 */
public class Protocol {
	public Protocol()
	{
		
	}
	public String AddResumeMessage(Resume resume)
	{
		String str="add/n"+resume.getName()+","+resume.getId()+","+resume.getSchool()+","+resume.getProcess();
		return str;
	}
//	public String deleteBookByNameMessage(Book book)
//	{
//		String str="deletebyname/n"+book.bookName;
//		return str;
//	}
//	public String deleteBookByAuthorMessage(Book book)
//	{
//		String str="deletebyauthor/n"+book.bookAuthor;
//		return str;
//	}
//	public String changeBookMessage(Book book, Book oldBook)
//	{
//		String str="change/n"+book.bookName+","+book.bookAuthor+","+book.bookPrice+";"+oldBook.bookName+","+oldBook.bookAuthor+","+oldBook.bookPrice;
//		return str;
//	}
//	public String searchBookByNameMessage(Book book)
//	{
//		String str="searchbyname/n"+book.bookName;
//		return str;
//	}
//	public String searchBookByAuthorMessage(Book book)
//	{
//		String str="searchbyauthor/n"+book.bookAuthor;
//		return str;
//	}
//	public String searchBookByPriceMessage(Book book)
//	{
//		String str="searchbyprice/n"+book.bookPrice;
//		return str;
//	}
//	public String searchBookByKeyWordMessage(Book book)
//	{
//		String str="searchbykeyword/n"+book.bookName;
//		return str;
//	}
	public String closenetMessage(String string)
	{
		String str=string+"/n";
		return str;
	}
}

