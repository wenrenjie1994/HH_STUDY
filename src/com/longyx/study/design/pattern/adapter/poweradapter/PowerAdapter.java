package com.longyx.study.design.pattern.adapter.poweradapter;

/**
 * @author Mr.Longyx
 * @date 2020年07月02日 15:54
 */
public class PowerAdapter implements DC5 {
    private AC220 ac220;

    public PowerAdapter(AC220 ac220) {
        this.ac220 = ac220;
    }

    @Override
    public int outputDC5() {
        int adapterInput = ac220.outputAC220();
        int adapterOutput = adapterInput / 44;
        System.out.println("输入交流电："+adapterInput+"V,通过适配器后输出电流："+adapterOutput+"V");
        return adapterOutput;
    }
}
