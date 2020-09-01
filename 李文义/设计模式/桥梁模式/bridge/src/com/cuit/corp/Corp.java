package com.cuit.corp;

import com.cuit.product.Product;

/**
 * @author liwenyi
 * @date 2020/7/22
 * desc
 */
public abstract class Corp {
    /**
     * 功能描述:
     * 定义一个抽象的产品对象，不知道具体是什么产品
     *
     * @author: liwenyi
     */
    private Product product;

    public Corp(Product product) {
        this.product = product;
    }

    /**
     * 功能描述:
     * 公司是干什么的？赚钱的！
     *
     * @return: void
     * @author: liwenyi
     */
    public void makeMoney() {
        //每家公司都是一样，先生产
        this.product.beProducted();
        //然后销售
        this.product.beSelled();
    }
}
