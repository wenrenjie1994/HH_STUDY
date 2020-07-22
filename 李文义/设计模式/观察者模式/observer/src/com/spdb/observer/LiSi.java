package com.spdb.observer;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public class LiSi implements Observer {

    @Override
    public void update(String context) {
        System.out.println("李斯:观察到韩非子活动，开始向老板汇报了...");
        this.reportToQinShiHuang(context);
        System.out.println("李斯：汇报完毕...\n");
    }

    /**
     * 功能描述:
     * 汇报给秦始皇
     *
     * @param reportContext 1
     * @return: void
     * @author: liwenyi
     */
    private void reportToQinShiHuang(String reportContext){
        System.out.println("李斯：报告，秦始皇！韩非子有活动了--->"+reportContext);
    }
}
