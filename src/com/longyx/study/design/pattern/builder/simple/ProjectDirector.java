package com.spdb.study.design.pattern.builder.simple;

/**
 * 将建房交给工程队去指导完成
 * @author Mr.Longyx
 * @date 2020年07月05日 10:38
 */
public class ProjectDirector {

    private Builder builder;

    public ProjectDirector(Builder builder) {
        this.builder = builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    /**
     * 对建房细节进行封装
     * @author Mr.Longyx
     * @date 2020/7/5 10:43
     */
    public Building direct(){
        System.out.println("========工程项目启动========");
        /**
         * 1、打好地基
         * @author Mr.Longyx
         * @date 2020/7/5 10:44
         * @return com.spdb.study.design.pattern.builder.simple.Building
         */
        builder.buildBasement();
        /**
         * 2、建造墙体
         * @author Mr.Longyx
         * @date 2020/7/5 10:45
         * @return com.spdb.study.design.pattern.builder.simple.Building
         */
        builder.buildWall();
        /**
         * 封顶
         * @author Mr.Longyx
         * @date 2020/7/5 10:46
         * @return com.spdb.study.design.pattern.builder.simple.Building
         */
        builder.buildRoof();

        System.out.println("=======工程项目竣工========");

        return builder.getBuilding();
    }
}
