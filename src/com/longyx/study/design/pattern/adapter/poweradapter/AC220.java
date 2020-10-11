package com.longyx.study.design.pattern.adapter.poweradapter;

/**
 * 交流220V
 * @author Mr.Longyx
 * @date 2020年07月02日 15:47
 */
public class AC220 {
    public int outputAC220(){
        int output = 220;
        System.out.println("输出电流："+output);
        return output;
    }
}
