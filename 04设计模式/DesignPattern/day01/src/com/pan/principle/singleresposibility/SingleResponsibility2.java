package com.pan.principle.singleresposibility;

/**
 * @author zhaopan@163.com
 * @creat 2020-05-14 20:02
 */
public class SingleResponsibility2 {
    public static void main(String[] args) {

        RoadVehicle roadVehicle = new RoadVehicle();

        roadVehicle.run("摩托车");
        roadVehicle.run("汽车");

        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("飞机");

    }

}

class RoadVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在公路上运行");
    }
}

class AirVehicle{
    public void run(String vehicle) {
        System.out.println(vehicle + "在天空上运行");
    }
}

class WaterVehicle{
    public void run(String vehicle) {
        System.out.println(vehicle + "在水中运行");
    }
}
