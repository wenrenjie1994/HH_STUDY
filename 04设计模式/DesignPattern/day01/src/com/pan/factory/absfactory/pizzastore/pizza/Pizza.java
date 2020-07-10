package com.pan.factory.absfactory.pizzastore.pizza;

//做成抽象的
public abstract class Pizza {
    protected String name;

    //不同披萨准备的原材料不同，所以做成抽象方法
    public abstract void prepare();

    public void bake() {
        System.out.println(name + " baking;");
    }

    public void cut() {
        System.out.println(name + " cutting;");
    }

    public void box() {
        System.out.println(name + " boxing;");
    }

    public void setName(String name) {
        this.name = name;
    }
}

