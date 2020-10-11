package com.longyx.study.design.pattern.facade.points;

/**
 * 模拟通过积分抵扣礼品
 * @author Mr.Longyx
 * @date 2020年07月05日 19:35
 */
public class GiftInfo {
    private String name;

    public GiftInfo(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
