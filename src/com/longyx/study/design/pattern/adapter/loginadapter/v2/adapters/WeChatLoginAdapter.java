package com.spdb.study.design.pattern.adapter.loginadapter.v2.adapters;

import com.spdb.study.design.pattern.adapter.loginadapter.ResultMsg;

/**
 * @author Mr.Longyx
 * @date 2020年07月02日 16:51
 */
public class WeChatLoginAdapter implements LoginAdapter{

    @Override
    public boolean support(Object adapter) {
        return adapter instanceof WeChatLoginAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
