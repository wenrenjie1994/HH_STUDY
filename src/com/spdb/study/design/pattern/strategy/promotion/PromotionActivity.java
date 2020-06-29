package com.spdb.study.design.pattern.strategy.promotion;

/**
 * 促销活动类
 * @author Mr.Longyx
 * @date 2020年06月28日 22:03
 */
public class PromotionActivity {
    private PromotionStrategy strategy;

    public PromotionActivity(PromotionStrategy strategy){
        this.strategy = strategy;
    }
    public void publish(){
        this.strategy.doPromotion();
    }
}
