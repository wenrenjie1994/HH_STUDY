package sys;

import bean.Book;
import bean.ChoiceEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HRS {
    private List<Book> bookList = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    public HRS() {
        boolean flag = true;
        while(flag){
            System.out.println("-------欢迎进入GLB的图书管理系统-------");
            System.out.println("添加图书请按-----1");
            System.out.println("删除图书请按-----2");
            System.out.println("修改图书请按-----3");
            System.out.println("查询图书请按-----4");
            System.out.println("退出请按--------5");

            int choice = this.input.nextInt();
            this.input.nextLine(); // 取出/r/n，因为nextInt只取出整数，忽略了后面的r/n，直接取的话下次会直接取出空出来
            ChoiceEnum choiceNEnum = ChoiceEnum.getEnumByValue(choice);
            if(choiceNEnum == null){
                System.out.println("输入不合法，请重新输入");
                continue;
            }
            switch (choiceNEnum){
                case ADD:
                    addBook();
                    break;
                case REMOVE:
                    removeBook();
                    break;
                case UPDATE:
                    updateBook();
                    break;
                case QUERY:
                    queryBook();
                    break;
                case EXIT:
                    exit();
                    flag = false;
                    break;
            }
        }
    }

    public void addBook(){
        System.out.println("欢迎进入添加图书界面");
        System.out.println("清依次添加图书名，作者，价格");
        String bookName = input.nextLine();
        String bookAuthor = input.nextLine();
        double bookPrice = input.nextDouble();

        Book book = new Book(bookName, bookAuthor,bookPrice);
        bookList.add(book);
        System.out.println("你已成功添加图书");
        showBook();
    }

    private void showBook(){
        System.out.println("本图书系统共有"+bookList.size()+"本图书");
        for(Book book : bookList)
            System.out.println(book);
    }

    public void exit(){
        System.out.println("你已成功推出图书管理系统");
        this.input.close();
    }

    public void removeBook(){
        System.out.println("欢迎进入删除图书界面");
        System.out.println("请输入需要删除的图书名");
        String bookName = this.input.nextLine();
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

    public void queryBook(){
        System.out.println("欢迎进入查询图书界面");
        System.out.println("清输入需要查询的图书名");
        String bookName = this.input.nextLine();
        for (Book book : bookList){
            if(book.getBookName().equals(bookName)){
                System.out.println(book);
                return;
            }
        }
        System.out.println("没有查询到该书籍，请重新输入");
    }

    public void updateBook(){
        System.out.println("欢迎进图修改图书界面");
        System.out.println("清输入需要修改的图书名");
        String bookName = this.input.nextLine();
        if(bookList.size() <= 0){
            System.out.println("图书管理系统为空，没有找到该书籍");
        }
        for(int i=0;i<bookList.size();i++){
            if(bookList.get(i).getBookName().equals(bookName)){
                System.out.println("请依次输入新的图书名，作者，价格");
                String newBookName = this.input.nextLine();
                String newBookAuthor = this.input.nextLine();
                double newBookPrice = this.input.nextDouble();
                Book newBook = new Book(newBookName, newBookAuthor,  newBookPrice);
                bookList.set(i, newBook);
                System.out.println("你已修改成功");
                return;
            }
        }
        System.out.println("没有找到该书籍");
    }
}
