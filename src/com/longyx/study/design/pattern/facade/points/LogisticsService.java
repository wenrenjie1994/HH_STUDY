package com.longyx.study.design.pattern.facade.points;

import java.util.Random;


/**
 * 物流系统
 * @author Mr.Longyx
 * @date 2020年07月05日 20:02
 */
public class LogisticsService {
    public String delivery(GiftInfo giftInfo){
        System.out.println("准备揽件，邮寄："+giftInfo.getName()+"注意查收");
        String giftNo = String.valueOf(new Random().nextInt(999999)*1000);
        return giftNo;
    }
}
