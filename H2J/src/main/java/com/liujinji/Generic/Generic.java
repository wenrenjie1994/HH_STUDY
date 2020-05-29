package com.liujinji.Generic;

public class Generic<T> {
    private T ob;
    public Generic(T ob){
        this.ob=ob;
    }
    public T getOb(){
        return ob;
    }

    public void setOb(T ob) {
        this.ob = ob;
    }
    public void showType(){
        System.out.println("T 的实际类型是: "+ob.getClass().getName());
    }
}
