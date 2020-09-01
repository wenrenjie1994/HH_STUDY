package com.spdb.study.design.pattern.decorator.v1;

/**
 * @author Mr.Longyx
 * @date 2020年07月03日 10:09
 */
public class PanCakeTest {
    public static void main(String[] args) {
        PanCake panCake = new PanCake();
        System.out.println(panCake.getMsg("煎饼")+",总价："+panCake.getPrice(5));

        PanCake pc = new PanCakeWithEgg();
        System.out.println(pc.getMsg("煎饼")+",总价："+pc.getPrice(5));

        PanCake cake = new PanCakeWithEggAndHotdog();
        System.out.println(cake.getMsg("煎饼")+"，总价："+cake.getPrice(5));
    }
}
