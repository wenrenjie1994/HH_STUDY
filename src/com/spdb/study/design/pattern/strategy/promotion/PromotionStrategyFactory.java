package com.spdb.study.design.pattern.strategy.promotion;

import java.util.HashMap;
import java.util.Map;

/**
 * 促销策略初始化
 * 单例+工厂改造if....else...
 * @author Mr.Longyx
 * @date 2020年06月28日 22:32
 */
public class PromotionStrategyFactory {
    private static final PromotionStrategy NON_PROMOTION = new RawPriceStrategy();

    private static Map<String,PromotionStrategy> PROMOTION_STRATEGY_MAP = new HashMap<>();

    /**
     * 先缓存
     * @author Mr.Longyx
     * @date 2020/6/28 22:45
     */
    static{
        PROMOTION_STRATEGY_MAP.put(PromotionKey.COUPON,new CouponStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.CASHBACK,new CashBackStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.GROUPBY,new GroupByStrategy());
    }

    /**
     * 构造方法私有化
     * @author Mr.Longyx
     * @date 2020/6/28 22:35
     */
    private PromotionStrategyFactory(){}

    /**
     * 提供统一访问入口
     * @author Mr.Longyx
     * @date 2020/6/28 22:38
     * @param promotionKey
     * @return com.spdb.study.design.pattern.strategy.promotion.PromotionStrategyFactory
     */
    public static PromotionStrategy getPromotionStrategy(String promotionKey){
        PromotionStrategy promotionStrategy = PROMOTION_STRATEGY_MAP.get(promotionKey);
        return promotionStrategy  == null ? NON_PROMOTION : promotionStrategy;
    }

}
