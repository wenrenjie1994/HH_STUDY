package com.spdb.study.design.pattern.prototype.deep;

import java.io.Serializable;

/**
 * 金箍棒实体类
 * @author Mr.Longyx
 * @date 2020年06月25日 23:36
 */
public class GoldenCudgel implements Serializable {

    public float h = 100;
    public float d = 20;

    public void bigger(){
        this.h *=2;
        this.d *= 2;
    }

    public void smaller(){
        this.h /= 2;
        this.d /= 2;
    }
}
