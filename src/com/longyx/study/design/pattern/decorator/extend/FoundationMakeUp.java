package com.longyx.study.design.pattern.decorator.extend;

/**
 * 给女孩素颜打粉底
 * @author Mr.Longyx
 * @date 2020年07月03日 11:45
 */
public class FoundationMakeUp extends GirlDecorator{

    public FoundationMakeUp(Showable showable) {
        super(showable);
    }

    @Override
    public void show() {
        System.out.print("打粉底(");
        showable.show();
        System.out.print(")");
    }
}
