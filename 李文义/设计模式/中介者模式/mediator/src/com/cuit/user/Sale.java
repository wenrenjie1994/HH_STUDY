package com.cuit.user;

import com.cuit.mediator.AbstractMediator;

import java.util.Random;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public class Sale extends AbstractColleague{

    public Sale(AbstractMediator _mediator) {
        super(_mediator);
    }

    /**
     * 功能描述:
     * 销售IBM电脑
     *
     * @param number 1
     * @return: void
     * @author: liwenyi
     */
    public void sellIBMComputer(int number) {
        super.mediator.execute("sale.sell", number);
        System.out.println("销售IBM电脑"+number+"台");
    }

    /**
     * 功能描述:
     * 反馈销售情况，0～100之间变化，0代表根本就没人卖，100代表非常畅销，出一个卖一个
     *
     * @return: int
     * @author: liwenyi
     */
    public int getSaleStatus() {
        Random rand = new Random(System.currentTimeMillis());
        int saleStatus = rand.nextInt(100);
        System.out.println("IBM电脑的销售情况为：" + saleStatus);
        return saleStatus;
    }

    /**
     * 功能描述:
     * 折价处理
     *
     * @return: void
     * @author: liwenyi
     */
    public void offSale() {
        super.mediator.execute("sale.offsell");
    }
}
