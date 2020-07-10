package com.pan.command;

//没有任何命令，即空执行，用于初始化每个按钮
//挡调用空命令时，对象什么都不做
//其实这也是一种设计模式，可以省掉对空的判断
public class NoCommand implements Command{
    //空命令
    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
