package com.longyx.study.design.pattern.observe.events.core;

import java.lang.reflect.Method;

/**
 * @author Mr.Longyx
 * @date 2020年07月03日 15:09
 */
public class Event {
    /**
     * 保存事件发生的源头
     */
    private Object source;
    /**
     * 事件触发，即需要通知的对象
     */
    private Object target;
    /**
     * 回调需要处理的动作
     */
    private Method callback;
    /**
     * 事件名称
     */
    private String trigger;
    /**
     * 事件触发的时间
     */
    private Long time;

    public Event(Object target, Method callback) {
        this.target = target;
        this.callback = callback;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Method getCallback() {
        return callback;
    }

    public void setCallback(Method callback) {
        this.callback = callback;
    }

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Event{" + "\n" +
                "\tsource=" + source.getClass() + ",\n" +
                "\ttarget=" + target.getClass() + ",\n" +
                "\tcallback=" + callback + ",\n" +
                "\ttrigger='" + trigger + "',\n" +
                "\ttime='" + time + "'\n" +
                '}';
    }
}
