package com.spdb.study.design.pattern.decorator.v2;

/**
 * @author Mr.Longyx
 * @date 2020年07月03日 11:13
 */
public  class EggDecorator extends PanCakeDecorator {
    public EggDecorator(PanCake panCake) {
        super(panCake);
    }

    @Override
    protected String getMsg(String food) {
        return super.getMsg(food)+"+1个鸡蛋";
    }

    @Override
    protected int getPrice(int price) {
        return super.getPrice(price) + 1;
    }
}
