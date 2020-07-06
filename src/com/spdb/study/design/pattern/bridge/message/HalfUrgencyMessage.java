package com.spdb.study.design.pattern.bridge.message;

/**
 * @author Mr.Longyx
 * @date 2020年07月06日 17:47
 */
public class HalfUrgencyMessage extends AbstractMessage {
    public HalfUrgencyMessage(Message message) {
        super(message);
    }
}
