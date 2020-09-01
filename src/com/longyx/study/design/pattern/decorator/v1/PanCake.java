package com.spdb.study.design.pattern.decorator.v1;

/**
 * 未引入装饰器模式的粗糙版本(不符合开闭原则)
 * @author Mr.Longyx
 * @date 2020年07月03日 9:55
 */
public class PanCake {
    protected String getMsg(String food){
        return food;
    }
    public int getPrice(int price){
        return price;
    }
}
