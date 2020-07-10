package com.pan.prototype.improve;

public class Client {
    public static void main(String[] args) {
        System.out.println("使用原型模式完成对象的创建");

        Sheep sheep = new Sheep("Tom", 1, "白色");
        Sheep sheep2 = (Sheep) sheep.clone();
        Sheep sheep3 = (Sheep) sheep.clone();
        Sheep sheep4 = (Sheep) sheep.clone();

        System.out.println(sheep);
        System.out.println(sheep2);
        System.out.println(sheep3);
    }
}
