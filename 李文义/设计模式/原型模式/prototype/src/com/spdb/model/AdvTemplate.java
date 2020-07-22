package com.spdb.model;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public class AdvTemplate {
    /**
     * 功能描述:
     * 广告信名称
     *
     * @author: liwenyi
     */
    private String advSubject ="XX银行国庆信用卡抽奖活动";
    /**
     * 功能描述:
     * 广告信内容
     *
     * @author: liwenyi
     */
    private String advContext = "国庆抽奖活动通知：只要刷卡就送你一百万！...";
    /**
     * 功能描述:
     * 取得广告信的名称
     *
     * @author: liwenyi
     */
    public String getAdvSubject(){
        return this.advSubject;
    }
    /**
     * 功能描述:
     * 取得广告信的内容
     *
     * @return: java.lang.String
     * @author: liwenyi
     */
    public String getAdvContext(){
        return this.advContext;
    }
}
