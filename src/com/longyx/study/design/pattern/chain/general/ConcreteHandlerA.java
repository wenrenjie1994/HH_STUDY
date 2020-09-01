package com.spdb.study.design.pattern.chain.general;

/**
 * @author Mr.Longyx
 * @date 2020年07月10日 20:25
 */
public class ConcreteHandlerA extends Handler {
    @Override
    public void handleRequest(String request) {
        if ("requestA".equals(request)){
            System.out.println(this.getClass().getSimpleName() + "deal with request:"+request);
            return;
        }
        if (this.nextHandler != null){
            this.nextHandler.handleRequest(request);
        }
    }
}
