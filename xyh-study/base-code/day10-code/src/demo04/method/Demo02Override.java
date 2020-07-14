package demo04.method;
/*
一、继承中方法的覆盖重写（override）
概念：在继承关系中，方法的名称一样，参数列表一样
重写（Override）与重载的区别（Overload）
重写：方法名称一样，参数列表【一样】
重载：方法的名称一样，参数列表【不一样】
方法的覆盖重写特点：创建子类对象，则优先用子类方法
二、覆盖重写的注意事项：
1.必须保证父子类之间方法名称和参数列表相同
@Override :写在方法前面，用于检测是不是有效地正确方法重写
2.子类方法的返回值必须【小于等于】父类方法的返回值范围
例如。Object是所有类的公共最高父类.所以String就是Object的子类
3.子类方法的权限必须大于等于父类方法的权限修饰符
public>protected>(default:什么都不写)>private

**/
public class Demo02Override {
}
