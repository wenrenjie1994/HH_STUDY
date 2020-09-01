package com.cuit;

/**
 * @author liwenyi
 * @date 2020/7/20
 * desc
 */
public class Emperor {

    private static final Emperor EMPEROR = new Emperor();

    private Emperor() {
    }

    public static Emperor getInstance() {
        return EMPEROR;
    }

    public static void say() {
        System.out.println("我就是皇帝。。。");
    }
}
