package com.liujinji.Generic;

import org.junit.Test;

import static org.junit.Assert.*;

public class GenericTest {
    @Test
    public void test(){
        Generic<Integer> intOb=new Generic<Integer>(88);
        intOb.showType();

        Generic<String> stringOb=new Generic<String>("Hello");
        stringOb.showType();
    }
}