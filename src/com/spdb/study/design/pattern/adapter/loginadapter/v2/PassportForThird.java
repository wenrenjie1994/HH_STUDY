package com.spdb.study.design.pattern.adapter.loginadapter.v2;

import com.spdb.study.design.pattern.adapter.loginadapter.ResultMsg;

/**
 * 仅进行扩展的接口
 * @author Mr.Longyx
 * @date 2020年07月02日 16:43
 */
public interface PassportForThird {
    /**
     * QQ登录
     * @param id
     */
    ResultMsg loginForQQ(String id);

    /**
     * 微信登录
     * @param id
     */
    ResultMsg loginForWechat(String id);

    /**
     * 记住登录状态后自动登录
     * @param token
     */
    ResultMsg loginForToken(String token);

    /**
     * 手机号登录
     * @param telphone
     * @param code
     */
    ResultMsg loginForTelphone(String telphone, String code);

    /**
     * 新浪的方式登陆
     * @author Mr.Longyx
     * @date 2020/7/2 20:38
     * @param id
     * @return com.spdb.study.design.pattern.adapter.loginadapter.ResultMsg
     */
    ResultMsg loginForSina(String id);

    /**
     * 注册后自动登录
     * @param username
     * @param passport
     */
    ResultMsg loginForRegist(String username, String passport);
}
