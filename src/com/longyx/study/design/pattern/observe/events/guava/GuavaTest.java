package com.spdb.study.design.pattern.observe.events.guava;

import com.google.common.eventbus.EventBus;

/**
 * @author Mr.Longyx
 * @date 2020年07月03日 19:36
 */
public class GuavaTest {
    public static void main(String[] args) {
        EventBus bus = new EventBus();
        GuavaEvent event = new GuavaEvent();
        bus.register(event);
        bus.post("Komi");

    }
}
