package com.spdb.study.java8.future;

/**
 * 一旦你有值，就调用此方法通知到我
 * @author Mr.Longyx
 * @date 2020/7/9 14:42
 */
public interface Completable<T>{
    void complete(T t);
    void exception(Throwable cause);
}