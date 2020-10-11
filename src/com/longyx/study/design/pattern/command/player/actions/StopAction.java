package com.longyx.study.design.pattern.command.player.actions;

import com.longyx.study.design.pattern.command.player.Action;
import com.longyx.study.design.pattern.command.player.Player;

/**
 * @author Mr.Longyx
 * @date 2020年07月11日 15:09
 */
public class StopAction implements Action {
    private Player player;

    public StopAction(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.stop();
    }
}
