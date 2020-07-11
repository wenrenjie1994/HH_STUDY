package com.spdb.study.design.pattern.chain.general;

/**
 * @author Mr.Longyx
 * @date 2020年07月10日 20:32
 */
public class Test {
    public static void main(String[] args) {
        ConcreteHandlerA handlerA = new ConcreteHandlerA();
        ConcreteHandlerB handlerB = new ConcreteHandlerB();

        handlerA.setNextHandler(handlerB);
        handlerA.handleRequest("requestB");
    }
}
