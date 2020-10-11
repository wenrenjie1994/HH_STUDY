package com.longyx.study.java8.lambda;

/**
 * @author Mr.Longyx
 * @date 2020年07月07日 12:35
 */
@FunctionalInterface
public interface DefinedFunction<T,U,K,R> {
    R apply(T t,U u,K k);
}
