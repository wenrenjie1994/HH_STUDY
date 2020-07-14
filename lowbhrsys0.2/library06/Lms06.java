/**
 * A program for JAVA作业---图书管理系统
 *
 * @version 2.0 2016-03-23
 * @author 文仁杰 2014214225
 */
package library06;

import bean.Book;
import bean.BookList;
import service.BookService;
import utils.InputException;
import work.Action;

import java.util.Scanner;

/**
 * 主界面展示类
 * @author Administrator
 */
public class Lms06 {

    public Lms06() {
        Scanner input = new Scanner(System.in);
//        // 主页面提示
//        while (true) {
//            //.openData();
//            System.out.println("************欢迎来到图书管理系统************");
//            System.out.println("增加图书请按----------1");
//            System.out.println("删除图书请按----------2");
//            System.out.println("修改图书请按----------3");
//            System.out.println("查询图书请按----------4");
//            System.out.println("退出请按--------------5");
//            // if语句指令判断
//            int choice = input.nextInt();
//            if (choice == 1) {
//                addBook();
//            } else if (choice == 2) {
//                deleteBook();
//            } else if (choice == 3) {
//
//            } else if (choice == 4) {
//                searchBook();
//            } else if (choice == 5) {
//                break;
//            } else {
//                System.out.println("输入错误，请确认后从新输入");
//            }
//        }
//        System.out.println("您已退出图书管理系统");
//    }
        // 主界面展示部分改动同lowbhrsys0.1
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
            String choice = input.nextLine();
            try {
                if (choice.equals("1")) {
                    BookService.addBook();
                } else if (choice.equals("2")) {
                    BookService.deleteBook();
                } else if (choice.equals("3")) {

                } else if (choice.equals("4")) {
                    BookService.searchBook();
                } else if (choice.equals("5")) {
                    break;
                }
                // 加入了异常处理后，该处抛出一个InputException
                else {
                    throw new InputException("请输入1-5");
                }
                System.out.println("您已退出图书管理系统！\n");
            } catch (InputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Lms06();
    }



}