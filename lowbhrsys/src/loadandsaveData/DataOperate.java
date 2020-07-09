package loadandsaveData;

import java.io.*;
import java.util.LinkedList;
import model.Book;

@SuppressWarnings("all")
public class DataOperate
{
	public static void loadData(LinkedList<Book> bookList)
	{
	BufferedReader br = null;
	try
		{
			br = new BufferedReader(new FileReader("/Users/Administrator/Desktop/booklist.txt"));
			String data = br.readLine();
			while(data!=null)
				{
					String[] str = data.split(",");
					String bookName =str[0];
					String bookAuthor =str[1];
					float bookPrice = Float.parseFloat(str[2]);
					Book book = new Book(bookName,bookAuthor,bookPrice);
					bookList.add(book);
				  	data = br.readLine();
				}
		}
	 catch(IOException exception)
		{
		 	exception.printStackTrace();
		}
	finally
		{
	  	try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	}

	public static void saveData(LinkedList<Book> bookList)
	{
		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream("/Users/Administrator/Desktop/booklist.txt",false)));//∏≤∏«–¥»Î
			int bookCount = bookList.size();
			for(int i=0;i<bookCount;i++)
			{
				printWriter.println(bookList.get(i).bookName+","+bookList.get(i).bookAuthor+","+bookList.get(i).bookPrice);
			}
			printWriter.flush();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			printWriter.close();
		}
	}
}
