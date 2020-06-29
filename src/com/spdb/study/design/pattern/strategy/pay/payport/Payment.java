package com.spdb.study.design.pattern.strategy.pay.payport;

import com.spdb.study.design.pattern.strategy.pay.MsgResult;

/**
 * 支付的抽象
 * @author Mr.Longyx
 * @date 2020年06月28日 23:22
 */
public abstract class Payment {
    public abstract String getName();

    protected abstract Double queryBalance(String uid);

    public MsgResult pay(String uid, Double amount){
        if (queryBalance(uid) < amount){
            return new MsgResult(500,"支付失败","余额不足");
        }
        return new MsgResult(200,"支付成功","支付金额："+amount);
    }
}
