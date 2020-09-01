package com.spdb.study.design.pattern.bridge.message;

/**
 * @author Mr.Longyx
 * @date 2020年07月06日 17:46
 */
public class UrgencyMessage extends AbstractMessage{

    public UrgencyMessage(Message message) {
        super(message);
    }

    @Override
    public void sendMessage(String message, String to) {
        message = "【加急】"+ message;
        super.sendMessage(message,to);
    }

    public Object watch(String messageId) {
        return null;
    }
}
