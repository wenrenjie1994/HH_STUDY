package com.lihang.base.lambda;

import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: LI
 * Date: 2020/5/27
 */
public class TestFunctionInterface {
    @Test
    public void test(){

       func((x)-> System.out.println("world"+x));

    }
    private void func(FunctionInterface<Integer> functionInterface){
        int x = 1;
        functionInterface.test(x);
    }
}
