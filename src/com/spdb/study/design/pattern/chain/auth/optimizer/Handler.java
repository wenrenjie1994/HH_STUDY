package com.spdb.study.design.pattern.chain.auth.optimizer;

import com.spdb.study.design.pattern.chain.auth.old.User;

/**
 * @author Mr.Longyx
 * @date 2020年07月10日 21:46
 */
public abstract class Handler {
    protected Handler next;
    public void next(Handler next){
        this.next = next;
    }

    public abstract void doHandler(User user);
}
