package com.longyx.study.design.pattern.command.player;

/**
 * @author Mr.Longyx
 * @date 2020年07月11日 14:57
 */
public class Player {

    public void play(){
        System.out.println("正常播放");
    }

    public void speed(){
        System.out.println("加速播放");
    }

    public void pause(){
        System.out.println("暂停播放");
    }

    public void stop(){
        System.out.println("停止播放");
    }
}
