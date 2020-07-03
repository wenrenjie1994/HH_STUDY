package com.spdb.study.design.pattern.decorator.v2;

/**
 * @author Mr.Longyx
 * @date 2020年07月03日 11:17
 */
public  class HotdogDecortor extends PanCakeDecorator {
    public HotdogDecortor(PanCake panCake) {
        super(panCake);
    }

    @Override
    protected String getMsg(String food) {
        return super.getMsg(food) + "+1根烤肠";
    }

    @Override
    protected int getPrice(int price) {
        return super.getPrice(price) + 2;
    }
}
