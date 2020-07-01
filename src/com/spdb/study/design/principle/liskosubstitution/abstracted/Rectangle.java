package com.spdb.study.design.principle.liskosubstitution.abstracted;

/**
 * @author Mr.Longyx
 * @date 2020年06月17日 21:27
 */
public class Rectangle implements QuadRangle {
    private Long width;
    private Long height;

    public void setWidth(Long width) {
        this.width = width;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    @Override
    public Long getWidth() {
        return width;
    }

    @Override
    public Long getHeight() {
        return height;
    }
}
