package com.spdb.study.design.pattern.memento.general;

/**
 * @author Mr.Longyx
 * @date 2020年07月11日 22:41
 */
public class Originator {
    /**
     * 内部状态
     * @author Mr.Longyx
     * @date 2020/7/11 22:41
     */
    private String state;

    public String getState(String state){
        return this.state;
    }

    public void setState(String state){
        this.state = state;
    }

    /**
     * 创建一个备忘录
     * @author Mr.Longyx
     * @date 2020/7/11 22:42
     */
    public Memento createMemento(){
        return new Memento(this.state);
    }

    /**
     * 从备忘录中恢复
     * @author Mr.Longyx
     * @date 2020/7/11 22:43
     */
    public void restoreMemento(Memento memento) {
        this.setState(memento.getState());
    }
}
