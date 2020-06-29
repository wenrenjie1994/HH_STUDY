package com.spdb.study.design.principle.liskosubstitution.abstracted;

/**
 * @author Mr.Longyx
 * @date 2020年06月17日 21:27
 */
public class Square implements QuadRangle {

    private Long sideLength;

    public Long getSideLength() {
        return sideLength;
    }

    public void setSideLength(Long sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public Long getWidth() {
        return sideLength;
    }

    @Override
    public Long getHeight() {
        return sideLength;
    }
}
