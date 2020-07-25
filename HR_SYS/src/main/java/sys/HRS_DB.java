package sys;

import bean.ChoiceEnum;
import database.DBConnection;
import service.*;
import java.util.Scanner;

public class HRS_DB {
    public static void main(String[] args) {
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
            BookDBServiceImpl bookDBService = new BookDBServiceImpl();
            switch (choiceNEnum) {
                case ADD:
                    bookDBService.addBook();
                    break;
                case REMOVE:
                    bookDBService.deleteBook();
                    break;
                case UPDATE:
                    bookDBService.updateBook();
                    break;
                case QUERY:
                    bookDBService.queryBook();
                    break;
                case EXIT:
                    DBConnection.closeConnection();
                    System.out.println("你已成功推出图书管理系统");
                    input.close();
                    flag = false;
                    break;
            }
        }
    }
}
