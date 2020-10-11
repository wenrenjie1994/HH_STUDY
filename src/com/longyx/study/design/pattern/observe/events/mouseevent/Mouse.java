package com.longyx.study.design.pattern.observe.events.mouseevent;

import com.longyx.study.design.pattern.observe.events.core.EventListener;

/**
 * @author Mr.Longyx
 * @date 2020年07月03日 18:54
 */
public class Mouse extends EventListener {

    public void click(){
        System.out.println("调用单击方法");
        this.trigger(MouseEventType.ON_CLICK);
    }

    public void doubleClick(){
        System.out.println("调用双击方法");
        this.trigger(MouseEventType.ON_DOUBLE_CLICK);
    }

    public void up(){
        System.out.println("调用弹起方法");
        this.trigger(MouseEventType.ON_UP);
    }

    public void down(){
        System.out.println("调用按下方法");
        this.trigger(MouseEventType.ON_DOWN);
    }

    public void move(){
        System.out.println("调用移动方法");
        this.trigger(MouseEventType.ON_MOVE);
    }

    public void wheel(){
        System.out.println("调用滚动方法");
        this.trigger(MouseEventType.ON_WHEEL);
    }

    public void over(){
        System.out.println("调用悬停方法");
        this.trigger(MouseEventType.ON_OVER);
    }

    public void blur(){
        System.out.println("调用获焦方法");
        this.trigger(MouseEventType.ON_BLUR);
    }

    public void focus(){
        System.out.println("调用失焦方法");
        this.trigger(MouseEventType.ON_FOCUS);
    }
}
