package service;

import bean.Book;
import database.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookDBServiceImpl{
    /**
     * 向数据库中添加单本书操作
     */
    public void addBook(){
        System.out.println("欢迎进入添加图书界面");
        System.out.println("清依次添加图书名，作者，价格");
        Scanner input = new Scanner(System.in);
        String bookName = input.nextLine();
        String bookAuthor = input.nextLine();
        double bookPrice = input.nextDouble();
        Book book = new Book(bookName, bookAuthor,bookPrice);

        Connection connection = DBConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "insert into books values ('"+book.getBookName()+"','"+book.getBookAuthor()+"','"
                    +book.getBookPrice()+"')";
            statement.execute(sql);
            if(statement != null)
                statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 修改数据库中书的信息
     */
    public void updateBook(){
        System.out.println("欢迎进图修改图书界面");
        System.out.println("清输入需要修改的图书名");
        Scanner input = new Scanner(System.in);
        String oldBookName = input.nextLine();
        System.out.println("请依次输入新的图书名，作者，价格");
        String newBookName = input.nextLine();
        String newBookAuthor = input.nextLine();
        double newBookPrice = input.nextDouble();
        Book newBook = new Book(newBookName, newBookAuthor,  newBookPrice);
        Connection connection = DBConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "UPDATE books SET book_name='"+newBook.getBookName()+"',book_author='"+newBook.getBookAuthor()
                    +"',book_price='"+newBook.getBookPrice()+"'WHERE book_name='"+oldBookName+"'";
            statement.execute(sql);
            if(statement != null)
                statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 删除数据库中的某本书信息
     */
    public void deleteBook(){
        System.out.println("欢迎进入删除图书界面");
        System.out.println("请输入需要删除的图书名");
        Scanner input = new Scanner(System.in);
        String bookName = input.nextLine();
        Connection connection = DBConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM books WHERE book_name='"+bookName+"'";
            statement.execute(sql);
            if(statement != null)
                statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 从数据库中查询一本书的详情
     */
    public void queryBook(){
        System.out.println("欢迎进入查询图书界面");
        System.out.println("清输入需要查询的图书名");
        Scanner input = new Scanner(System.in);
        String bookName = input.nextLine();
        Connection connection = DBConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT book_name,book_author,book_price FROM books WHERE book_name='"+bookName+"'";
            ResultSet rs =  statement.executeQuery(sql);
            while (rs.next()){
                Book book = new Book(rs.getString(1), rs.getString(2), rs.getFloat(3));
                System.out.println(book);
            }
            if(statement != null)
                statement.close();
            if(rs != null)
                rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 显示数据库中已有的书籍
     */
    public void showBooks(){
        Connection connection = DBConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            String countSql = "SELECT COUNT(*) FROM books";
            ResultSet countRS =  statement.executeQuery(countSql);
            while(countRS.next()){
                System.out.println("本图书系统共有"+countRS.getInt(1)+"本图书");
            }
            String sql = "SELECT book_name,book_author,book_price FROM books";
            ResultSet rs =  statement.executeQuery(sql);
            while (rs.next()){
                Book book = new Book(rs.getString(1), rs.getString(2), rs.getFloat(3));
                System.out.println(book);
            }
            if(statement != null)
                statement.close();
            if(rs != null)
                rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 向数据库中添加单本书操作
     * @param book
     */
    public void addBook(Book book){
        Connection connection = DBConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "insert into books values ('"+book.getBookName()+"','"+book.getBookAuthor()+"','"
                    +book.getBookPrice()+"')";
            statement.execute(sql);
            if(statement != null)
                statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 修改数据库中书的信息
     * @param oldBookName
     * @param newBook
     */
    public void updateBook(String oldBookName, Book newBook){
        Connection connection = DBConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "UPDATE books SET book_name='"+newBook.getBookName()+"',book_author='"+newBook.getBookAuthor()
                    +"',book_price='"+newBook.getBookPrice()+"'WHERE book_name='"+oldBookName+"'";
            statement.execute(sql);
            if(statement != null)
                statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 删除数据库中的某本书信息
     * @param bookName
     */
    public void deleteBook(String bookName){
        Connection connection = DBConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM books WHERE book_name='"+bookName+"'";
            statement.execute(sql);
            if(statement != null)
                statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 从数据库中查询一本书的详情
     * @param bookName
     */
    public Book queryBook(String bookName){
        Connection connection = DBConnection.getConnection();
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT book_name,book_author,book_price FROM books WHERE book_name='"+bookName+"'";
            rs =  statement.executeQuery(sql);
            while (rs.next()){
                Book book = new Book(rs.getString(1), rs.getString(2), rs.getFloat(3));
                return book;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                if(statement != null)
                    statement.close();
                if(rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 显示数据库中已有的书籍
     */
    public List<Book> displayBooks(){
        Connection connection = DBConnection.getConnection();
        ArrayList<Book> bookList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT book_name,book_author,book_price FROM books";
            ResultSet rs =  statement.executeQuery(sql);
            while (rs.next()){
                Book book = new Book(rs.getString(1), rs.getString(2), rs.getFloat(3));
                bookList.add(book);
            }
            if(statement != null)
                statement.close();
            if(rs != null)
                rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bookList;
    }
}
