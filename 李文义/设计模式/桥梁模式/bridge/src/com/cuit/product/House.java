package com.cuit.product;

/**
 * @author liwenyi
 * @date 2020/7/22
 * desc
 */
public class House extends Product {
    @Override
    public void beProducted() {
        System.out.println("生产出的房子是这样的...");
    }

    @Override
    public void beSelled() {
        System.out.println("生产出的房子卖出去了...");
    }
}
