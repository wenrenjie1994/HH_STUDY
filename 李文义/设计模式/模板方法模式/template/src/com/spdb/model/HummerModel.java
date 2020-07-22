package com.spdb.model;

/**
 * @author liwenyi
 * @date 2020/7/20
 * desc
 */
public abstract class HummerModel {
    /**
     * 功能描述:
     * 启动
     *
     * @return: void
     * @author: liwenyi
     */
    protected abstract void start();

    /**
     * 功能描述:
     * 停止
     *
     * @return: void
     * @author: liwenyi
     */
    protected abstract void stop();

    /**
     * 功能描述:
     * 鸣笛
     *
     * @return: void
     * @author: liwenyi
     */
    protected abstract void alarm();

    /**
     * 功能描述:
     * 引擎声
     *
     * @return: void
     * @author: liwenyi
     */
    protected abstract void engineBoom();

    public final void run() {
        //先发动汽车
        this.start();
        //引擎开始轰鸣
        this.engineBoom();
        //然后就开始跑了，跑的过程中遇到一条狗挡路，就按喇叭
        this.alarm();
        //到达目的地就停车
        this.stop();
    }
}
