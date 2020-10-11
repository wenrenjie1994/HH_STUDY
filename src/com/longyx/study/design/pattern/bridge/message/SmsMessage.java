package com.longyx.study.design.pattern.bridge.message;

/**
 * @author Mr.Longyx
 * @date 2020年07月06日 17:40
 */
public class SmsMessage implements Message {

    @Override
    public void sendMessage(String message, String to) {
        System.out.println("使用短信发送"+message+"消息至"+to);
    }
}
