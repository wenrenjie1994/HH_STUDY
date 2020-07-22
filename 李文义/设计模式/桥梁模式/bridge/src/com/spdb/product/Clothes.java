package com.spdb.product;

/**
 * @author liwenyi
 * @date 2020/7/22
 * desc
 */
public class Clothes extends Product {
    @Override
    public void beProducted() {
        System.out.println("生产出的衣服是这样的...");
    }

    @Override
    public void beSelled() {
        System.out.println("生产出的衣服卖出去了...");
    }
}
