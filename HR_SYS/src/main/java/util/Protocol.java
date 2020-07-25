package util;

import bean.Book;
import java.util.List;

public class Protocol {
    public String encoding(List<Book> bookList){
        if(bookList.size() <= 0)
            return "null";
        else{
            return bookList.toString();
        }
    }
}
