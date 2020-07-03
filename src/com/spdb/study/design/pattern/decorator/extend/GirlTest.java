package com.spdb.study.design.pattern.decorator.extend;

/**
 * @author Mr.Longyx
 * @date 2020年07月03日 11:50
 */
public class GirlTest {
    private static Showable showable;
    public static void main(String[] args) {
        //素颜女孩
        showable = new Girl();
        showable.show();

        //素颜+打粉底
        showable = new FoundationMakeUp(new Girl());
        showable.show();

        //素颜+打粉底+涂口红
        showable = new LipStick(new FoundationMakeUp(new Girl()));
        showable.show();
    }
}
