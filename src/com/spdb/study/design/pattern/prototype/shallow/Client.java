package com.spdb.study.design.pattern.prototype.shallow;

/**
 * 完成原型的接收工作
 * @author Mr.Longyx
 * @date 2020年06月25日 22:42
 */
public class Client {

    private Prototype prototype;

    public Prototype initClone(Prototype prototype){
        return prototype.clone();
    }
}
