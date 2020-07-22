package com.spdb;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public class Client {
    public static void main(String[] args) {
        Director director = new Director();
        //2辆A类型的奔驰车
        for (int i = 0; i < 2; i++) {
            director.getABenzModel().run();
        }
        //2辆B类型的奔驰车
        for (int i = 0; i < 2; i++) {
            director.getBBenzModel().run();
        }
        //2辆C类型的宝马车
        for (int i = 0; i < 2; i++) {
            director.getCBMWModel().run();
        }
    }
}
