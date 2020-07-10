package com.pan.adapter.objectadapter;

public class VoltageAdapter implements Voltage5V {

    private Voltage220V voltage220V;//关联关系中的聚合关系

    //通过构造器传入一个voltage220V实例
    public VoltageAdapter(Voltage220V voltage220V){
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
//        //先获取到220V的电压
//        int srcV = voltage220V.output220V();
//        int dstV = srcV/44;//转成5V
//        return dstV;
        int dst = 0;
        if(null != voltage220V){
            int src = voltage220V.output220V();//获取220V电压
            System.out.println("使用对象适配器，进行适配");
            dst = src/44;
            System.out.println("适配完成，输出的电压为="+dst);
        }
        return dst;

    }
}
