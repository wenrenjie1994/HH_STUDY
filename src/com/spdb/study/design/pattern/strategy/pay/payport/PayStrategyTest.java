package com.spdb.study.design.pattern.strategy.pay.payport;

import com.spdb.study.design.pattern.strategy.pay.MsgResult;
import com.spdb.study.design.pattern.strategy.pay.Order;

/**
 * 支付策略测试类
 * 策略模式：将指定的算法封装起来，让它们之间可以互相替换(例如用户可选择支付宝支付，银联支付等支付方式)，对用户而言只需要关心结果
 * @author Mr.Longyx
 * @date 2020年06月28日 23:37
 */
public class PayStrategyTest {
    public static void main(String[] args) {
        Order order = new Order("1","2019049372810489",350.99);
        MsgResult result = order.pay(PayStrategy.UNION_PAY);
        System.out.println(result);
    }
}
