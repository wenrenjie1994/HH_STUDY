package com.spdb.study.design.pattern.facade.points;

/**
 * 门面模式
 * 优点：
 * 1、简化了调用过程，无需深入了解子系统，以防给子系统带来风险
 * 2、减少系统依赖、松散耦合
 * 3、更好的划分访问层次，提高了安全性(如Controller->Service->Dao)
 * 4、遵循迪米特法则，即最少知道原则
 * 缺点：
 * 1、当增加子系统和扩展子系统行为时，可能容易带来未知风险
 * 2、不符合开闭原则
 * 3、某些情况下可能违背单一职责原则
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
