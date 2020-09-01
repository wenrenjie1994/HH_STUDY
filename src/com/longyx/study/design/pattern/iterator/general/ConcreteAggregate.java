package com.spdb.study.design.pattern.iterator.general;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体容器
 * @author Mr.Longyx
 * @date 2020年07月11日 11:21
 */
public class ConcreteAggregate<E> implements Aggregate<E> {
    private List<E> list = new ArrayList<>();

    @Override
    public boolean add(E element) {
        return this.list.add(element);
    }

    @Override
    public boolean remove(E element) {
        return this.list.remove(element);
    }

    @Override
    public Iterator<E> iterator() {
        return new ConcreteIterator<>(this.list);
    }
}
