package com.spdb.study.design.pattern.bridge.message;

/**
 * @author Mr.Longyx
 * @date 2020年07月06日 17:18
 */
public interface Message {
    /**
     * @author Mr.Longyx
     * @date 2020/7/6 17:19
     * @param message:消息内容
     * @param to:接收人
     */
    void sendMessage(String message, String to);
}
