package com.spdb.study.design.pattern.strategy.pay.payport;

/**
 * @author Mr.Longyx
 * @date 2020年06月28日 23:36
 */
public class WeChatPay extends Payment {
    @Override
    public String getName() {
        return "微信支付";
    }

    @Override
    protected Double queryBalance(String uid) {
        return new Double(250);
    }
}
