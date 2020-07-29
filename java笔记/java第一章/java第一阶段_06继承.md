## Java三大特性

(内容摘自尚学堂)

### 1. 继承

 继承让我们更加容易实现类的扩展。 比如，我们定义了人类，再定义Boy类就只需要扩展人类即可。实现了代码的重用，不用再重新发明轮子(don’t  reinvent  wheels)。

   从英文字面意思理解，extends的意思是“扩展”。子类是父类的扩展。现实世界中的继承无处不在。比如：

 ![图5-1 现实世界中的继承.png](https://www.sxt.cn/360shop/Public/admin/UEditor/20170519/1495179917567916.png)

图1 现实世界中的继承

   上图中，哺乳动物继承了动物。意味着，动物的特性，哺乳动物都有；在我们编程中，如果新定义一个Student类，发现已经有Person类包含了我们需要的属性和方法，那么Student类只需要继承Person类即可拥有Person类的属性和方法。

**【示例】使用extends实现继承**

```java
public class Test{
    public static void main(String[] args) {
        Student s = new Student("高淇",172,"Java");
        s.rest();
        s.study();
    }
}
class Person {
    String name;
    int height;
    public void rest(){
        System.out.println("休息一会！");
    }  
}
class Student extends Person {
    String major; //专业
    public void study(){
        System.out.println("在尚学堂，学习Java");
    }  
    public Student(String name,int height,String major) {
        //天然拥有父类的属性
        this.name = name;
        this.height = height;
        this.major = major;
    }
}
```

   执行结果如图所示：

![图5-2 示例5-1运行效果图.png](https://www.sxt.cn/360shop/Public/admin/UEditor/20170519/1495180237622323.png)



### **1.1 继承使用要点**

1.父类也称作超类、基类、派生类等。

2.Java中只有单继承，没有像C++那样的多继承。多继承会引起混乱，使得继承链过于复杂，系统难于维护。

3.Java中类没有多继承，接口有多继承。

4.子类继承父类，可以得到父类的全部属性和方法 (除了父类的构造方法)，但不见得可以直接访问(比如，父类私有的属性和方法)。

5.如果定义一个类时，没有调用extends，则它的父类是：java.lang.Object。