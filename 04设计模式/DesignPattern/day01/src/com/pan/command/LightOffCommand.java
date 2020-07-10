package com.pan.command;

public class LightOffCommand implements Command {

    //聚合LightReceiver
    LightReceiver light;

    //构造器，初始化light
    public LightOffCommand(LightReceiver light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
