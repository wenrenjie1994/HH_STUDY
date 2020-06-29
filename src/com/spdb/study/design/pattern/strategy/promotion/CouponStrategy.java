package com.spdb.study.design.pattern.strategy.promotion;

/**
 * 优惠券方式促销
 * @author Mr.Longyx
 * @date 2020年06月28日 21:55
 */
public class CouponStrategy implements PromotionStrategy{

    @Override
    public void doPromotion() {
        System.out.println("领取优惠券，最终价格以抵扣优惠券面值后的价格为准！");
    }
}
