package com.cuit.model;

import java.util.ArrayList;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public abstract class CarModel {
    private ArrayList<String> sequence = new ArrayList<String>();

    /**
     * 功能描述:
     * 模型是启动开始跑了
     *
     * @return: void
     * @author: liwenyi
     */
    protected abstract void start();

    /**
     * 功能描述:
     * 能发动，还要能停下来，那才是真本事
     *
     * @return: void
     * @author: liwenyi
     */
    protected abstract void stop();

    /**
     * 功能描述:
     * 喇叭会出声音，是滴滴叫，还是哔哔叫
     *
     * @return: void
     * @author: liwenyi
     */
    protected abstract void alarm();

    /**
     * 功能描述:
     * 引擎会轰隆隆地响，不响那是假的
     *
     * @return: void
     * @author: liwenyi
     */
    protected abstract void engineBoom();

    /**
     * 功能描述:
     * 那模型应该会跑吧，别管是人推的，还是电力驱动，总之要会跑
     *
     * @return: void
     * @author: liwenyi
     */
    final public void run() {
        //循环一边，谁在前，就先执行谁
        for(int i=0;i<this.sequence.size();i++){
            String actionName = this.sequence.get(i);
            if(actionName.equalsIgnoreCase("start")){
                this.start(); //启动汽车
            }else if(actionName.equalsIgnoreCase("stop")){
                this.stop(); //停止汽车
            }else if(actionName.equalsIgnoreCase("alarm")){
                this.alarm(); //喇叭开始叫了
            }else if(actionName.equalsIgnoreCase("engine boom")){
                //如果是engine boom关键
                this.engineBoom(); //引擎开始轰鸣
            }
        }
    }

    /**
     * 功能描述:
     * 把传递过来的值传递到类内
     *
     * @param sequence 1
     * @return: void
     * @author: liwenyi
     */
    final public void setSequence(ArrayList sequence){
        this.sequence = sequence;
    }
}
