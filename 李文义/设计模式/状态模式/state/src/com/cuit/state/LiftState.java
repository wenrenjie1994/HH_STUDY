package com.cuit.state;

/**
 * @author liwenyi
 * @date 2020/7/22
 * desc
 */
public abstract class LiftState {
    /**
     * 功能描述:
     * 定义一个环境角色，也就是封装状态的变化引起的功能变化
     *
     * @return:
     * @author: liwenyi
     */
    protected Context context;

    public void setContext(Context _context) {
        this.context = _context;
    }

    /**
     * 功能描述:
     * 首先电梯门开启动作
     *
     * @return: void
     * @author: liwenyi
     */
    public abstract void open();

    /**
     * 功能描述:
     * 电梯门可以开启，那当然也就有关闭了
     *
     * @return: void
     * @author: liwenyi
     */
    public abstract void close();

    /**
     * 功能描述:
     * 电梯要能上能下
     *
     * @return: void
     * @author: liwenyi
     */
    public abstract void run();

    /**
     * 功能描述:
     * 电梯还要能停下来
     *
     * @return: void
     * @author: liwenyi
     */
    public abstract void stop();
}
