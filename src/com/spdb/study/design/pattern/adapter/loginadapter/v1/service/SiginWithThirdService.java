package com.spdb.study.design.pattern.adapter.loginadapter.v1.service;

import com.spdb.study.design.pattern.adapter.loginadapter.ResultMsg;

/**
 * 第三方形式
 * @author Mr.Longyx
 * @date 2020年07月02日 16:33
 */
public class SiginWithThirdService extends SiginService {
    public ResultMsg loginWithQQ(String openId){
        return loginWithRegist(openId,null);
    }

    public ResultMsg loginWithToken(String token){
        return null;
    }

    public ResultMsg loginWithTelephone(String telephone,String code){
        return null;
    }
    public ResultMsg loginWithRegist(String username,String password){
        super.regist(username,null);
        return super.login(username,null);
    }
}
