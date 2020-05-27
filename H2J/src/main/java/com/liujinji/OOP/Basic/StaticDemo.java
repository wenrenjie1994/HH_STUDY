package com.liujinji.OOP.Basic;

public class StaticDemo {
    public static String name = "kevin";
// 被 static 修饰的方法是静态方法，静态方法不依赖于对象，
// 不需要将类实例化便可以调用，由于不实例化也可以调用，
// 所以不能有 this，也不能访问非静态成员变量和非静态方法。
// 但是非静态成员变量和非静态方法可以访问静态方法。

    public final static String STATIC_STRING="kevin";

//  final 关键字可以修饰类、方法、属性和变量
//  final 修饰类，则该类不允许被继承，为最终类
//  final 修饰方法，则该方法不允许被覆盖（重写）
//  final 修饰属性：则该类的属性不会进行隐式的初始化（类的初始化属性必须有值）或在构造方法中赋值（但只能选其一）
//  final 修饰变量，则该变量的值只能赋一次值，即常量
}


