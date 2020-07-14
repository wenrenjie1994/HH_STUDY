package work;

import bean.Book;
import bean.BookList;
import database.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库交互类
 *
 * @author Administrator
 */
public class Action {

    // 添加图书方法
    public int addbook(Book book) {
        // 该数据库操作影响的行数：line > 0 代表该操作成功
        int line = 0;
        try {
            Connection conn = DBConnection.getConnection();
            Statement statement = conn.createStatement();
            // 在数据库中的字段名建议全为小写
            String stringSql = "insert into bookmis values('" + book.bookName + "','" + book.bookAuthor + "','" + book.bookPrice + "')";
            line = statement.executeUpdate(stringSql);
            DBConnection.closeConnection(null, statement, conn);
        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.toString());
        }
        return line;
    }

    // 删除图书方法
    public int deleteBookByName(Book book) {
        int line = 0;
        try {
            Connection conn = DBConnection.getConnection();
            Statement statement = conn.createStatement();
            String stringSql = "delete from bookmis where bookName = '" + book.bookName + "'";
            line = statement.executeUpdate(stringSql);
            DBConnection.closeConnection(null, statement, conn);
        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.toString());
        }
        return line;
    }

    //按作者名删除
    public int deleteBookByAuthor(Book book) {
        int line = 0;
        try {
            // System.out.println("1");
            Connection conn = DBConnection.getConnection();
            // System.out.println("2");
            Statement statement = conn.createStatement();
            // System.out.println("3");
            String stringSql = "delete from bookmis where bookAuthor = '" + book.bookAuthor + "'";
            // System.out.println("4");
            // line = statement.executeUpdate(stringSql);
            System.out.println("5");
            DBConnection.closeConnection(null, statement, conn);
        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.toString());
        }
        // System.out.println("6");
        return line;
    }

    // 修改图书方法
    public int changeBook(Book book, Book oldbook) {
        int line = 0;
        try {
            Connection conn = DBConnection.getConnection();
            Statement statement = conn.createStatement();
            String stringSql = "UPDATE bookmis SET bookName = '" + book.bookName + "', bookAuthor='" + book.bookAuthor + "',bookPrice='" + book.bookPrice + "' WHERE  bookName= '" + oldbook.bookName + "'";
            line = statement.executeUpdate(stringSql);
            DBConnection.closeConnection(null, statement, conn);
        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.toString());
        }
        return line;
    }

    // 查询图书方法
    public BookList searchBookByName(Book book) {
        BookList bookList = new BookList();
        try {
            Connection conn = DBConnection.getConnection();
            Statement statement = conn.createStatement();
            String sql = "select * from bookmis where bookName='" + book.bookName + "'";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Book abook = new Book(rs.getString("bookname"), rs.getString(2), rs.getDouble(3));
                bookList.add(abook);
            }
            DBConnection.closeConnection(rs, statement, conn);
        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.toString());
        }
        return bookList;

    }

    // 按作者查询图书
    public BookList searchBookByAuthor(Book book) {
        BookList bookList = new BookList();
        try {
            Connection conn = DBConnection.getConnection();
            Statement statement = conn.createStatement();
            String sql = "select * from bookmis where bookAuthor='" + book.bookAuthor + "'";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Book abook = new Book(rs.getString(1), rs.getString(2), rs.getDouble(3));
                bookList.add(abook);
            }
            DBConnection.closeConnection(rs, statement, conn);
        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.toString());
        }
        return bookList;
    }

    // 按价格查询图书
    public BookList searchBookByPrice(Book book) {
        BookList bookList = new BookList();
        try {
            Connection conn = DBConnection.getConnection();
            Statement statement = conn.createStatement();
            String sql = "select * from bookmis where bookPrice='" + book.bookPrice + "'";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Book abook = new Book(rs.getString(1), rs.getString(2), rs.getDouble(3));
                bookList.add(abook);
            }
            DBConnection.closeConnection(rs, statement, conn);
            return bookList;
        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.toString());
        }
        return null;
    }

    // 按关键字查询
    public BookList searchBookByPointword(Book book) {
        BookList bookList = new BookList();
        try {
            Connection conn = DBConnection.getConnection();
            Statement statement = conn.createStatement();
            String sql = "select * from bookmis where bookName like '%" + book.bookName + "%'";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Book abook = new Book(rs.getString(1), rs.getString(2), rs.getDouble(3));
                bookList.add(abook);
            }
            DBConnection.closeConnection(rs, statement, conn);
            return bookList;
        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.toString());
        }
        return bookList;
    }
}
