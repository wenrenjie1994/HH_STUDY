package com.pan.composite;

import java.util.ArrayList;
import java.util.List;

public class College extends OrganizationComponent{
    //聚合，List中存放的是department
    List<OrganizationComponent> organizationComponents = new ArrayList<>();

    //构造器
    public College(String name, String des) {
        super(name, des);
    }

    //重写add()
    @Override
    protected void add(OrganizationComponent organizationComponent) {
        //实际业务中，College的add和University的add方法不一定完全相同
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
