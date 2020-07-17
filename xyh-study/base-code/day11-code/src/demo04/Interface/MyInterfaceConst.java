package demo04.Interface;
/*
接口当中也可以定义“成员变量”，但是必须使用public static final 三个关键字
从效果上看，就是接口中的【常量】
格式：
public static final 数据类型 常量名称=数据值
final关键字修饰，说明不可改变
备注：
1.接口当中的常量必须赋值，不赋值会报错
2.推荐接口中常量的名称，使用完全大写的字母，用下划线进行分隔。
* */
public interface MyInterfaceConst {
    //常量，一点赋值，不可以修改
    public static final int NUM=10;
    //可以省略 public static final，即默认为 public static final
    int NUM_OF_MY_CLASS=100;

}
