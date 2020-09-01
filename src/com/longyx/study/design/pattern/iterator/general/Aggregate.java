package com.spdb.study.design.pattern.iterator.general;

/**
 * 抽象容器
 * @author Mr.Longyx
 * @date 2020年07月11日 11:14
 */
public interface Aggregate<E> {
    boolean add(E element);
    boolean remove(E element);
    Iterator<E> iterator();
}
