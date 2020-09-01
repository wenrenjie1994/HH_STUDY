package com.cuit.product;

/**
 * @author liwenyi
 * @date 2020/7/22
 * desc
 */
public abstract class Product {
    /**
     * 功能描述:
     * 甭管是什么产品它总要能被生产出来
     *
     * @return: void
     * @author: liwenyi
     */
    public abstract void beProducted();
    /**
     * 功能描述:
     * 生产出来的东西，一定要销售出去，否则亏本
     *
     * @return: void
     * @author: liwenyi
     */
    public abstract void beSelled();
}
