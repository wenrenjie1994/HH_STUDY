package com.cuit.observer;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public class WangSi implements Observer {
    @Override
    public void update(String context) {
        System.out.println("王斯：观察到韩非子活动，自己也开始活动了...");
        this.cry(context);
        System.out.println("王斯：哭死了...\n");
    }
    /**
     * 功能描述:
     * 一看韩非子有活动，他就痛哭
     *
     * @param context 1
     * @return: void
     * @author: liwenyi
     */
    private void cry(String context){
        System.out.println("王斯：因为"+context+"，--所以我悲伤呀！");
    }
}
