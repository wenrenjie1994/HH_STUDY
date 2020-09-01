package com.spdb.study.design.pattern.observe.events.mouseevent;

import com.spdb.study.design.pattern.observe.events.core.Event;

/**
 * 鼠标点击事件回调处理
 * @author Mr.Longyx
 * @date 2020年07月03日 19:12
 */
public class MouseEventCallBack {

    public void onClick(Event event){
        System.out.println("===========触发鼠标单击事件==========" + "\n" + event);
    }

    public void onDoubleClick(Event event){
        System.out.println("===========触发鼠标双击事件==========" + "\n" + event);
    }

    public void onUp(Event event){
        System.out.println("===========触发鼠标弹起事件==========" + "\n" + event);
    }

    public void onDown(Event event){
        System.out.println("===========触发鼠标按下事件==========" + "\n" + event);
    }

    public void onMove(Event event){
        System.out.println("===========触发鼠标移动事件==========" + "\n" + event);
    }

    public void onWheel(Event event){
        System.out.println("===========触发鼠标滚动事件==========" + "\n" + event);
    }

    public void onOver(Event event){
        System.out.println("===========触发鼠标悬停事件==========" + "\n" + event);
    }

    public void onBlur(Event event){
        System.out.println("===========触发鼠标失焦事件==========" + "\n" + event);
    }

    public void onFocus(Event event){
        System.out.println("===========触发鼠标获焦事件==========" + "\n" + event);
    }
}
