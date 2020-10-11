package com.longyx.study.design.pattern.adapter.loginadapter.v2.adapters;

import com.longyx.study.design.pattern.adapter.loginadapter.ResultMsg;

/**
 * 在适配器里面，这个接口可有可无
 * @author Mr.Longyx
 * @date 2020年07月02日 16:47
 */
public interface LoginAdapter {
    boolean support(Object adapter);

    ResultMsg login(String id, Object adapter);
}
