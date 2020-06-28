package com.spdb.study.design.pattern.delegate.simple;

/**
 * @author Mr.Longyx
 * @date 2020年06月28日 15:56
 */
public class EmployeeB implements Employee {
    @Override
    public void done(String task) {
        System.out.println("我是员工B，我擅长做架构，开始着手处理："+task);
    }
}
