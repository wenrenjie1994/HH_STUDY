package database;

import bean.Book;
import bean.BookList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

public class action {
    public static BookList serchFromBookName(String BookName) {
        BookList bl = new BookList();
        Connection c = JDBC_con.getCon();
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("select * from book where BookName='" + BookName + "'");
            if (!rs.next()) {
                System.out.println("not found book,please try it again");
                return null;
            } else {
                bl.add(new Book(rs.getString(1), rs.getString(2), rs.getDouble(3)));
            }
            while (rs.next()) {
                bl.add(new Book(rs.getString(1), rs.getString(2), rs.getDouble(3)));
            }
            Iterator<Book> it = bl.iterator();
            while (it.hasNext()) {
                System.out.println(it.next().toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bl;
    }

    public static BookList serchFromBookWriter(String BookWriter) {
        BookList bl = new BookList();
        Connection c = JDBC_con.getCon();
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("select * from book where BookWriter='" + BookWriter + "'");
            if (!rs.next()) {
                System.out.println("not found book,please try it again");
                return null;
            } else {
                bl.add(new Book(rs.getString(1), rs.getString(2), rs.getDouble(3)));
            }
            while (rs.next()) {
                bl.add(new Book(rs.getString(1), rs.getString(2), rs.getDouble(3)));
            }
            Iterator<Book> it = bl.iterator();
            while (it.hasNext()) {
                System.out.println(it.next().toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bl;
    }

    public static BookList serchFromBookPrice(double BookPrice) {
        BookList bl = new BookList();
        Connection c = JDBC_con.getCon();
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("select * from book where BookPrice=" + BookPrice);
            if (!rs.next()) {
                System.out.println("not found book,please try it again");
                return null;
            } else {
                bl.add(new Book(rs.getString(1), rs.getString(2), rs.getDouble(3)));
            }
            while (rs.next()) {
                bl.add(new Book(rs.getString(1), rs.getString(2), rs.getDouble(3)));
            }
            Iterator<Book> it = bl.iterator();
            while (it.hasNext()) {
                System.out.println(it.next().toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bl;
    }

    public static BookList showBookAll() {
        BookList bl = new BookList();
        Connection c = JDBC_con.getCon();
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("select * from book");
            if (!rs.next()) {
                System.out.println("not found book,please try it again");
                return null;
            } else {
                bl.add(new Book(rs.getString(1), rs.getString(2), rs.getDouble(3)));
            }
            while (rs.next()) {
                bl.add(new Book(rs.getString(1), rs.getString(2), rs.getDouble(3)));
            }
            Iterator<Book> it = bl.iterator();
            while (it.hasNext()) {
                System.out.println(it.next().toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bl;
    }

    public static boolean addBook(Book book) {
        Connection c = JDBC_con.getCon();
        try {
            Statement s = c.createStatement();
            int addresult = s.executeUpdate("insert into book VALUES ('" + book.getBookName() + "','" + book.getBookWriter() + "'," + book.getBookPrice() + ")");
            if (addresult == 0) {
                System.out.println("add book fail,please try it again");
                return false;
            } else {
                System.out.println("add book sucess");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean updateBook(String oldBookName, String newBookName, String newBookWriter, double newBookPrice) {
        Connection c = JDBC_con.getCon();
        try {
            Statement s = c.createStatement();
            int updatresult = s.executeUpdate("update book SET bookName='" + newBookName + "', bookWriter='" + newBookWriter +
                    "', bookPrice='" + newBookPrice + "' where bookName='" + oldBookName + "'");
            if(updatresult==0){
                System.out.println("update book fail");
                return false;
            }else{
                System.out.println("update book sucess");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }


    /*
    type==1  按bookName删除
    type==2  按bookWriter删除
     */
    public static boolean deleteBook(int type, String bookDetail) {
        Connection c = JDBC_con.getCon();
        int deleteresult = 0;
        try {
            Statement s = c.createStatement();
            if (type == 1) {
                deleteresult = s.executeUpdate("delete from book where bookName='" + bookDetail + "'");
            }
            if (type == 2) {
                deleteresult = s.executeUpdate("delete from book where bookWriter='" + bookDetail + "'");
            }
            if (deleteresult == 0) {
                System.out.println("delete book fail,please try it again");
                return false;
            } else {
                System.out.println("delete book sucess");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
