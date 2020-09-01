package com.cuit.observer;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public class LiuSi implements Observer {
    @Override
    public void update(String context) {
        System.out.println("刘斯：观察到韩非子活动，开始动作了...");
        this.happy(context);
        System.out.println("刘斯：乐死了\n");
    }

    /**
     * 功能描述:
     * 一看韩非子有变化，他就快乐
     *
     * @param context 1
     * @return: void
     * @author: liwenyi
     */
    private void happy(String context){
        System.out.println("刘斯：因为" +context+",--所以我快乐呀！" );
    }
}
