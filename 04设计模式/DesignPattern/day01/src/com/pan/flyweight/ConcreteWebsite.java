package com.pan.flyweight;

public class ConcreteWebsite extends Website{

    //共享的部分，属于内部状态
    private String type = "";//网站发布的类型

    //构造器
    public ConcreteWebsite(String type) {
        this.type = type;
    }


    @Override
    public void use(User user) {
        System.out.println("网站的发布形式为："+ type +  "，在使用中....使用者为：" + user.getName());
    }
}
