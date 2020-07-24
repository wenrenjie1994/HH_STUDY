/*
* 程序运行
* */

package Run_main;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;
import BookService.BookService;
import DataService.DataOperate;
import Model.Book;
public class LS_Main {
    public static void main(String[] args){
        File f = new File("E:/Library_System/LibSystem_1/booklist");

        Scanner Input_id = new Scanner(System.in);

        LinkedList<Book> booklist = new LinkedList<Book>();//双向链表
        DataOperate.LoadData(booklist);
        System.out.println("************欢迎来到图书管理系统！*************");
        outloop:
        while(true){

            System.out.println("增加图书请按——————————————1");
            System.out.println("删除图书请按——————————————2");
            System.out.println("修改图书请按——————————————3");
            System.out.println("查询图书请按——————————————4");
            System.out.println("退出图书管理系统请按——————————5");

            int choice = Input_id.nextInt();
            switch(choice){
                case 1:
                    BookService.addbook(booklist);//增加图书
                    break;
                case 2:
                    BookService.deletebook(booklist);//删除图书
                    break;
                case 3:
                    BookService.updatebook(booklist);//更改图书信息
                    break;
                case 4:
                    BookService.searchbook(booklist);//查询图书信息
                    break;
                case 5:
                    DataOperate.SaveData(booklist);//存储操作结果并退出
                    break outloop;
                    default:
                        System.out.println("输入错误，请确认后重新输入！");
            }
        }
        System.out.println("您已退出图书管理系统！");
    }

}
