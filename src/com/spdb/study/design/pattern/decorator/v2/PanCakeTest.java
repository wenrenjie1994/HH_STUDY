package com.spdb.study.design.pattern.decorator.v2;

/**
 * @author Mr.Longyx
 * @date 2020年07月03日 11:18
 */
public class PanCakeTest {
    private  static PanCake panCake;
    public static void main(String[] args) {
        //原生煎饼
        panCake= new BasePanCake();
        System.out.println(panCake.getMsg("煎饼")+",总价："+panCake.getPrice(5));

        //原生煎饼+1个鸡蛋
        panCake = new EggDecorator(panCake);
        System.out.println(panCake.getMsg("煎饼")+",总价："+panCake.getPrice(5));

        //原生煎饼+1个鸡蛋+1根烤肠
        panCake = new HotdogDecortor(new EggDecorator(panCake));
        System.out.println(panCake.getMsg("煎饼")+",总价："+panCake.getPrice(5));
    }
}
