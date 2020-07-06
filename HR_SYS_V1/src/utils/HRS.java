package utils;


import entity.BookList;
import entity.Book;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author：邓密文
 * @program:
 * @description:
 * @create: Created in 23:28 2020/7/6
 **/
public class HRS {
    private int MAXSIZE=100;
    private Book[] bookList=new Book[MAXSIZE];
    ArrayList<Book> bookArrayList=new ArrayList<Book>();
    BookList books=new BookList();
    private int bookCount=0;
    private Scanner input=new Scanner(System.in);
    public HRS(){
        while (true){
            System.out.println("------欢迎进入邓密文的图书管理系统------");
            System.out.println("添加图书请按----1");
            System.out.println("删除图书请按----2");
            System.out.println("修改图书请按----3");
            System.out.println("查询图书请按----4");
            System.out.println("退出请按--------5");
            int choice=input.nextInt();
            if(choice==1){
                addBook();
            }
            else if(choice==2){
                deleteBook();
            }
            else if(choice==3){
                updateBook();
            }
            else if(choice==4){
                searchBook();
            }
            else if(choice==5){
                break;
            }else{
                System.out.println("输入错误，请重新输入");
            }
        }
        input.close();
        System.out.println("您已退出图书管理系统");
    }
    //添加图书
     void addBook(){
        System.out.println("欢迎进入添加图书界面");
        if(bookCount<MAXSIZE){
            Scanner input=new Scanner(System.in);
            System.out.println("请依次输入需要添加的图书名，作者，价格");
            String bookName=input.nextLine();
            String bookAuthor=input.nextLine();
            double bookPrice=input.nextDouble();
            Book book=new Book(bookName,bookAuthor,bookPrice);
            bookList[bookCount]=book;
            bookCount++;
            System.out.println("您已经成功添加图书");
            showBook();
        }else{
            System.out.println("图书管理系统已满，无法添加图书");
        }

    }
    //删除图书
    void deleteBook(){
        Scanner input=new Scanner(System.in);
        System.out.println("欢迎进入删除图书界面");
        System.out.println("请输入需要删除的图书名");
        String bookName=input.nextLine();
        if(bookCount!=0){
            for(int i=0;i<bookCount;i++){
                if(bookList[i].bookName.equals(bookName)){
                    for(int j=i;i<bookCount-1;j++){
                        bookList[j]=bookList[j+1];
                    }
                    System.out.println("您已经成功删除图书");
                    bookCount--;
                    break;
                }
                else if(i==bookCount-1){
                    System.out.println("没有找到该图书");
                }
            }
            showBook();
        }else{
            System.out.println("图书系统为空，没有找到该书籍");
        }

    }
    //修改图书
    void updateBook(){
        Scanner input =new Scanner(System.in);
        System.out.println("欢迎进入修改图书界面");
        System.out.println("请输入需要修改的图书名");
        String bookName=input.nextLine();
        if(bookCount!=0){
            for(int i=0;i<bookCount;i++){
                if(bookList[i].bookName.equals(bookName)){
                    System.out.println("请依次输入新的书名，作者，价格");
                    String newbookName=input.nextLine();
                    String newbookAuthor=input.nextLine();
                    double newbookPrice=input.nextDouble();
                    Book book=new Book(newbookName,newbookAuthor,newbookPrice);
                    bookList[i]=book;
                    System.out.println("您已经修改成功");
                    showBook();
                }
                else if(i==bookCount-1||bookCount==0){
                    System.out.println("没有查找到该书籍");
                }
            }
        }
        else{
            System.out.println("图书系统为空，没有找到该书籍");
        }

    }
    //查询图书
    void searchBook(){
        Scanner input=new Scanner(System.in);
        System.out.println("欢迎进入查询图书界面");
        System.out.println("请输入需要查询的图书名");
        String bookName=input.nextLine();
        if(bookCount!=0) {
            for (int i = 0; i < bookCount; i++) {
                if (bookList[i].bookName.equals(bookName)) {
                    System.out.println("<<" + bookList[i].bookName + ">>" + "\n"
                            + "作者" + "：" + bookList[i].bookAuthor + "\n"
                            + "价格" + "：" + bookList[i].bookPrice + "\n"
                            + "位于第" + (i + 1) + "位置");
                    break;
                } else if (i == bookCount - 1) {
                    System.out.println("没有查找到该书籍，请重新输入");
                }
            }
        }
        else{
            System.out.println("图书系统为空，没有找到该书籍");
        }

    }
    //图书遍历
    void showBook(){
        Scanner input=new Scanner(System.in);
        System.out.println("是否需要打印所有图书，是请输入Y，不用打印则输入任意");
        String XUANZE=input.nextLine();
        String Y="Y";
        if(XUANZE.equals(Y)){
            System.out.println("本图书管理系统共有"+bookCount+"本书");
            for(int i=0;i<bookCount;i++){
                System.out.println("第"+(i+1)+"本"+"----"+"<<"+bookList[i].bookName+">>");

            }
        }

    }

    //public static void main(String[] args) {
            // write your code here
         //   new HRS();


    //}
}

