package com.longyx.study.design.pattern.chain.general;

/**
 * 顶层抽象类
 * 责任连模式的适用场景：
 * 1、多个对象可以处理统一请求，但具体由哪个对象处理则在运行时动态决定
 * 2、在不明确指定接收者的情况下，向多个对象中的一个提交一个请求
 * 3、可动态指定一组对象处理请求
 * @author Mr.Longyx
 * @date 2020年07月10日 20:20
 */
public abstract class Handler {
    protected Handler nextHandler;

    public void setNextHandler(Handler handler){
        this.nextHandler = handler;
    }

    public abstract void handleRequest(String request);
}
