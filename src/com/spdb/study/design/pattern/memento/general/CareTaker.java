package com.spdb.study.design.pattern.memento.general;

/**
 * @author Mr.Longyx
 * @date 2020年07月11日 22:45
 */
public class CareTaker {
    /**
     * 备忘录对象
     * @author Mr.Longyx
     * @date 2020/7/11 22:45
     */
    private Memento memento;

    public Memento getMemento(){
        return this.memento;
    }

    public void storeMemento(Memento memento) {
        this.memento = memento;
    }
}
