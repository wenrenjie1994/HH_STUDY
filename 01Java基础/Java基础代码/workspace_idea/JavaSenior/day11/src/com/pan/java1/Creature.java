package com.pan.java1;

import java.io.Serializable;

/**
 * @author zhaopan@163.com
 * @creat 2020-04-28 11:16
 */
public class Creature<T> implements Serializable {

    private char gender;
    public double weight;
    private void breath(){
        System.out.println("生物呼吸");
    }
    public void eat(){
        System.out.println("生物吃东西");
    }

}
