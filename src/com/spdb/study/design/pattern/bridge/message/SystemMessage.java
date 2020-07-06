package com.spdb.study.design.pattern.bridge.message;

/**
 * @author Mr.Longyx
 * @date 2020年07月06日 17:44
 */
public class SystemMessage extends AbstractMessage {
    public SystemMessage(Message message) {
        super(message);
    }

    @Override
    public void sendMessage(String message, String to) {
        System.out.println("系统内部发送"+message +"消息至"+to);
    }
}
