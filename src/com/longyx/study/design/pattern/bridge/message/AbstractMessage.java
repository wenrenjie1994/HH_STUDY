package com.longyx.study.design.pattern.bridge.message;

/**
 * @author Mr.Longyx
 * @date 2020年07月06日 17:49
 */
public abstract class AbstractMessage {
    private Message message;

    public AbstractMessage(Message message) {
        this.message = message;
    }

    public void sendMessage(String message, String to){
        this.message.sendMessage(message,to);
    }
}
