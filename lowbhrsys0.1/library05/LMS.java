/**
 * A program for JAVA第一节课作业---图书管理系统
 *
 * @version 1.2 2016-03-11
 * @author 文仁杰 2014214225
 */
package library05;

import loadandsaveData.DataOperate;
import model.Book;
import service.BookService;
import utils.InputException;

import java.util.LinkedList;
import java.util.Scanner;

public class LMS {
    public static void main(String[] args) {

        LinkedList<Book> bookList = new LinkedList<Book>();
        Scanner input = new Scanner(System.in);
        // 下载所有图书
        DataOperate.loadData(bookList);
        while (true) {
            System.out.println("***************图书管理系统************");
            System.out.println("               1 增加图书");
            System.out.println("               2 删除图书");
            System.out.println("               3 修改图书");
            System.out.println("               4 查询图书");
            System.out.println("               5 退出\n");
            // if语句指令判断
            // 隐患：该处的choice只能允许int类型的选项输入，输入其他字符时会报错，未对该异常进行处理
            // 优化：将choice更改为String，并对choice的输入进行异常处理
//			int choice = input.nextInt();
            String choice = input.nextLine();
            try {
                if (choice.equals("1")) {
                    BookService.addBook(bookList);
                } else if (choice.equals("2")) {
                    BookService.deleteBook(bookList);
                } else if (choice.equals("3")) {
                    BookService.updateBook(bookList);
                } else if (choice.equals("4")) {
                    BookService.showBook(bookList);
                } else if (choice.equals("5")) {
                    DataOperate.saveData(bookList);
                    break;
                }
                // 加入了异常处理后，该处抛出一个InputException
                else {
//					System.out.println("输入错误，请确认后从新输入");
                    throw new InputException("请输入1-5");
                }
            } catch (InputException e) {
                System.out.println(e.getMessage());
            }
            ;


        }

    }
}