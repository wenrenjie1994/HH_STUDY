package com.spdb.study.design.pattern.facade.points;

/**
 * 门面模式
 * @author Mr.Longyx
 * @date 2020年07月05日 21:48
 */
public class FacadeService {
    private QualifyService qualifyService = new QualifyService();
    private PaymentService paymentService = new PaymentService();
    private LogisticsService logisticsService = new LogisticsService();

    public void exchange(GiftInfo giftInfo){
        if (qualifyService.isAvailable(giftInfo)){
            if (paymentService.pay(giftInfo)){
                String giftNo = logisticsService.delivery(giftInfo);
                System.out.println("物流系统下单成功，物流单号为："+giftNo);
            }
        }
    }
}
