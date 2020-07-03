package com.spdb.study.design.pattern.decorator.v2;

/**
 * 后续用于扩展的装饰类
 * @author Mr.Longyx
 * @date 2020年07月03日 11:00
 */
public abstract class PanCakeDecorator extends PanCake{
    /**
     * 每次包装时都需要将被包装的对象加入进来作为其组成部分
     * @author Mr.Longyx
     * @date 2020/7/3 11:09
     */
    private PanCake panCake;

    public PanCakeDecorator(PanCake panCake) {
        this.panCake = panCake;
    }

    @Override
    protected String getMsg(String food) {
        return this.panCake.getMsg(food);
    }

    @Override
    protected int getPrice(int price) {
        return this.panCake.getPrice(price);
    }
}
