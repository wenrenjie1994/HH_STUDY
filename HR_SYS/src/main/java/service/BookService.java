package service;

import bean.Book;

import java.util.List;

public interface BookService {
    void addBook(List<Book> bookList);
    void showBook(List<Book> bookList);
    void removeBook(List<Book> bookList);
    void queryBook(List<Book> bookList);
    void updateBook(List<Book> bookList);
}
