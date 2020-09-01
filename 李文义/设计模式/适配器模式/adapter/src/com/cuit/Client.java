package com.cuit;

import com.cuit.user.IUserInfo;
import com.cuit.user.OuterUserInfo;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public class Client {
    public static void main(String[] args) {
        //没有与外系统连接的时候，是这样写的
        IUserInfo youngGirl = new OuterUserInfo();
        youngGirl.getUserName();
    }
}
