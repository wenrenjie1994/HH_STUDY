package com.spdb.study.design.pattern.iterator.book;

/**
 * @author Mr.Longyx
 * @date 2020年07月11日 13:17
 */
public interface Iterator<E> {
    E next();
    boolean hashNext();

}
