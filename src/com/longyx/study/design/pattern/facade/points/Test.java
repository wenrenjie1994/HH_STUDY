package com.longyx.study.design.pattern.facade.points;

import com.longyx.study.design.pattern.facade.general.Facade;

/**
 * @author Mr.Longyx
 * @date 2020年07月05日 21:35
 */
public class Test {
    public static void main(String[] args) {
        /**
         * 未引入门面模式，处理逻辑交给了用户处理
         * PaymentService paymentService = new PaymentService();
         * QualifyService qualifyService = new QualifyService();
         * LogisticsService logisticsService = new LogisticsService();
         *
         * GiftInfo info = new GiftInfo("《Linux内核编译原理》");
         *    if (qualifyService.isAvailable(info)){
         *        if (paymentService.pay(info)){
         *             String giftNo =  logisticsService.delivery(info);
         *             System.out.println("物流系统下单成功，物流单号为："+giftNo);
         *        }
         *  }
         * @author Mr.Longyx
         * @date 2020/7/5 21:37
         */

        /**
         * 引入门面模式
         * @author Mr.Longyx
         * @date 2020/7/5 21:52
         */
        FacadeService facade = new FacadeService();
        facade.exchange(new GiftInfo("《Linux内核编译原理》"));

    }
}
