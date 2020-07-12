package com.spdb.study.design.pattern.mediator.match;

/**
 * 同事类
 * @author Mr.Longyx
 * @date 2020年07月12日 15:56
 */
public abstract class Colleague {

    private String name;
    /**
     * 匹配指数
     * @author Mr.Longyx
     * @date 2020/7/12 15:57
     */
    private int condition;

    private Meditor meditor;

    public Colleague(String name, int condition, Meditor meditor) {
        this.name = name;
        this.condition = condition;
        this.meditor = meditor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCondition() {
        return condition;
    }


    public Meditor getMeditor() {
        return meditor;
    }

    public void setMeditor(Meditor meditor) {
        this.meditor = meditor;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", condition='" + condition + '\'' +
                ", meditor=" + meditor +
                '}';
    }

    /**
     * 找对象细节由子类实现
     * @author Mr.Longyx
     * @date 2020/7/12 16:01
     * @param colleague
     */
    public abstract void findTheHalf(Colleague colleague);

}
