package com.spdb.study.design.pattern.state.general.simple;

/**
 * 具体A状态
 * @author Mr.Longyx
 * @date 2020年07月11日 17:53
 */
public class ConcreteStateA implements State{
    /**
     * 必要时刻进行状态切换
     * @author Mr.Longyx
     * @date 2020/7/11 17:54
     */
    @Override
    public void handle() {
        System.out.println("状态A");
    }
}
