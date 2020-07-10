package com.pan.java;

/**
 * @author zhaopan@163.com
 * @creat 2020-04-19 15:16
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 spring = Season1.SPRING;
        System.out.println(spring);
    }
}


enum Season1{

    //1.提供当前枚举类的多个对象
    SPRING ("春天","春暖花开"),
    SUMMER ("夏天","夏日炎炎"),
    AUTUMN ("秋天","秋高气爽"),
    WINTER ("冬天","冰天雪地");

    //2.私有化类的构造器，并给对象属性赋值
    private final String seasonName;
    private final String seasonDesc;

    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //3.获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }
    public String getSeasonDesc() {
        return seasonDesc;
    }


}
