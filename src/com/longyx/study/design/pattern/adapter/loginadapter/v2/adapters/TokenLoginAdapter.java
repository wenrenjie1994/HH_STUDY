package com.longyx.study.design.pattern.adapter.loginadapter.v2.adapters;

import com.longyx.study.design.pattern.adapter.loginadapter.ResultMsg;

/**
 * @author Mr.Longyx
 * @date 2020年07月02日 16:53
 */
public class TokenLoginAdapter implements LoginAdapter{
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof TokenLoginAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
