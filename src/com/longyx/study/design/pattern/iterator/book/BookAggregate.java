package com.spdb.study.design.pattern.iterator.book;

import com.spdb.study.design.pattern.bridge.course.Course;

/**
 * @author Mr.Longyx
 * @date 2020年07月11日 13:18
 */
public interface BookAggregate {
    void add(Book book);

    void remove(Book book);

    Iterator<Book> iterator();
}
