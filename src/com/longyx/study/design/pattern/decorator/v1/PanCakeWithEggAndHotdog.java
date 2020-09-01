package com.spdb.study.design.pattern.decorator.v1;

/**
 * @author Mr.Longyx
 * @date 2020年07月03日 10:07
 */
public class PanCakeWithEggAndHotdog extends PanCakeWithEgg {
    @Override
    public String getMsg(String food) {
        return super.getMsg(food) + "+1根烤肠";
    }

    @Override
    public int getPrice(int price) {
        return super.getPrice(price) + 2;
    }
}
