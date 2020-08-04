package fu.day04.demo13;
/*
接口当中也可以定义”成员变量“，但是必须使用 public static final三个关键字进行修饰
从效果上看，这其实就是接口的【常量】
格式：public static final 数据类型 常量名称 = 数据值

备注：一旦使用final关键字修饰，说明不可改变。

注意：
1.接口当中的常量。可以省略 public static final，注意：不写也照样是这样
 2.接口当中的常量，必须进行赋值，不能不赋值
 3.接口中常量的名称使用完全大写，使用下划线进行分割
 */

public interface MyInterfaceConst {
     //常量，一旦赋值，不可修改
    public static final int NUM=10;
}
