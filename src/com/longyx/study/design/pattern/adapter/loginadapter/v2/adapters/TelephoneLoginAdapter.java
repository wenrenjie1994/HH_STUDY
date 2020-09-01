package com.spdb.study.design.pattern.adapter.loginadapter.v2.adapters;

import com.spdb.study.design.pattern.adapter.loginadapter.ResultMsg;

/**
 * @author Mr.Longyx
 * @date 2020年07月02日 17:05
 */
public class TelephoneLoginAdapter implements LoginAdapter {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof TelephoneLoginAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
