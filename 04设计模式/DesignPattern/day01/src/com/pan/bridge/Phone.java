package com.pan.bridge;

public abstract class Phone {

    //1.聚合Brand接口，怎么实现？
    private Brand brand;
    // 在构造器中加入
    public Phone(Brand brand) {
        this.brand = brand;
    }

    protected void open(){
        this.brand.open();
    }

    protected void close(){
        this.brand.call();
    }

    protected void call(){
        this.brand.call();
    }


}
