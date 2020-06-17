package com.spdb.study.design.principle.liskosubstitution.simple;

/**
 * @author Mr.Longyx
 * @date 2020年06月17日 21:08
 */
public class Square extends Rectangle{
    private Long sideLength;

    public Long getSideLength() {
        return sideLength;
    }

    public void setSideLength(Long sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public Long getWidth() {
        return getSideLength();
    }

    @Override
    public void setWidth(Long width) {
        setSideLength(width);
    }

    @Override
    public Long getHeight() {
        return getSideLength();
    }

    @Override
    public void setHeight(Long height) {
        setSideLength(height);
    }
}
