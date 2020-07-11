package com.spdb.study.design.pattern.command.saler.commands;

import com.spdb.study.design.pattern.command.saler.Command;
import com.spdb.study.design.pattern.command.saler.Saler;

/**
 * @author Mr.Longyx
 * @date 2020年07月11日 16:25
 */
public class OrangeCommand extends Command {
    public OrangeCommand(Saler saler) {
        super(saler);
    }

    @Override
    public void sell() {
        this.getSaler().sailOrange();
    }
}
