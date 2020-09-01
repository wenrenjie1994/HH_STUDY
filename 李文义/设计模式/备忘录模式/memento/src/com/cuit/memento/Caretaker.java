package com.cuit.memento;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc 备忘录管理者类
 */
public class Caretaker {
    /**
     * 功能描述:
     * 备忘录对象
     *
     * @author: liwenyi
     */
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
