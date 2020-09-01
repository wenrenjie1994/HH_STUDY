package com.spdb.study.design.pattern.observe.events.mouseevent;

/**
 * @author Mr.Longyx
 * @date 2020年07月03日 19:18
 */
public class MouseEventTest {
    public static void main(String[] args) {
        MouseEventCallBack callback = new MouseEventCallBack();
        Mouse mouse = new Mouse();

        mouse.addListener(MouseEventType.ON_CLICK, callback);
        mouse.addListener(MouseEventType.ON_WHEEL,callback);
        mouse.addListener(MouseEventType.ON_OVER, callback);

        mouse.click();
        mouse.wheel();
        mouse.over();
    }
}
