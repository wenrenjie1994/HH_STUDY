package com.spdb.study.design.pattern.builder.simple;

/**
 * 顶层设计  建造者模式
 * @author Mr.Longyx
 * @date 2020年07月05日 9:39
 */
public interface Builder {
    /**
     * 建造地基
     * @author Mr.Longyx
     * @date 2020/7/5 9:40
     */
    void buildBasement();
    /**
     * 建造墙体
     * @author Mr.Longyx
     * @date 2020/7/5 9:41
     */
    void buildWall();
    /**
     * 建造屋顶
     * @author Mr.Longyx
     * @date 2020/7/5 9:41
     */
    void buildRoof();

    /**
     * 获取建造好的房子
     * @author Mr.Longyx
     * @date 2020/7/5 9:43
     */
    Building getBuilding();
}
