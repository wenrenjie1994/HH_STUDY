package com.pan.principle.singleresposibility;

/**
 * @author zhaopan@163.com
 * @creat 2020-05-14 19:54
 */
public class SingleResponsibility1 {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();

        vehicle.run("摩托车");
        vehicle.run("汽车");
        vehicle.run("飞机");
    }
}

//交通工具类

class Vehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在公路上运行。。。");
    }
}