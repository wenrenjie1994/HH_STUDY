package com.longyx.study.design.pattern.command.player;

import com.longyx.study.design.pattern.command.player.actions.PauseAction;
import com.longyx.study.design.pattern.command.player.actions.PlayAction;
import com.longyx.study.design.pattern.command.player.actions.SpeedAction;
import com.longyx.study.design.pattern.command.player.actions.StopAction;

/**
 * @author Mr.Longyx
 * @date 2020年07月11日 15:16
 */
public class Test {
    public static void main(String[] args) {
        Player player = new Player();
        Controller controller = new Controller();

        controller.execute(new SpeedAction(player));

        controller.addAction(new PauseAction(player));
        controller.addAction(new PlayAction(player));
        controller.addAction(new SpeedAction(player));
        controller.addAction(new StopAction(player));

        controller.executes();
    }
}
