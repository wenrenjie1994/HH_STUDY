package com.spdb.user;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public class GamePlayerProxy implements IGamePlayer {

    private IGamePlayer gamePlayer = null;
    /**
     * 功能描述:
     * 通过构造函数传递要对谁进行代练
     *
     * @param _gamePlayer 1
     * @return:
     * @author: liwenyi
     */
    public GamePlayerProxy(IGamePlayer _gamePlayer){
        this.gamePlayer = _gamePlayer;
    }

    @Override
    public void login(String user, String password) {
        this.gamePlayer.login(user, password);
    }

    @Override
    public void killBoss() {
        this.gamePlayer.killBoss();
    }

    @Override
    public void upgrade() {
        this.gamePlayer.upgrade();
    }
}
