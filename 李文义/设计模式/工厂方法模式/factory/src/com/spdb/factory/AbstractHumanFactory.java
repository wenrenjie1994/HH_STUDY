package com.spdb.factory;

import com.spdb.human.Human;

/**
 * @author liwenyi
 * @date 2020/7/20
 * desc
 */
public abstract class AbstractHumanFactory {

    /**
     * 功能描述:
     * 生产人
     *
     * @param c 1
     * @return: T
     * @author: liwenyi
     */
    public abstract<T extends Human> T createHuman(Class<T> c);
}
