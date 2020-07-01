package com.spdb.study.design.pattern.strategy.promotion;

/**
 *  团购促销方式
 * @author Mr.Longyx
 * @date 2020年06月28日 22:00
 */
public class GroupByStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("拼团，满20人成团，全团享受团购价");
    }
}
