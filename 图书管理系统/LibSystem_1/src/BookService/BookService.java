/*
* 图书各个操作功能
*
* */

package BookService;

import java.util.LinkedList;
import java.util.Scanner;

import Model.Book;
public class BookService {
    //1、增加图书
    public static void addbook(LinkedList<Book>booklist){
        System.out.println("*****************欢迎来到图书添加操作界面******************");
        System.out.println("请输入待增加图书的书名：");
        Scanner Input_list = new Scanner(System.in);
        String BookName= Input_list.nextLine();

        System.out.println("请输入待增加图书的作者：");
        String BookAuthor= Input_list.nextLine();

        System.out.println("请输入待增加图书的价格：");
        Float BookPrice= Input_list.nextFloat();

        Book book = new Book(BookName,BookAuthor,BookPrice);
        booklist.add(book);
        System.out.println("-----------------您已成功添加图书！--------------------------");
        BookService.showbook(booklist);

    }

    //2、删除图书
    public static void deletebook(LinkedList<Book> booklist){
        System.out.println("*****************欢迎来到图书删除操作界面******************");
        System.out.println("请输入需要删除的图书名字：");
        Scanner Input_list = new Scanner(System.in);
        String BookName = Input_list.nextLine();

        int index=0;
        for(Book book:booklist){//遍历
            if(book.Bookname.equals(BookName)){
                booklist.remove(index);
                System.out.println("-----------------该书删除成功！-------------------");
                break;
            }
            else if(index == booklist.size()-1){
                System.out.println("-----------------系统中没有该图书！----------------");
                break;
            }
            index++;
        }
        BookService.showbook(booklist);
    }

    //3、更改图书信息
    public static void updatebook(LinkedList<Book> booklist){
        System.out.println("***************欢迎进入图书信息更改界面***************");
        System.out.println("请输入需要信息更改的图书名：");
        Scanner Input = new Scanner(System.in);
        String updatename = Input.nextLine();
        for(int index = 0;index<booklist.size();index++){//遍历
            if(booklist.get(index).Bookname.equals(updatename)){//判断书名书否一致
                System.out.println("请输入新的图书名：");
                String name = Input.nextLine();
                System.out.println("请输入新的作者名：");
                String author = Input.nextLine();
                System.out.println("请输入该书的价格：");
                float price = Float.parseFloat(Input.nextLine());
                Book book = new Book(name,author,price);
                booklist.set(index,book);
            }
            else if(index == booklist.size()-1){
                System.out.println("------------系统中没有该书籍，请仔细检查书名是否输入正确！---------");
            }
        }
        BookService.showbook(booklist);
    }

    //查询图书信息
    public static void searchbook(LinkedList<Book> booklist){
        System.out.println("*****************欢迎来到图书查询界面******************");
        System.out.println("是否查询单本图书信息，如果是请输入Y(或y),否则键入任意键！");
        Scanner Input = new Scanner(System.in);
        String single = Input.nextLine();
        if(single.equals("Y") || single.equals("y")){
            System.out.println("请输入需要查询的图书名：");
            String name = Input.nextLine();
            int index=0;
            for(Book book:booklist){//遍历系统中的书籍
                if(book.Bookname.equals(name)){
                    System.out.println("图书名： "+book.Bookname+"      "+"作者："+book.BookAuthor+"      "+"书的价格："+book.BookPrice);
                }
                else if(index == booklist.size()){
                    System.out.println("------------系统中没有该书籍，请仔细检查书名是否输入正确！---------");
                }
                index++;
            }
        }
        BookService.showbook(booklist);
    }

    //是否展示操作后的图书信息
    public static void showbook(LinkedList<Book> booklist){
        System.out.println("是否需要打印所有图书信息，如果需要打印请输入Y(或者y);否则键入任意值退出！");
        Scanner Input = new Scanner(System.in);
        String IFP = Input.nextLine();
        if(IFP.equals("Y") || IFP.equals("y") ){
            if(booklist.size()>0){
                for(Book book:booklist){
                    System.out.println(book.Bookname+"，"+book.BookAuthor+","+book.BookPrice);
                }
            }
            else{
                System.out.println("--------------系统中没有书籍，请进行图书添加操作！----------------");
            }

        }
    }
}
