/*
* 加载数据，并且将操作后的结果进行保存
*
* */

package DataService;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;

import Model.Book;

public class DataOperate {

    /*******************************在刚开始时需要将硬盘中的数据全部读取出来，直到在退出图书管理系统时将处理后的数据进行重新覆盖***********/
    public static void LoadData(LinkedList<Book> BookList){
        File f = new File("E:/Library_System/LibSystem_1/booklist.txt");
        try(FileReader fr = new FileReader(f);BufferedReader br = new BufferedReader(fr);){
            String str = br.readLine();
            if(str == null){
                System.out.println("图书系统中没有书籍，请按1进行增加书籍操作！");
            }
            else{
                while(str != null){
                    String[] arr = str.split(",");
                    String name = arr[0];
                    String author = arr[1];
                    float price = Float.parseFloat(arr[2]);//将String类型转换为float类型
                    Book book = new Book(name,author,price);
                    BookList.add(book);

                    str = br.readLine();
                }
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }

/****************************退出图书管理系统时存储系列操作后的结果************************************8*/
    public static void SaveData(LinkedList<Book> Booklist){
        File f = new File("E:/Library_System/LibSystem_1/booklist.txt");
        Book book = null;

        try(
                //创建文件字符流
                FileWriter fw = new FileWriter(f);
                //缓存流必须建立在一个存在的流的基础上
                PrintWriter pw = new PrintWriter(fw);
                ){
            for(Iterator<Book> iter = Booklist.iterator();iter.hasNext();){
                book = iter.next();
                pw.println(book.Bookname+","+book.BookAuthor+","+book.BookPrice);
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
