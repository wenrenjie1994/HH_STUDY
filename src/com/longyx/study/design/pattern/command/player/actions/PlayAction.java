package com.spdb.study.design.pattern.command.player.actions;

import com.spdb.study.design.pattern.command.player.Action;
import com.spdb.study.design.pattern.command.player.Player;

/**
 * @author Mr.Longyx
 * @date 2020年07月11日 15:09
 */
public class PlayAction implements Action {
    private Player player;

    public PlayAction(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.play();
    }
}
