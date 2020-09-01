package com.cuit.employee;

import com.cuit.visitor.IVisitor;

/**
 * @author liwenyi
 * @date 2020/7/22
 * desc
 */
public class CommonEmployee extends Employee {
    private String job;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }


    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
