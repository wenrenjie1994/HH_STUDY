package com.spdb.study.design.pattern.adapter.loginadapter.v1.service;

import com.spdb.study.design.pattern.adapter.loginadapter.ResultMsg;
import com.spdb.study.design.pattern.adapter.loginadapter.User;

/**
 * @author Mr.Longyx
 * @date 2020年07月02日 16:27
 */
public class SiginService {
    /**
     * 注册方法
     * @author Mr.Longyx
     * @date 2020/7/2 16:31
     * @param username
     * @param password
     * @return com.spdb.study.design.pattern.adapter.loginadapter.ResultMsg
     */
    public ResultMsg regist(String username,String password){
        return new ResultMsg(200,"注册成功",new User());
    }

    /**
     * 登陆方法·
     * @author Mr.Longyx
     * @date 2020/7/2 16:32
     * @param username
     * @param password
     * @return com.spdb.study.design.pattern.adapter.loginadapter.ResultMsg
     */
    public ResultMsg login(String username, String password){
        return new ResultMsg(200,"登录成功",new User());
    }
}
