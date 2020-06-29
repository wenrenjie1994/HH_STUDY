package com.spdb.study.design.pattern.strategy.promotion;

import org.apache.commons.lang3.StringUtils;

/**
 * 活动策略测试类
 * @author Mr.Longyx
 * @date 2020年06月28日 22:06
 */
public class PromotionActivityTest {
    /**
     * 该种方式不能满足根据用户实际需求，执行不同的策略
     * @author Mr.Longyx
     * @date 2020/6/28 22:12
     * public static void main(String[] args) {
     *      PromotionActivity activity618 = new PromotionActivity(new CouponStrategy());
     *      PromotionActivity activity11 = new PromotionActivity(new CashBackStrategy());
     *
     *      activity618.publish();
     *      activity11.publish();
     *  }
     */

    /**
     * 待优化
     * @author Mr.Longyx
     * @date 2020/6/28 22:53
     * public static void main(String[] args) {
     *         PromotionActivity activity = null;
     *         String promotionKey = "COUPON";
     *
     *         if (StringUtils.equals(promotionKey,"COUPON")){
     *             activity = new PromotionActivity(new CouponStrategy());
     *         }else if(StringUtils.equals(promotionKey,"CASHBACK")){
     *             activity = new PromotionActivity(new CashBackStrategy());
     *         }else if(StringUtils.equals(promotionKey,"GROUPBY")){
     *             activity = new PromotionActivity(new GroupByStrategy());
     *         } //...
     *
     *         activity.publish();
     *     }
     */

    public static void main(String[] args) {
        String promotionKey = "GROUPBY";
        PromotionActivity activity = new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy(promotionKey));
        activity.publish();
    }

}
