package com.spdb.study.design.pattern.visitor.general;


import java.util.Random;

/**
 * 具体元素
 * @author Mr.Longyx
 * @date 2020年07月12日 21:13
 */
public class ConcreteElementB implements Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    public int operationB(){
        return new Random().nextInt(200);
    }

}
