package bean;


public class Book
{
	//这里修饰符用public合理吗？是否有更好的方式
	public String bookName;
	public String bookAuthor;
	public double bookPrice;
	
	public Book(String bookName,String bookAuthor,double bookPrice)
	{
		this.bookName=bookName;
		this.bookAuthor=bookAuthor;
		this.bookPrice=bookPrice;
	}
	
}
