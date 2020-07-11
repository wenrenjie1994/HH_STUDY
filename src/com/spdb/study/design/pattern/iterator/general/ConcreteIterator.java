package com.spdb.study.design.pattern.iterator.general;

import java.util.List;

/**
 * 具体迭代器
 * @author Mr.Longyx
 * @date 2020年07月11日 11:17
 */
public class ConcreteIterator<E> implements Iterator<E> {
    private List<E> list;
    private int cursor = 0;

    public ConcreteIterator(List<E> list){
        this.list = list;
    }

    @Override
    public E next() {
        return this.list.get(this.cursor++);
    }

    @Override
    public boolean hashNext() {
        return this.cursor < this.list.size();
    }
}
