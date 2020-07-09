package com.spdb.study.java8.future;

/**
 * @author Mr.Longyx
 * @date 2020年07月09日 15:17
 */
public interface Future<T>{
    T get();
    boolean isDone();

    void setCompletable(Completable<T> completable);

    Completable<T> getCompletable();
}
