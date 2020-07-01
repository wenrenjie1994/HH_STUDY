package com.spdb.study.design.pattern.strategy.promotion;

/**
 * 返现策略促销
 * @author Mr.Longyx
 * @date 2020年06月28日 21:57
 */
public class CashBackStrategy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("商场促销，返现将返还的金额转到支付宝账号");
    }
}
