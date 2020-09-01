package com.spdb.study.design.pattern.facade.points;

/**
 * 支付系统
 * @author Mr.Longyx
 * @date 2020年07月05日 19:38
 */
public class PaymentService {
    /**
     * 默认扣款成功
     * @author Mr.Longyx
     * @date 2020/7/5 21:54
     * @param giftInfo
     * @return boolean
     */
    public boolean pay(GiftInfo giftInfo){
        System.out.println("扣减"+giftInfo.getName()+" 积分成功");
        return true;
    }
}
