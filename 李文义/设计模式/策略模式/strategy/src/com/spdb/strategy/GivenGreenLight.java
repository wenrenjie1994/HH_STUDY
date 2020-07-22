package com.spdb.strategy;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public class GivenGreenLight implements IStrategy {
    @Override
    public void operate() {
        System.out.println("求吴国太开绿灯,放行！");
    }
}
