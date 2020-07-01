package com.spdb.study.design.pattern.strategy.pay;
import com.spdb.study.design.pattern.strategy.pay.payport.Payment;
import com.spdb.study.design.pattern.strategy.pay.payport.PayStrategy;

import java.io.Serializable;

/**
 * 订单类
 * @author Mr.Longyx
 * @date 2020年06月28日 23:00
 */
public class Order implements Serializable {
    private static final long serialVersionUID = -8363191952056063801L;
    private String uid;

    private String orderId;

    private Double amount;

    public Order(String uid, String orderId, Double amount) {
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }

    /**
     * payKey:用户选择的支付方式
     * @author Mr.Longyx
     * @date 2020/6/28 23:21
     * @param payKey
     * @return com.spdb.study.design.pattern.strategy.pay.MsgResult
     */
    public MsgResult pay(String payKey){
        Payment pay = PayStrategy.get(payKey);
        System.out.println("欢迎使用："+pay.getName());
        System.out.println("本次交易金额为："+amount+",开始扣款...");
        return pay.pay(uid,amount);
    }
}
