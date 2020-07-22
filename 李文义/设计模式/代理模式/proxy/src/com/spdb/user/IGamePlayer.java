package com.spdb.user;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public interface IGamePlayer {
    /**
     * 功能描述:
     * 登录游戏
     *
     * @param user 1
     * @param password 2
     * @return: void
     * @author: liwenyi
     */
    public void login(String user,String password);
    /**
     * 功能描述:
     * 杀怪，网络游戏的主要特色
     *
     * @return: void
     * @author: liwenyi
     */
    public void killBoss();
    /**
     * 功能描述:
     * 升级
     *
     * @return: void
     * @author: liwenyi
     */
    public void upgrade();
}
