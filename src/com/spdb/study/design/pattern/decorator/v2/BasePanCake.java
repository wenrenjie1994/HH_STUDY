package com.spdb.study.design.pattern.decorator.v2;

/**
 * @author Mr.Longyx
 * @date 2020年07月03日 10:38
 */
public class BasePanCake extends PanCake {

    @Override
    protected String getMsg(String food) {
        return food;
    }

    @Override
    protected int getPrice(int price) {
        return price;
    }
}
