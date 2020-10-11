package com.longyx.study.design.pattern.observe.events.core;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 事件监听器，即观察者
 * @author Mr.Longyx
 * @date 2020年07月03日 17:33
 */
public class EventListener {
    protected Map<String, Event> events = new HashMap<>();

    /**
     * 根据事件名称和目标对象触发事件
     */
    public void addListener(String eventType, Object target){
        try {
            this.addListener(eventType, target, target.getClass().getMethod("on"+toUpperFirstCase(eventType),Event.class));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addListener(String eventType, Object target, Method callback){
        //注册事件
        events.put(eventType, new Event(target, callback));
    }

    /**
     * 一有动作就触发事件
     * @author Mr.Longyx
     * @date 2020/7/3 18:19
     */
    private void trigger(Event event){
        event.setSource(this);
        event.setTime(System.currentTimeMillis());

        try {
            //发起回调(反射)
            if (event.getCallback() != null){
                event.getCallback().invoke(event.getTarget(),event);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 根据事件名称触发事件
     * @author Mr.Longyx
     * @date 2020/7/3 18:23
     */
    protected void trigger(String trigger){
        if (!this.events.containsKey(trigger)){
            return;
        }
        this.events.get(trigger).setTrigger(trigger);
        trigger(events.get(trigger));
    }

    private String toUpperFirstCase(String eventType) {
        char[] chs = eventType.toCharArray();
        chs[0] -= 32;
        return String.valueOf(chs);
    }
}
