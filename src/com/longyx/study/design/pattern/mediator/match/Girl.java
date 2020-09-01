package com.spdb.study.design.pattern.mediator.match;

/**
 * @author Mr.Longyx
 * @date 2020年07月12日 16:03
 */
public class Girl extends Colleague {
    public Girl(String name, int condition, Meditor meditor) {
        super(name, condition, meditor);
    }

    @Override
    public void findTheHalf(Colleague colleague) {
        this.getMeditor().setGirl(this);
        this.getMeditor().findTheHalf(colleague);
    }
}
