package com.longyx.study.design.pattern.command.player;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.Longyx
 * @date 2020年07月11日 15:15
 */
public class Controller {
        private List<Action> actionList = new ArrayList<>();

        public void addAction(Action action){
            actionList.add(action);
        }

        public void execute(Action action){
            action.execute();
        }

        public void executes(){
            for(Action action : actionList){
                action.execute();
            }
            actionList.clear();
        }
}
