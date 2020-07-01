package com.spdb.study.design.pattern.strategy.pay.payport;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr.Longyx
 * @date 2020年06月28日 23:42
 */
public class PayStrategy {
    public static final String ALI_PAY = "AliPay";
    public static final String JD_PAY = "JdPay";
    public static final String WECHAT_PAY = "WeChatPay";
    public static final String UNION_PAY = "UnionPay";
    public static final String DEFAULT_PAY = "AliPay";

    private static Map<String, Payment> payStrategyMap = new HashMap<>();

    static {
        payStrategyMap.put(ALI_PAY,new AliPay());
        payStrategyMap.put(JD_PAY,new JDPay());
        payStrategyMap.put(WECHAT_PAY,new WeChatPay());
        payStrategyMap.put(UNION_PAY, new UnionPay());
        payStrategyMap.put(DEFAULT_PAY, new AliPay());
    }

    /**
     * 策略模式优点：
     * 1、策略模式符合开闭原则
     * 2、避免使用多重条件转移语句
     * 3、使用策略模式可以提高算法的保密性和安全性
     * 策略模式缺点：
     * 1、客户端必须知道所有的策略，并且自行决定使用哪一个策略类
     * 2、代码中会产生非常多策略类，增加维护难度
     * @author Mr.Longyx
     * @date 2020/6/28 23:59
     * @param payKey
     * @return com.spdb.study.design.pattern.strategy.pay.payport.PayMent
     */
    public static Payment get(String payKey){
        if (!payStrategyMap.containsKey(payKey)){
            return payStrategyMap.get(DEFAULT_PAY);
        }
        return payStrategyMap.get(payKey);
    }
}
