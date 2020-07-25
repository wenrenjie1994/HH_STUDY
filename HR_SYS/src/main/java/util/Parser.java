package util;

import bean.Book;
import service.BookDBServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    private static final String PROTOCOL_SEPARATOR = "/";
    private static final String DATA_SEPARATOR = ",";
    private BookDBServiceImpl DBService;

    public Parser(BookDBServiceImpl DBService) {
        this.DBService = DBService;
    }

    public List<Book> parse(String str){
        List<Book> bookList = new ArrayList<>();
        if(str != null) {
            String[] strs = str.split(PROTOCOL_SEPARATOR);
            String head = strs[0];
            String data = strs[1];
            if (head.startsWith("add")) {
                String[] bookInfo = data.split(DATA_SEPARATOR);
                Book book = new Book(bookInfo[0], bookInfo[1], Float.parseFloat(bookInfo[2]));
                DBService.addBook(book);
            } else if (head.startsWith("update")) {
                String[] info = data.split(DATA_SEPARATOR);
                String oldBookName = info[0];
                Book newBook = new Book(info[1], info[2], Float.parseFloat(info[3]));
                DBService.updateBook(oldBookName, newBook);
            } else if (head.startsWith("delete")) {
                String[] info = data.split(DATA_SEPARATOR);
                String bookName = info[0];
                DBService.deleteBook(bookName);
            } else if (head.startsWith("query")) {
                String[] info = data.split(DATA_SEPARATOR);
                String bookName = info[0];
                Book queryBook = DBService.queryBook(bookName);
                bookList.add(queryBook);
            } else if (head.startsWith("display")) {
                bookList = DBService.displayBooks();
            }
        }
        return bookList;
    }
}
