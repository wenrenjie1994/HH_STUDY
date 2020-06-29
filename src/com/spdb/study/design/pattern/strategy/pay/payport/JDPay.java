package com.spdb.study.design.pattern.strategy.pay.payport;

/**
 * @author Mr.Longyx
 * @date 2020年06月28日 23:35
 */
public class JDPay extends Payment {
    @Override
    public String getName() {
        return "京东白条";
    }

    @Override
    protected Double queryBalance(String uid) {
        return new Double(2048);
    }
}
