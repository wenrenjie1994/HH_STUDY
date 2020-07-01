package com.spdb.study.design.pattern.strategy.pay.payport;

/**
 * @author Mr.Longyx
 * @date 2020年06月28日 23:37
 */
public class UnionPay extends Payment {
    @Override
    public String getName() {
        return "银联支付";
    }

    @Override
    protected Double queryBalance(String uid) {
        return new Double(120);
    }
}
