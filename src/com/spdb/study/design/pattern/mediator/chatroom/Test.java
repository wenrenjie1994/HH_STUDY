package com.spdb.study.design.pattern.mediator.chatroom;

/**
 * @author Mr.Longyx
 * @date 2020年07月12日 15:02
 */
public class Test {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();

        User komi = new User("Komi",chatRoom);
        User michael = new User("Michael",chatRoom);

        komi.sendMessage("hi, I'm Komi");
        michael.sendMessage("hello, My name is michael");
    }
}
