package com.pan.flyweight;

public class Client {
    public static void main(String[] args) {
        //创建一个工厂类
        WebsiteFactory websiteFactory = new WebsiteFactory();

        //客户要一个以新闻形式发布的网站
        Website website1 = websiteFactory.getWebsiteCategory("新闻");
        website1.use(new User("Tom"));

        //客户要一个以博客形式发布的网站
        Website website2 = websiteFactory.getWebsiteCategory("博客");
        website2.use(new User("Jack"));

        //客户要一个以博客形式发布的网站
        Website website3 = websiteFactory.getWebsiteCategory("博客");
        website3.use(new User("Smith"));
        //客户要一个以博客形式发布的网站
        Website website4 = websiteFactory.getWebsiteCategory("博客");
        website4.use(new User("Penny"));


        System.out.println("网站的分类共" + websiteFactory.getWebsiteCount());

    }
}
