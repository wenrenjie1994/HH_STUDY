package com.longyx.study.design.pattern.memento.general;

/**
 * 备忘录模式的适用场景：
 * 1、需要保存历史快照的场景
 * 2、希望在对象之外保存状态，且除了自己其他类对象无法访问状态保存的具体内容
 * 优点：
 * 1、简化发起人实体类的职责，隔离状态存储与获取，实现了信息的封装，客户端无需关心状态的保存细节
 * 2、提供状态回滚功能
 * 缺点:
 * 1、消耗资源：如果需要保存的状态过多时，每一次保存都会消耗很多内存。
 * @author Mr.Longyx
 * @date 2020年07月11日 22:26
 */
public class Memento {
    private String state;

    public Memento(String state){
        this.state = state;
    }

    public String getState(){
        return this.state;
    }

    public void setState(String state){
        this.state = state;
    }
}
