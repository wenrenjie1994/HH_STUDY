package com.pan.composite;

import java.util.ArrayList;
import java.util.List;

//University就是Composite，可以管理College
public class University extends OrganizationComponent{
    //聚合
    List<OrganizationComponent> organizationComponents = new ArrayList<>();

    //构造器
    public University(String name, String des) {
        super(name, des);
    }

    //重写add()
    @Override
    protected void add(OrganizationComponent organizationComponent) {
        organizationComponents.add(organizationComponent);
    }

    //重写remove()
    @Override
    protected void remove(OrganizationComponent organizationComponent) {
        organizationComponents.remove(organizationComponent);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDes() {
        return super.getDes();
    }

    //print()：输出university包含的学院
    @Override
    protected void print() {
        System.out.println("--------" + getName() + "----------");
        //遍历organizationComponents
        for(OrganizationComponent organizationComponent:organizationComponents){
            organizationComponent.print();
        }
    }
}
