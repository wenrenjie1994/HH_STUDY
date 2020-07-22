package com.spdb.context;

import com.spdb.strategy.IStrategy;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public class Context {

    private IStrategy straegy;

    /**
     * 功能描述:
     * 构造函数，你要使用哪个妙计
     *
     * @param strategy 1
     * @return:
     * @author: liwenyi
     */
    public Context(IStrategy strategy) {
        this.straegy = strategy;
    }

    /**
     * 功能描述:
     * 使用计谋了，看我出招了
     *
     * @return: void
     * @author: liwenyi
     */
    public void operate() {
        this.straegy.operate();
    }
}
