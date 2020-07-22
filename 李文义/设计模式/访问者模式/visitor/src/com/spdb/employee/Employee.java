package com.spdb.employee;

import com.spdb.visitor.IVisitor;

/**
 * @author liwenyi
 * @date 2020/7/22
 * desc
 */
public abstract class Employee {
    /**
     * 功能描述:
     * 0代表是男性,1代表是女性
     *
     * @author: liwenyi
     */
    public final static int MALE = 0;
    public final static int FEMALE = 1;
    private String name;
    private int salary;
    private int sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    /**
     * 功能描述:
     * 允许一个访问者访问
     *
     * @param visitor 1
     * @return: void
     * @author: liwenyi
     */
    public abstract void accept(IVisitor visitor);
}
