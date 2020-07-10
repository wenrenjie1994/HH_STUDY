package com.pan.composite;

public class Department extends OrganizationComponent{

    //没有集合


    public Department(String name, String des) {
        super(name, des);
    }

    //add()和remove()不用写了，因为是叶子节点

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDes() {
        return super.getDes();
    }

    @Override
    protected void print() {
        System.out.println(getName());
    }
}
