package com.spdb.study.design.principle.responsibility.simple;

/**
 * 单一职责原则：不要存在多于一个导致类变更的原因
 * 一个类、接口、方法只负责一项职责
 * @author Mr.Longyx
 * @date 2020年06月17日 14:16
 */
public class  Course {
    /**
     * 需要抽离职责的方法
     * @author Mr.Longyx
     * @date 2020/6/17 14:25
     * @param courseName
     */
    public void study(String courseName){
        if ("直播课".equals(courseName)){
            System.out.println("不能快进!");
        }else {
            System.out.println("可以任意的来回播放");
        }
    }
}
