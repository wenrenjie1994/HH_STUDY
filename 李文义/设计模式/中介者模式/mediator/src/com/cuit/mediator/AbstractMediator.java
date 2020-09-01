package com.cuit.mediator;

import com.cuit.user.Purchase;
import com.cuit.user.Sale;
import com.cuit.user.Stock;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public abstract class AbstractMediator {
    protected Purchase purchase;
    protected Sale sale;
    protected Stock stock;
    /**
     * 功能描述:
     * 构造函数
     *
     * @author: liwenyi
     */
    public AbstractMediator(){
        purchase = new Purchase(this);
        sale = new Sale(this);
        stock = new Stock(this);
    }
    /**
     * 功能描述:
     * 中介者最重要的方法叫做事件方法，处理多个对象之间的关系
     *
     * @param str 1
     * @param objects 2
     * @return: void
     * @author: liwenyi
     */
    public abstract void execute(String str,Object...objects);
}
