package com.spdb.study.design.pattern.bridge.message;

/**
 * @author Mr.Longyx
 * @date 2020年07月06日 17:20
 */
public class EmailMessage implements Message {
    @Override
    public void sendMessage(String message, String to) {
        System.out.println("使用邮件发送"+message+"消息至"+to);
    }
}
