package com.spdb.employee;

import com.spdb.visitor.IVisitor;

/**
 * @author liwenyi
 * @date 2020/7/22
 * desc
 */
public class Manager extends Employee {
    private String performance;

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
