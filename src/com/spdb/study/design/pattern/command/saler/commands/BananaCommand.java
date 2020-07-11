package com.spdb.study.design.pattern.command.saler.commands;

import com.spdb.study.design.pattern.command.saler.Command;
import com.spdb.study.design.pattern.command.saler.Saler;

/**
 * @author Mr.Longyx
 * @date 2020年07月11日 16:23
 */
public class BananaCommand extends Command {

    public BananaCommand(Saler saler) {
        super(saler);
    }

    @Override
    public void sell() {
        this.getSaler().sailBanana();
    }
}
