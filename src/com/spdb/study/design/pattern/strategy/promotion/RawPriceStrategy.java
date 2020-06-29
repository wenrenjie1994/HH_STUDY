package com.spdb.study.design.pattern.strategy.promotion;

/**
 * 原价售卖(无优惠)
 * @author Mr.Longyx
 * @date 2020年06月28日 21:53
 */
public class RawPriceStrategy implements PromotionStrategy{

    @Override
    public void doPromotion() {
        System.out.println("无促销活动");
    }
}
