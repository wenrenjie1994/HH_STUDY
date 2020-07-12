## Super

super是直接父类对象的引用。可以通过super来访问父类中被子类覆盖的方法或属性。

   使用super调用普通方法，语句没有位置限制，可以在子类中随便调用。

   若是构造方法的第一行代码没有显式的调用super(...)或者this(...);那么Java默认都会调用super(),含义是调用父类的无参数构造方法。这里的super()可以省略。



**super关键字的使用**

```java
public class TestSuper01 { 
    public static void main(String[] args) {
        new ChildClass().f();
    }
}
class FatherClass {
    public int value;
    public void f(){
        value = 100;
        System.out.println ("FatherClass.value="+value);
    }
}
class ChildClass extends FatherClass {
    public int value;
    public void f() {
        super.f();  //调用父类对象的普通方法
        value = 200;
        System.out.println("ChildClass.value="+value);
        System.out.println(value);
        System.out.println(super.value); //调用父类对象的成员变量
    }
}
```

   执行结果如图所示：

![图5-5 示例5-7运行效果图.png](https://www.sxt.cn/360shop/Public/admin/UEditor/20170519/1495186136513650.png)



## **继承树追溯**

**属性/方法查找顺序：(比如：查找变量h)**

1. 查找当前类中有没有属性h

2. 依次上溯每个父类，查看每个父类中是否有h，直到Object

3. 如果没找到，则出现编译错误。

4. 上面步骤，只要找到h变量，则这个过程终止。

**·构造方法调用顺序：**

   构造方法第一句总是：super(…)来调用父类对应的构造方法。所以，流程就是：先向上追溯到Object，然后再依次向下执行类的初始化块和构造方法，直到当前子类为止。

   注：静态初始化块调用顺序，与构造方法调用顺序一样。



**构造方法向上追溯执行测试**

```java
public class TestSuper02 { 
    public static void main(String[] args) {
        System.out.println("开始创建一个ChildClass对象......");
        new ChildClass();
    }
}
class FatherClass {
    public FatherClass() {
        System.out.println("创建FatherClass");
    }
}
class ChildClass extends FatherClass {
    public ChildClass() {
        System.out.println("创建ChildClass");
    }
}
```

   执行结果如图所示：

![图5-6 示例5-8运行效果图.png](https://www.sxt.cn/360shop/Public/admin/UEditor/20170519/1495187263836897.png)

