package com.spdb.study.design.pattern.delegate.simple;

/**
 * @author Mr.Longyx
 * @date 2020年06月28日 15:48
 */
public class Boss {
    public void task(String task, Leader leader){
        leader.doSomething(task);
    }
}
