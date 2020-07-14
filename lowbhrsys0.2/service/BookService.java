package service;

import bean.Book;
import bean.BookList;
import utils.InputException;
import work.Action;

import java.util.Scanner;

/**
 * @author Administrator
 */
public class BookService {

    // 添加图书
    public static void addBook() {
        System.out.println("欢迎来到添加图书界面");
        Scanner input = new Scanner(System.in);
        System.out.println("请依次输入需要添加图书名，作者，价格");
        System.out.println("图书名:");
        String bookName = input.nextLine();
        System.out.println("作者:");
        String bookAuthor = input.nextLine();
        System.out.println("价格:");
        double bookPrice = input.nextDouble();
        Book book = new Book(bookName, bookAuthor, bookPrice);
        // 实例化与数据库的交互类
        Action a = new Action();
        int line = a.addbook(book);
        if (line > 0) {
            System.out.println("添加图书成功");
        } else {
            System.out.println("添加图书失败");
        }
    }

    // 删除图书
    public static void deleteBook() {
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("************欢迎来到删除图书界面************");
            System.out.println("              1 按书名删除");
            System.out.println("              2 按作者删除");
            System.out.println("              3 退出");
            String choice = input.nextLine();
            try {
                if (choice.equals("1")) {
                    deleteByName();
                } else if (choice.equals("2")) {
                    deleteByAuthor();
                } else if (choice.equals("3")) {
                    break;
                } else {
                    throw new InputException("请输入合法数字");
                }
            } catch (InputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 按图书名删除图书
    public static void deleteByName() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要删除的图书名");
        String bookName = input.nextLine();
        Book book = new Book(bookName, null, 0);
        Action d = new Action();
        int line = d.deleteBookByName(book);
        if (line > 0) {
            System.out.println("删除图书成功");
        } else {
            System.out.println("没有找到该图书，无法删除");
        }

    }

    // 按作者删除图书
    public static void deleteByAuthor() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要删除的图书作者");
        String bookAuthor = input.nextLine();
        Book book = new Book(null, bookAuthor, 0);
        Action d = new Action();
        int line = d.deleteBookByAuthor(book);
        if (line > 0) {
            System.out.println("删除图书成功");
        } else {
            System.out.println("没有找到相应图书，无法删除");
        }
    }

    // 查询图书
    public static void searchBook() {
        while (true) {
            System.out.println("************欢迎来到查询图书界面************");
            System.out.println("               1 按书名查找");
            System.out.println("               2 按作者查找");
            System.out.println("               3 按价格查找");
            System.out.println("               4 模糊查找");
            System.out.println("               5 退出");
            Scanner input = new Scanner(System.in);
            String choice = input.nextLine();
            try {
                if (choice.equals("1")) {
                    searchBookByName();
                } else if (choice.equals("2")) {
                    searchBookByAuthor();
                } else if (choice.equals("3")) {
                    searchBookByPrice();
                } else if (choice.equals("4")) {
                    searchBookByPointword();
                } else if (choice.equals("5")) {
                    break;
                } else {
                    throw new InputException("请输入合法数字");
                }
            } catch (InputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 按书名查询
    public static void searchBookByName() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要查询的图书名");
        String bookName = input.nextLine();
        Book book = new Book(bookName, null, 0);
        Action s = new Action();
        BookList booklist = s.searchBookByName(book);
        int bookCount = booklist.size();
        if (bookCount > 0) {
            for (int i = 0; i < bookCount; i++) {
                System.out.println("<<" + booklist.get(i).bookName + ">>" + "  "
                        + "作者" + "：" + booklist.get(i).bookAuthor + "  "
                        + "价格" + "：" + booklist.get(i).bookPrice + "  ");
            }
        } else {
            System.out.println("没有找到书名为" + bookName + "的图书");
        }

    }

    // 按作者查询
    public static void searchBookByAuthor() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要查询的图书的作者");
        String bookAuthor = input.nextLine();
        Book book = new Book(null, bookAuthor, 0);
        Action s = new Action();
        BookList booklist = s.searchBookByAuthor(book);
        int bookCount = booklist.size();
        if (bookCount > 0) {
            for (int i = 0; i < bookCount; i++) {
                System.out.println("<<" + booklist.get(i).bookName + ">>" + "  "
                        + "作者" + "：" + booklist.get(i).bookAuthor + "  "
                        + "价格" + "：" + booklist.get(i).bookPrice + "  ");
            }
        } else {
            System.out.println("没有找到作者为" + bookAuthor + "的图书");
        }
    }

    // 按图书价格查询
    public static void searchBookByPrice() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要查询的图书的价格");
        Double bookPrice = input.nextDouble();
        Book book = new Book(null, null, bookPrice);
        Action s = new Action();
        BookList booklist = s.searchBookByPrice(book);
        int bookCount = booklist.size();
        if (bookCount > 0) {
            for (int i = 0; i < bookCount; i++) {
                System.out.println("<<" + booklist.get(i).bookName + ">>" + "  "
                        + "作者" + "：" + booklist.get(i).bookAuthor + "  "
                        + "价格" + "：" + booklist.get(i).bookPrice + "  ");
            }
        } else {
            System.out.println("没有找到价格为" + bookPrice + "的图书");
        }
    }

    // 按关键字查询
    public static void searchBookByPointword() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入关键字");
        String bookName = input.nextLine();
        Book book = new Book(bookName, null, 0);
        Action s = new Action();
        BookList booklist = s.searchBookByPointword(book);
        int bookCount = booklist.size();
        if (bookCount > 0) {
            for (int i = 0; i < bookCount; i++) {
                System.out.println("<<" + booklist.get(i).bookName + ">>" + "  "
                        + "作者" + "：" + booklist.get(i).bookAuthor + "  "
                        + "价格" + "：" + booklist.get(i).bookPrice + "  ");
            }
        } else {
            System.out.println("没有找到与" + bookName + "相关的图书");
        }
    }
}

