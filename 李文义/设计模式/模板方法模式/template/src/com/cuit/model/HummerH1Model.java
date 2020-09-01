package com.cuit.model;

/**
 * @author liwenyi
 * @date 2020/7/20
 * desc
 */
public class HummerH1Model extends HummerModel {
    @Override
    protected void start() {
        System.out.println("悍马H1发动...");    }

    @Override
    protected void stop() {
        System.out.println("悍马H1停车...");
    }

    @Override
    protected void alarm() {
        System.out.println("悍马H1鸣笛...");
    }

    @Override
    protected void engineBoom() {
        System.out.println("悍马H1引擎声音是这样的...");
    }
}
