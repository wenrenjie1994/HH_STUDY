package com.spdb.study.design.pattern.adapter.poweradapter;

/**
 * @author Mr.Longyx
 * @date 2020年07月02日 15:57
 */
public class PowerAdapterTest {
    public static void main(String[] args) {
        DC5 dc5 = new PowerAdapter(new AC220());
        dc5.outputDC5();
    }
}
