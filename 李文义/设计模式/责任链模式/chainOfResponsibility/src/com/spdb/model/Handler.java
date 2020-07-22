package com.spdb.model;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public abstract class Handler {
    public final static int FATHER_LEVEL_REQUEST = 1;
    public final static int HUSBAND_LEVEL_REQUEST = 2;
    public final static int SON_LEVEL_REQUEST = 3;
    /**
     * 功能描述:
     * 能处理的级别
     *
     * @author: liwenyi
     */
    private int level = 0;
    /**
     * 功能描述:
     * 责任传递，下一个人责任人是谁
     *
     * @author: liwenyi
     */
    private Handler nextHandler;

    /**
     * 功能描述:
     * 每个类都要说明一下自己能处理哪些请求
     *
     * @param _level 1
     * @return:
     * @author: liwenyi
     */
    public Handler(int _level) {
        this.level = _level;
    }

    /**
     * 功能描述:
     * 一个女性（女儿、妻子或者是母亲）要求逛街，你要处理这个请求
     *
     * @param women 1
     * @return: void
     * @author: liwenyi
     */
    public final void HandleMessage(IWomen women) {
        if (women.getType() == this.level) {
            this.response(women);
        } else {
            //有后续环节，才把请求往后递送
            if (this.nextHandler != null) {
                this.nextHandler.HandleMessage(women);
            } else { //已经没有后续处理人了，不用处理了
                System.out.println("---没地方请示了，按不同意处理---\n");
            }
        }
    }

    /**
     * 功能描述:
     * 如果不属于你处理的请求，你应该让她找下一个环节的人，如女儿出嫁了，
     * 还向父亲请示是否可以逛街，那父亲就应该告诉女儿，应该找丈夫请示
     *
     * @param _handler 1
     * @return: void
     * @author: liwenyi
     */
    public void setNext(Handler _handler) {
        this.nextHandler = _handler;
    }

    /**
     * 功能描述:
     * 有请示那当然要回应
     *
     * @param women 1
     * @return: void
     * @author: liwenyi
     */
    protected abstract void response(IWomen women);
}
