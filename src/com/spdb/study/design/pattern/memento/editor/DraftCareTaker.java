package com.spdb.study.design.pattern.memento.editor;

import java.util.Stack;

/**
 * 草稿箱：负责管理备忘录
 * @author Mr.Longyx
 * @date 2020年07月12日 8:51
 */
public class DraftCareTaker {
    private final Stack<ArticleMemento> STACK = new Stack<>();

    public void addMemento(ArticleMemento memento){
        STACK.push(memento);
    }

    public ArticleMemento getMemento(){
        ArticleMemento memento = STACK.pop();
        return memento;
    }
}
