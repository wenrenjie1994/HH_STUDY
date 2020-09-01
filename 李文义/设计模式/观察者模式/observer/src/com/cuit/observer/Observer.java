package com.cuit.observer;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public interface Observer {
    /**
     * 功能描述:
     * 一发现别人有动静，自己也要行动起来
     *
     * @param context 1
     * @return: void
     * @author: liwenyi
     */
    public void update(String context);
}
