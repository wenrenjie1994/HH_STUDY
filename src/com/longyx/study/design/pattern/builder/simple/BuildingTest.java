package com.spdb.study.design.pattern.builder.simple;

/**
 * @author Mr.Longyx
 * @date 2020年07月05日 10:11
 */
public class BuildingTest {
    public static void main(String[] args) {
        /**
         * 未引入工程队之前的建普通平房(建房逻辑还得交由用户，不友好，用户只需要提房即可，不需要关系建房细节)
         * Builder builder = new HouseBuilder(new Building());
         * builder.buildBasement();
         * builder.buildWall();
         * builder.buildRoof();
         *
         * System.out.println(builder.getBuilding());
         * @author Mr.Longyx
         * @date 2020/7/5 10:14
         */

        /**
         * 引入工程队后的建房
         * @author Mr.Longyx
         * @date 2020/7/5 10:47
         */

        //招工，建别墅
        Builder builder = new ApartmentBuilder();
        //交给工程总监
        ProjectDirector director = new ProjectDirector(builder);
        System.out.println(director.direct());

        //替换施工方案，建普通平房
        director.setBuilder(new HouseBuilder());
        System.out.println(director.direct());
    }
}
