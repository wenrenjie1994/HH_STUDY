package com.spdb.study.design.pattern.iterator.book;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体操作迭代类
 * @author Mr.Longyx
 * @date 2020年07月11日 13:25
 */
public class BookAggregateImpl implements BookAggregate {
    private List  bookList;

    public BookAggregateImpl() {
        this.bookList =new ArrayList();
    }

    @Override
    public void add(Book book) {
        bookList.add(book);
    }

    @Override
    public void remove(Book book) {
        bookList.remove(book);
    }

    @Override
    public Iterator<Book> iterator() {
        return new IteratorImpl<Book>(bookList);
    }
}
