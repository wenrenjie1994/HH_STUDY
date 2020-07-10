package com.pan.flyweight;

import java.util.HashMap;

//网站工厂类，根据需要返回一个网站
public class WebsiteFactory {

    //集合，充当池的作用
    private HashMap<String, ConcreteWebsite> pool = new HashMap<>();

    //根据网站的类型返回一个网站，如果没有就创建一个网站，并放入池中，并返回
    public Website getWebsiteCategory(String type) {
        if (!pool.containsKey(type)) {
            //如果没有就创建一个网站，并放入池中
            pool.put(type, new ConcreteWebsite(type));
        }
        return (Website) pool.get(type);
    }

    //获取池中到底有多少个网站类型
    public int getWebsiteCount(){
        return pool.size();
    }

}
