package com.cuit.user;

import com.cuit.mediator.AbstractMediator;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public class Purchase extends AbstractColleague{

    public Purchase(AbstractMediator _mediator) {
        super(_mediator);
    }

    /**
     * 功能描述:
     * 采购IBM电脑
     *
     * @param number 1
     * @return: void
     * @author: liwenyi
     */
    public void buyIBMcomputer(int number) {
        super.mediator.execute("purchase.buy", number);
    }

    /**
     * 功能描述:
     * 不再采购IBM电脑
     *
     * @return: void
     * @author: liwenyi
     */
    public void refuseBuyIBM() {
        System.out.println("不再采购IBM电脑");
    }
}
