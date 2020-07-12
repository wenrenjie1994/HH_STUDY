package com.spdb.study.design.pattern.memento.editor;

import com.spdb.study.design.pattern.memento.general.CareTaker;

import java.io.Serializable;

/**
 * 发起人的角色
 * @author Mr.Longyx
 * @date 2020年07月12日 8:47
 */
public class Editor implements Serializable {
    private static final long serialVersionUID = -743950514553910917L;
    private String title;
    private String content;
    private String imgs;

    public Editor(String title, String content, String imgs) {
        this.title = title;
        this.content = content;
        this.imgs = imgs;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public String getContent() {
        return content;
    }

    public String getImgs() {
        return imgs;
    }

    public ArticleMemento save2Memento(){
        ArticleMemento memento = new ArticleMemento(this.title,this.content,this.imgs);
        return memento;
    }

    public void undoFromMemento(ArticleMemento memento){
        this.title = memento.getTitle();
        this.content = memento.getContent();
        this.imgs = memento.getImgs();
    }

    @Override
    public String toString() {
        return "Editor{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", imgs='" + imgs + '\'' +
                '}';
    }
}
