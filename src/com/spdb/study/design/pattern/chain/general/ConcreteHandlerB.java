package com.spdb.study.design.pattern.chain.general;

/**
 * @author Mr.Longyx
 * @date 2020年07月10日 20:30
 */
public class ConcreteHandlerB extends Handler {
    @Override
    public void handleRequest(String request) {
        if ("requestB".equals(request)) {
            System.out.println(this.getClass().getSimpleName()+"deal with request: "+request);
            return;
        }
        if (this.nextHandler != null){
            this.nextHandler.handleRequest(request);
        }
    }
}
