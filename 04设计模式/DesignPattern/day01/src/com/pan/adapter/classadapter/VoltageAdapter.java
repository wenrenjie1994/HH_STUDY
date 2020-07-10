package com.pan.adapter.classadapter;

public class VoltageAdapter extends Voltage220V implements Voltage5V{

    @Override
    public int output5V() {
        //先获取到220V的电压
        int srcV = output220V();
        int dstV = srcV/44;//转成5V
        return dstV;
    }
}
