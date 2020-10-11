package com.longyx.study.design.pattern.iterator.book;

import java.util.List;

/**
 * @author Mr.Longyx
 * @date 2020年07月11日 13:20
 */
public class IteratorImpl<E> implements Iterator<E> {
    private List<E> list;

    /**
     * 记录读取的位置
     * @author Mr.Longyx
     * @date 2020/7/11 13:21
     */
    private int cursor;

    public IteratorImpl(List<E> list) {
        this.list = list;
    }

    @Override
    public E next() {
        System.out.println("当前位置："+cursor+" : ");
        return list.get(cursor++);
    }

    @Override
    public boolean hashNext() {
        return cursor != list.size();
    }
}
