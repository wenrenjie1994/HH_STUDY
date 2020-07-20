package control;

import bean.Book;
import database.action;

import java.util.Scanner;

public class Control {
//    public static void main(String[] args) {
//        Control.start();
//    }

    public static void start() {
        while (true) {
            System.out.println("Welcom to my lib");
            System.out.println("press 1 to search book");
            System.out.println("press 2 to add book");
            System.out.println("press 3 to update book");
            System.out.println("press 4 to delete book");
            System.out.println("press 5 to show ALL book");
            System.out.println("press 0 to exit");
            System.out.println("------------------------------");
            Scanner input = new Scanner(System.in);
            int chose = input.nextInt();
            if (chose == 0) {
                break;
            }
            else if (chose == 5) {
                action.showBookAll();
            }
            else if (chose == 1) {
                while (true) {
                    System.out.println("press 1 to search book by bookName");
                    System.out.println("press 2 to search book by bookWriter");
                    System.out.println("press 3 to search book by bookPrice");
                    System.out.println("press 4 to search book by keyWord");
                    System.out.println("press 5 to show ALL book");
                    System.out.println("press 0 to return last step");
                    System.out.println("------------------------------");
                    int chose1 = input.nextInt();
                    if (chose1 == 0) {
                        break;
                    }
                    else if (chose1 == 5) {
                        action.showBookAll();
                    }
                    else if (chose1 == 1) {
                        System.out.println("input bookName");
                        Scanner in = new Scanner(System.in);
                        String bookName = in.nextLine();
                        action.serchFromBookName(bookName);
                        System.out.println("------------------------------");
                    }
                    else if (chose1 == 2) {
                        System.out.println("input bookWriter");
                        Scanner in = new Scanner(System.in);
                        String bookWriter = in.nextLine();
                        action.serchFromBookWriter(bookWriter);
                        System.out.println("------------------------------");
                    }
                    else if (chose1 == 3) {
                        System.out.println("input bookPrice");
                        Scanner in = new Scanner(System.in);
                        double bookPrice = in.nextDouble();
                        action.serchFromBookPrice(bookPrice);
                        System.out.println("------------------------------");
                    }
                    else if (chose1 == 4) {
                        System.out.println("input keyWord");
                        Scanner in = new Scanner(System.in);
                        String keyWord = in.nextLine();
                        System.out.println("----------to do list");
                        System.out.println("------------------------------");
                    }else{
                        System.out.println("input err,please try it again");
                    }
                }
            }
            else if (chose == 2) {
                System.out.println("input bookName bookWriter and bookPrice(使用“/”隔开)");
                Scanner in=new Scanner(System.in);
                String inAll=in.nextLine();
                String[] book=inAll.split("/");
                Book addbook=new Book(book[0],book[1],Double.parseDouble(book[2]));
                action.addBook(addbook);
            }
            else if (chose==3){
                System.out.println("input oldBookName newBookName newbookWriter and newbookPrice(使用“/”隔开)");
                Scanner in=new Scanner(System.in);
                String inAll=in.nextLine();
                String[] book=inAll.split("/");
                action.updateBook(book[0],book[1],book[2],Double.parseDouble(book[3]));
            }
            else if(chose==4){
                System.out.println("input 1 to delete by bookName");
                System.out.println("input 2 to delete by bookWriter");
                int chose4=input.nextInt();
                if (chose4==1){
                    System.out.println("input bookName");
                    Scanner in=new Scanner(System.in);
                    action.deleteBook(1,in.nextLine());
                }else if(chose4==2){
                    System.out.println("input bookWriter");
                    Scanner in=new Scanner(System.in);
                    action.deleteBook(2,in.nextLine());
                }else {
                    System.out.println("input err,please try 1 or 2");
                }
            }else{
                System.out.println("input err,please try it again");
            }
        }
    }
}
