package com.spdb.human;

/**
 * @author liwenyi
 * @date 2020/7/20
 * desc
 */
public abstract class AbstractYellowHuman implements Human {
    @Override
    public void getColor(){
        System.out.println("黄色人种的皮肤颜色是黄色的！");
    }
    @Override
    public void talk() {
        System.out.println("黄色人种会说话，一般说的都是双字节。");
    }
}
