package com.spdb.study.design.pattern.decorator.v1;

/**
 * @author Mr.Longyx
 * @date 2020年07月03日 9:59
 */
public class PanCakeWithEgg extends PanCake {
    @Override
    public String getMsg(String food) {
        return super.getMsg(food) + "+1个鸡蛋";
    }

    @Override
    public int getPrice(int price) {
        return super.getPrice(price) + 1;
    }
}
