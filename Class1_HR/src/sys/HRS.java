package sys;

import pojo.Book;
import pojo.BookList;
import java.util.Scanner;

public class HRS {
    public static void main(String[] args) {
        new HRS();
    }
    private int MAXSIZE = 50;
    private  Book[] bookList = new Book[MAXSIZE];
    BookList books = new BookList();

    private int bookCount=0;
    private Scanner sc=new Scanner(System.in);

    HRS(){
        while(true)
        {
            System.out.println("-----图书管理测试系统-----");
            System.out.println("添加图书----1");
            System.out.println("删除图书----2");
            System.out.println("修改图书----3");
            System.out.println("查询图书----4");
            System.out.println("退出--------5");
            int choice=sc.nextInt();
            if(choice==1)
            {
                addBook();
            }
            else if(choice==2)
            {
                deleteBook();
            }
            else if(choice==3)
            {
                updateBook();
            }
            else if(choice==4)
            {
                searchBook();
            }
            else if(choice==5)
            {
                break;
            }else {
                System.out.println("非法输入，请重新输入");
            }
        }
        sc.close();
        System.out.println("您已经退出系统");
    }
    //增加
    void addBook()
    {
        System.out.println("欢迎进入添加图书界面");
        if(bookCount<MAXSIZE)//判断是否能够添加
        {
            Scanner input=new Scanner(System.in);
            System.out.println("请依次输入图书名，作者，价格");
            String bookName=input.nextLine();
            String bookAuthor=input.nextLine();
            Double bookPrice=input.nextDouble();
            Book book=new Book(bookName,bookAuthor,bookPrice);

            bookList[bookCount]=book;
            bookCount++;
            System.out.println("成功添加图书");
            showBook();
        }
        else{
            System.out.println("系统已满，无法添加");
        }
    }

    //删除
    void deleteBook()
    {
        @SuppressWarnings("resource")
        Scanner input=new Scanner(System.in);
        System.out.println("请输入需要删除的图书名");
        String bookName=input.nextLine();
        if(bookCount!=0)//图书管理系统不为空
        {
            for(int i=0;i<bookCount;i++)
            {
                if(bookList[i].getBookName().equals(bookName))
                {
                    for(int j=i;j<bookCount-1;j++)
                    {
                        bookList[j]=bookList[j+1];
                    }
                    System.out.println("您已经成功删除图书");
                    bookCount--;
                    break;
                } else if(i==bookCount-1) {
                    System.out.println("没有找到该书籍");
                }
            }
            showBook();
        }
        else{
            System.out.println("图书系统为空，没有找到该书籍");
        }
    }

    //改
    void updateBook()
    {
        Scanner input=new Scanner(System.in);
        System.out.println("请输入需要修改的图书名");
        String bookName=input.nextLine();
        if(bookCount!=0)
        {
            for(int i=0;i<bookCount;i++)
            {
                if(bookList[i].getBookName().equals(bookName))
                {
                    System.out.println("请依次输入新的书名，作者，价格");
                    String newbookName=input.nextLine();
                    String newbookAuthor=input.nextLine();
                    Double newbookPrice=input.nextDouble();
                    Book book=new Book(newbookName,newbookAuthor,newbookPrice);
                    bookList[i]=book;
                    System.out.println("您已经修改成功");
                    showBook();
                } else if(i==bookCount-1||bookCount==0) {
                    System.out.println("没有查找到该书籍");
                }
            }
        }
        else{
            System.out.println("系统为空，没有查找到该书籍");
        }
    }

    //查
    void searchBook()
    {
        @SuppressWarnings("resource")
        Scanner input=new Scanner(System.in);
        System.out.println("请输入需要查询的图书名");
        String bookName=input.nextLine();
        for(int i=0;i<bookCount;i++)
        {
            if(bookList[i].getBookName().equals(bookName))
            {
                System.out.println("<<"+bookList[i].getBookName()+">>"+"\n"+
                        "作者:"+bookList[i].getBookAuthor()+"\n"
                        +"价格:"+bookList[i].bookPrice+"\n"
                        +"位于第"+(i+1)+"位置");
                break;
            }
            else if(i==bookCount-1) {
                System.out.println("没有查找到该书籍，请重新输入");
            }
        }
    }

    //遍历
    void showBook()
    {
        @SuppressWarnings("resource")
        Scanner input=new Scanner(System.in);
        System.out.println("是否需要打印所有图书，是请输入Y/y，不用打印则输入任意");
        String XUANZE=input.nextLine();
        String Y="Y";
        String y="y";
        if(XUANZE.equals(Y)||XUANZE.equals(y))
        {
            System.out.println("共"+bookCount+"本书");
            for(int i=0;i<bookCount;i++) {
                System.out.println("第"+(i+1)+"本书"+"<<"+bookList[i].getBookName()+">>");
            }
        }
    }
}
