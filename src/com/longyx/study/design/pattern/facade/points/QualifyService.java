package com.longyx.study.design.pattern.facade.points;

/**
 * 积分系统做校验
 * @author Mr.Longyx
 * @date 2020年07月05日 19:41
 */
public class QualifyService {
    /**
     * 默认校验通过
     * @author Mr.Longyx
     * @date 2020/7/5 21:54
     * @param giftInfo
     * @return boolean
     */
    public boolean isAvailable(GiftInfo giftInfo) {
        System.out.println("校验"+giftInfo.getName() + "积分通过，库存通过。");
        return true;
    }
}
