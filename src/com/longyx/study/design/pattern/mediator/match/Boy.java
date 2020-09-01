package com.spdb.study.design.pattern.mediator.match;

/**
 * @author Mr.Longyx
 * @date 2020年07月12日 16:02
 */
public class Boy extends Colleague {
    public Boy(String name, int condition, Meditor meditor) {
        super(name, condition, meditor);
    }


    @Override
    public void findTheHalf(Colleague colleague) {
        this.getMeditor().setBoy(this);
        this.getMeditor().findTheHalf(colleague);
    }
}
