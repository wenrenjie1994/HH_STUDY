package service;

import bean.Book;

import java.io.IOException;
import java.util.List;

public interface DataService {
    List<Book> loadData(String fileName);
    void saveData(List<Book> bookList, String fileName);
}
