package com.cuit.strategy;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public class BlockEnemy implements IStrategy {
    @Override
    public void operate() {
        System.out.println("孙夫人断后，挡住追兵");
    }
}
