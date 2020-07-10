package com.pan.prototype.improve.deepclone;

import java.io.Serializable;

public class DeepCloneableTarget implements Serializable,Cloneable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String cloneName;

    private String cloneClass;

    //构造器
    public DeepCloneableTarget(String cloneName, String cloneClass) {
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }

    //该类的属性都是 String，使用默认的clone（）即可
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
