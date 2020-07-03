package sys;

import bean.Book;

import java.util.ArrayList;
import java.util.Scanner;

public class HRS {
    ArrayList<Book> bookArrayList = new ArrayList<>();
    boolean isExitRequested = false;
    private Scanner input = new Scanner(System.in);

    HRS() {
        while (true) {
            System.out.println("***** 欢迎进入图书管理系统 *****");
            System.out.println("展示图书：0");
            System.out.println("添加图书：1");
            System.out.println("删除图书：2");
            System.out.println("修改图书：3");
            System.out.println("查询图书：4");
            System.out.println("退出请按：5");

            switch (input.nextInt()) {
                case 0:
                    showBook();
                    break;
                case 1:
                    addBook();
                    break;
                case 2:
                    deleteBook();
                    break;
                case 3:
                    updateBook();
                    break;
                case 4:
                    searchBook();
                    break;
                case 5:
                    isExitRequested = true;
                    break;
                default:
                    System.out.println("输入有误，请重新输入");
            }
            if (isExitRequested) break;
        }
        input.close();
        System.out.println("已退出！");

    }

    public static void main(String[] args) {
        new HRS();      //通过构造方法跑程序，构造方法里面只放一个while循环
    }

    /**
     * 查找图书
     */
    private void searchBook() {
        Scanner input = new Scanner(System.in);
        System.out.println("***** 查找图书(请输入书名) *****");
        String bookName = input.nextLine();
        if (bookArrayList.size() == 0) {
            System.out.println("图书系统为空，没有找到该书籍！");
            return;
        }
        for (Book book : bookArrayList) {
            if (book.getBookName().equals(bookName)) {
                System.out.println("已找到图书！");
                System.out.println("书名：<<"+book.getBookName()+">>");
                System.out.println("作者："+book.getBookAuthor());
                System.out.println("价格："+book.getBookPrice());
                return;
            }
        }
        System.out.println("没有找到您想要查找的图书！");
    }

    /**
     * 修改图书
     */
    private void updateBook() {
        Scanner input = new Scanner(System.in);
        System.out.println("***** 修改图书(请输入书名) *****");
        String bookName = input.nextLine();
        if (bookArrayList.size() == 0) {
            System.out.println("图书系统为空，没有找到该书籍！");
            return;
        }
        for (int i = 0; i < bookArrayList.size(); i++) {
            if (bookArrayList.get(i).getBookName().equals(bookName)) {
                System.out.println("找到原图书（请依次输入新的书名、作者、价格）");
                String newBookName = input.nextLine();
                String newBookAuthor = input.nextLine();
                double newBookPrice = input.nextDouble();
                Book book1 = new Book(newBookName, newBookAuthor, newBookPrice);
                bookArrayList.set(i,book1);
                return;
            }
        }
        System.out.println("没有找到您想要修改的图书！");
    }

    /**
     * 删除图书
     */
    private void deleteBook() {
        Scanner input = new Scanner(System.in);
        System.out.println("***** 删除图书(请输入书名) *****");
        String bookName = input.nextLine();
        if (bookArrayList.size() == 0) {
            System.out.println("图书系统为空，没有找到该书籍！");
            return;
        }
        for (Book book : bookArrayList) {
            if (book.getBookName().equals(bookName)) {
                bookArrayList.remove(book);
                System.out.println("已删除！");
                return;
            }
        }
        System.out.println("没有找到您想要删除的图书！");
    }

    /**
     * 添加图书
     */
    private void addBook() {
        Scanner input = new Scanner(System.in);
        System.out.println("***** 添加图书(请依次输入书名、作者、价格) *****");
        String bookName = input.nextLine();
        String bookAuthor = input.nextLine();
        double bookPrice = input.nextDouble();
        Book book = new Book(bookName, bookAuthor, bookPrice);
        bookArrayList.add(book);
        System.out.println("已添加！");
    }

    /**
     * 展示图书
     */
    private void showBook() {
        System.out.println("本图书管理系统共有" + bookArrayList.size() + "本书！");
        for (int i = 0; i < bookArrayList.size(); i++)
            System.out.println("第" + (i + 1) + "本" + "----" + "<<" + bookArrayList.get(i).getBookName() + ">>");
    }
}
