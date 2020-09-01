package com.cuit.product;

/**
 * @author liwenyi
 * @date 2020/7/22
 * desc
 */
public class IPod extends Product {
    @Override
    public void beProducted() {
        System.out.println("生产出的iPod是这样的...");
    }

    @Override
    public void beSelled() {
        System.out.println("生产出的iPod卖出去了...");
    }
}
