package com.longyx.study.design.pattern.decorator.extend;

/**
 * @author Mr.Longyx
 * @date 2020年07月03日 11:43
 */
public abstract class GirlDecorator implements Showable{
    /**
     * 此处持有被装饰者的引用
     * @author Mr.Longyx
     * @date 2020/7/3 11:44
     */
    public Showable showable;

    public GirlDecorator(Showable showable) {
        this.showable = showable;
    }

    @Override
    public void show() {
        showable.show();
    }
}
