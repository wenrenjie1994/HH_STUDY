package com.spdb;

import com.spdb.user.IUserInfo;
import com.spdb.user.OuterUserInfo;

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
