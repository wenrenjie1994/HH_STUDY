package com.longyx.study.design.pattern.mediator.chatroom;

/**
 * @author Mr.Longyx
 * @date 2020年07月12日 14:57
 */
public class ChatRoom {
    public void showMessage(User user, String msg){
        System.out.println("【"+user.getName()+"】："+msg);
    }
}
