package com.spdb.user;

import com.spdb.mediator.AbstractMediator;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public class Stock extends AbstractColleague{
    /**
     * 功能描述:
     * 刚开始有100台电脑
     *
     * @author: liwenyi
     */
    private static int COMPUTER_NUMBER =100;

    public Stock(AbstractMediator _mediator) {
        super(_mediator);
    }

    /**
     * 功能描述:
     * 库存增加
     *
     * @param number 1
     * @return: void
     * @author: liwenyi
     */
    public void increase(int number){
        COMPUTER_NUMBER = COMPUTER_NUMBER + number;
        System.out.println("库存数量为："+COMPUTER_NUMBER);
    }
    /**
     * 功能描述:
     * 库存降低
     *
     * @param number 1
     * @return: void
     * @author: liwenyi
     */
    public void decrease(int number){
        COMPUTER_NUMBER = COMPUTER_NUMBER - number;
        System.out.println("库存数量为："+COMPUTER_NUMBER);
    }
    /**
     * 功能描述:
     * 获得库存数量
     *
     * @return: int
     * @author: liwenyi
     */
    public int getStockNumber(){
        return COMPUTER_NUMBER;
    }
    /**
     * 功能描述:
     * 存货压力大了，就要通知采购人员不要采购，销售人员要尽快销售
     *
     * @return: void
     * @author: liwenyi
     */
    public void clearStock(){
        System.out.println("清理存货数量为："+COMPUTER_NUMBER);
        super.mediator.execute("stock.clear");
    }
}
