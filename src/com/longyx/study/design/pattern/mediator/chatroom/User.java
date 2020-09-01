package com.spdb.study.design.pattern.mediator.chatroom;

import java.io.Serializable;

/**
 * @author Mr.Longyx
 * @date 2020年07月12日 14:57
 */
public class User implements Serializable {
    private static final long serialVersionUID = 2476853735151158950L;

    private ChatRoom chatRoom;
    private String name;

    public User(String name,ChatRoom chatRoom) {
        this.name = name;
        this.chatRoom = chatRoom;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String msg){
        this.chatRoom.showMessage(this,msg);
    }
}
