package com.testHR;

/**
 * @description:
 * @author: zeng
 * @modified By:
 */
public class Test {
    public static void main(String[] args) {
        Resource resource = new Resource("包子", 50);
        Thread pro1 = new Thread(new ProImpl(resource));
        Thread buy1 = new Thread(new BuyImpl(resource));
        Thread buy2 = new Thread(new BuyImpl(resource));
        pro1.setName("包子铺");
        buy1.setName("大狗");
        buy2.setName("二狗");
        pro1.start();
        buy1.start();
        buy2.start();
    }
}
