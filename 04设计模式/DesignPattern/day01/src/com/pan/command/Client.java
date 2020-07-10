package com.pan.command;

public class Client {
    public static void main(String[] args) {
        //使用命令设计模式，完成通过遥控器对电灯的操作

        //创建电灯的对象-接受者
        LightReceiver lightReceiver = new LightReceiver();

        //创建电灯相关的开关命令
        LightOnCommand lightOnCommand = new LightOnCommand(lightReceiver);
        LightOffCommand lightOffCommand = new LightOffCommand(lightReceiver);

        //需要一个遥控器
        RemoteController remoteController = new RemoteController();

        //给遥控器设置命令，比如no=0是电灯的开和关的操作
        remoteController.setCommand(0,lightOnCommand,lightOffCommand);

        System.out.println("------按下电灯开的按钮----------");
        remoteController.onButtonWasPushed(0);
        System.out.println("------按下电灯关的按钮----------");
        remoteController.offButtonWasPushed(0);
        System.out.println("------按下电灯撤销的按钮----------");
        remoteController.undoButtonWasPushed();
    }
}
