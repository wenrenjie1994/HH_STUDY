package com.spdb.study.design.pattern.builder.simple;

/**
 * 建造公寓
 * @author Mr.Longyx
 * @date 2020年07月05日 10:02
 */
public class ApartmentBuilder implements Builder{
    /**
     * 持有Building这个建房工具箱
     * @author Mr.Longyx
     * @date 2020/7/5 10:03
     */
    private Building apartment;

    public ApartmentBuilder() {
        apartment = new Building();
    }

    @Override
    public void buildBasement() {
        System.out.println("深挖地基，修建地下车库，部署管道、线缆、风道。");
        apartment.setBasement("╚═════════╝\n");
    }

    @Override
    public void buildWall() {
        System.out.println("搭建多层建筑框架，建造电梯井，钢筋混凝土浇灌。");
        /**
         * 假设修建10个楼层的公寓
         * @author Mr.Longyx
         * @date 2020/7/5 10:09
         */
        for(int i=0;i<10;i++){
            apartment.setWall("║ □ □ □ □ ║\n");
        }

    }

    @Override
    public void buildRoof() {
        System.out.println("封顶，部署通风井，做防水层，保温层。");
        apartment.setRoof("╔═════════╗\n");
    }

    @Override
    public Building getBuilding() {
        return apartment;
    }
}
