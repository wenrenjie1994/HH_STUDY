package com.spdb.study.design.pattern.strategy.pay.payport;

/**
 * 支付宝支付
 * @author Mr.Longyx
 * @date 2020年06月28日 23:22
 */
public class AliPay extends Payment {

    @Override
    public String getName() {
        return "支付宝";
    }

    @Override
    protected Double queryBalance(String uid) {
        return new Double(1024);
    }
}
