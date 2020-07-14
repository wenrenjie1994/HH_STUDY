package service;

import model.Book;

import java.util.LinkedList;
import java.util.Scanner;

public class BookService {
    public static void addBook(LinkedList<Book> bookList) {
        System.out.println("欢迎来到添加图书界面");
        Scanner input = new Scanner(System.in);
        System.out.println("请依次输入需要添加图书名，作者，价格");
        String bookName = input.nextLine();
        String bookAuthor = input.nextLine();
        float bookPrice = input.nextFloat();
        Book book = new Book(bookName, bookAuthor, bookPrice);
        bookList.add(book);
        System.out.println("您已成功添加图书");
        showBook(bookList);
    }

    public static void deleteBook(LinkedList<Book> bookList) {
        Scanner input = new Scanner(System.in);
        System.out.println("欢迎来到删除图书界面");
        System.out.println("请输入需要删除的图书名");
        String bookName = input.nextLine();
        int bookCount = bookList.size();
        for (int i = 0; i < bookCount; i++) {
            if (bookList.get(i).bookName.equals(bookName)) {
                bookList.remove(i);
                System.out.println("您已成功删除图书");
                break;
            } else if (i == bookCount - 1) {
                System.out.println("没有查找到该书籍");
            }
        }
        showBook(bookList);
    }


    public static void updateBook(LinkedList<Book> bookList) {
        Scanner input = new Scanner(System.in);
        System.out.println("欢迎来到修改图书界面");
        System.out.println("请输入需要修改的图书名");
        String bookName = input.nextLine();
        int bookCount = bookList.size();
        for (int i = 0; i < bookCount; i++) {
            if (bookList.get(i).bookName.equals(bookName)) {
                System.out.println("请依次输入新的书名，作者，价格");
                String newbookName = input.nextLine();
                String newbookAuthor = input.nextLine();
                float newbookPrice = input.nextFloat();
                Book book = new Book(newbookName, newbookAuthor, newbookPrice);
                bookList.set(i, book);
                System.out.println("您已成功修改成功");
                showBook(bookList);
            } else if (i == bookCount - 1 || bookCount == 0) {
                System.out.println("没有查找到该书籍");
            }
        }
        System.out.println("没有查找到该书籍");
    }

    public static void showBook(LinkedList<Book> bookList) {
        Scanner input = new Scanner(System.in);
        System.out.println("是否需要打印所有图书，是请输入Y，不用打印则输入任意");
        String XUANZE = input.nextLine();
        String Y = "Y";
        if (XUANZE.equals(Y)) {
            System.out.println("本图书管理系统共有" + bookList.size() + "本书");
            int bookCount = bookList.size();
            for (int i = 0; i < bookCount; i++) {
                System.out.println("第" + (i + 1) + "本" + "---------" + "<<" + bookList.get(i).bookName + ">>");
            }
        }
    }
}
