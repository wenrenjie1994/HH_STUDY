package com.spdb.study.design.pattern.visitor.kpi;

import com.sun.xml.internal.ws.api.pipe.Engine;

import java.util.LinkedList;
import java.util.List;

/**
 * 业务报表
 * @author Mr.Longyx
 * @date 2020年07月12日 22:25
 */
public class BusinessReport {
    private List<Employee> employees = new LinkedList<>();

    public BusinessReport(){
        employees.add(new Manager("产品经理A"));
        employees.add(new Engineer("开发工程师A"));
        employees.add(new Engineer("开发工程师B"));
        employees.add(new Engineer("开发工程师C"));

        employees.add(new Manager("产品经理B"));
        employees.add(new Engineer("开发工程师D"));
    }

    /**
     * 展示员工的业务报表
     * @author Mr.Longyx
     * @date 2020/7/12 22:30
     * @param visitor
     */
    public void showReport(Visitor visitor){
        for (Employee employee : employees){
            employee.accecpt(visitor);
        }
    }
}
