package com.spdb.study.design.pattern.delegate.simple;

/**
 * @author Mr.Longyx
 * @date 2020年06月28日 15:53
 */
public class EmployeeA implements Employee {
    @Override
    public void done(String task) {
        System.out.println("我是员工A，我擅长通讯，开始着手处理："+task);
    }
}
