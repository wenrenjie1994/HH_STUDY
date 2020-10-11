package com.longyx.study.design.pattern.decorator.extend;

/**
 * 女孩涂口红
 * @author Mr.Longyx
 * @date 2020年07月03日 11:48
 */
public class LipStick extends GirlDecorator{
    public LipStick(Showable showable) {
        super(showable);
    }

    @Override
    public void show() {
        System.out.print("涂口红(");
        showable.show();
        System.out.print(")");
    }
}
