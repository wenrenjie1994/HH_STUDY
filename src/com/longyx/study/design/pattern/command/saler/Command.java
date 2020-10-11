package com.longyx.study.design.pattern.command.saler;

/**
 * @author Mr.Longyx
 * @date 2020年07月11日 16:06
 */
public abstract class Command {
    private Saler saler;

    public Command(Saler saler) {
        this.saler = saler;
    }

    public Saler getSaler() {
        return saler;
    }

    public abstract void sell();
}
