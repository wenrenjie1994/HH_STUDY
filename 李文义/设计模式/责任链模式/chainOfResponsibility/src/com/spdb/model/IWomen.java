package com.spdb.model;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public interface IWomen {
    /**
     * 功能描述:
     * 获得个人状况
     *
     * @return: int
     * @author: liwenyi
     */
    public int getType();
    /**
     * 功能描述:
     * 获得个人请示，你要干什么？出去逛街？约会?还是看电影？
     *
     * @return: java.lang.String
     * @author: liwenyi
     */
    public String getRequest();
}
