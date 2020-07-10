package com.pan.visitor;

//说明
//1.使用到双分派，即首先在客户端程序中，将具体状态作为参数传到Woman中（第一次分派）
//2.然后Woman类调用作为参数的“具体方法”中的getWomanResult，同时将自己（this）作为参数传入，作为第二次分派

public class Woman extends Person{
    @Override
    public void accept(Action action) {
        action.getWomanResult(this);
    }
}
