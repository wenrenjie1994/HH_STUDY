package service;

import bean.Book;
import java.util.List;
import java.util.Scanner;

public class BookServiceImpl implements BookService{
    @Override
    public void addBook(List<Book> bookList) {
        System.out.println("欢迎进入添加图书界面");
        System.out.println("清依次添加图书名，作者，价格");
        Scanner input = new Scanner(System.in);
        String bookName = input.nextLine();
        String bookAuthor = input.nextLine();
        double bookPrice = input.nextDouble();

        Book book = new Book(bookName, bookAuthor,bookPrice);
        bookList.add(book);
        System.out.println("你已成功添加图书");
        showBook(bookList);
    }

    @Override
    public void showBook(List<Book> bookList) {
        System.out.println("本图书系统共有"+bookList.size()+"本图书");
        for(Book book : bookList)
            System.out.println(book);
    }

    @Override
    public void removeBook(List<Book> bookList) {
        System.out.println("欢迎进入删除图书界面");
        System.out.println("请输入需要删除的图书名");
        Scanner input = new Scanner(System.in);
        String bookName = input.nextLine();
        if(bookList.size() <= 0){
            System.out.println("图书系统中书籍为空");
        }
        for (Book book : bookList){
            if(book.getBookName().equals(bookName)){
                bookList.remove(book);
                System.out.println("你已成功删除该图书");
                return;
            }
        }
        System.out.println("没有找到该书籍");
    }

    @Override
    public void queryBook(List<Book> bookList) {
        System.out.println("欢迎进入查询图书界面");
        System.out.println("清输入需要查询的图书名");
        Scanner input = new Scanner(System.in);
        String bookName = input.nextLine();
        for (Book book : bookList){
            if(book.getBookName().equals(bookName)){
                System.out.println(book);
                return;
            }
        }
        System.out.println("没有查询到该书籍，请重新输入");
    }

    @Override
    public void updateBook(List<Book> bookList) {
        System.out.println("欢迎进图修改图书界面");
        System.out.println("清输入需要修改的图书名");
        Scanner input = new Scanner(System.in);
        String bookName = input.nextLine();
        if(bookList.size() <= 0){
            System.out.println("图书管理系统为空，没有找到该书籍");
        }
        for(int i=0;i<bookList.size();i++){
            if(bookList.get(i).getBookName().equals(bookName)){
                System.out.println("请依次输入新的图书名，作者，价格");
                String newBookName = input.nextLine();
                String newBookAuthor = input.nextLine();
                double newBookPrice = input.nextDouble();
                Book newBook = new Book(newBookName, newBookAuthor,  newBookPrice);
                bookList.set(i, newBook);
                System.out.println("你已修改成功");
                return;
            }
        }
        System.out.println("没有找到该书籍");
    }
}
