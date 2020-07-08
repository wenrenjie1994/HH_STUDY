package sys;

import bean.Book;
import bean.ChoiceEnum;
import service.BookService;
import service.BookServiceImpl;
import service.DataService;
import service.DataServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HRS {
    private static final String DATA_NAME = "books.txt";
    public static void main(String[] args) {
        BookService bookService = new BookServiceImpl();
        DataService dataService = new DataServiceImpl();
        List<Book> bookList;
        bookList = dataService.loadData(DATA_NAME);
        boolean flag = true;
        while (flag) {
            System.out.println("-------欢迎进入GLB的图书管理系统-------");
            System.out.println("添加图书请按-----1");
            System.out.println("删除图书请按-----2");
            System.out.println("修改图书请按-----3");
            System.out.println("查询图书请按-----4");
            System.out.println("退出请按--------5");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            input.nextLine(); // 取出/r/n，因为nextInt只取出整数，忽略了后面的r/n，直接取的话下次会直接取出空出来
            ChoiceEnum choiceNEnum = ChoiceEnum.getEnumByValue(choice);
            if (choiceNEnum == null) {
                System.out.println("输入不合法，请重新输入");
                continue;
            }
            switch (choiceNEnum) {
                case ADD:
                    bookService.addBook(bookList);
                    break;
                case REMOVE:
                    bookService.removeBook(bookList);
                    break;
                case UPDATE:
                    bookService.updateBook(bookList);
                    break;
                case QUERY:
                    bookService.queryBook(bookList);
                    break;
                case EXIT:
                    dataService.saveData(bookList, DATA_NAME);
                    System.out.println("你已成功推出图书管理系统");
                    input.close();
                    flag = false;
                    break;
            }
        }
    }
}
