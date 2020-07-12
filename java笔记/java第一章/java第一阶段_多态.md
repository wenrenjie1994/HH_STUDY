## 多态

多态指的是同一个方法调用，由于对象不同可能会有不同的行为。现实生活中，同一个方法，具体实现会完全不同。 比如：同样是调用人的“休息”方法，张三是睡觉，李四是旅游，高淇老师是敲代码，数学教授是做数学题; 同样是调用人“吃饭”的方法，中国人用筷子吃饭，英国人用刀叉吃饭，印度人用手吃饭。

   多态的要点：

1. 多态是方法的多态，不是属性的多态(多态与属性无关)。

2. 多态的存在要有3个必要条件：继承，方法重写，父类引用指向子类对象。

3. 父类引用指向子类对象后，用该父类引用调用子类重写的方法，此时多态就出现了。

   

**多态和类型转换测试**

```java
class Animal {
    public void shout() {
        System.out.println("叫了一声！");
    }
}
class Dog extends Animal {
    public void shout() {
        System.out.println("旺旺旺！");
    }
    public void seeDoor() {
        System.out.println("看门中....");
    }
}
class Cat extends Animal {
    public void shout() {
        System.out.println("喵喵喵喵！");
    }
}
public class TestPolym {
    public static void main(String[] args) {
        Animal a1 = new Cat(); // 向上可以自动转型
        //传的具体是哪一个类就调用哪一个类的方法。大大提高了程序的可扩展性。
        animalCry(a1);
        Animal a2 = new Dog();
        animalCry(a2);//a2为编译类型，Dog对象才是运行时类型。
         
        //编写程序时，如果想调用运行时类型的方法，只能进行强制类型转换。
        // 否则通不过编译器的检查。
        Dog dog = (Dog)a2;//向下需要强制类型转换
        dog.seeDoor();
    }
 
    // 有了多态，只需要让增加的这个类继承Animal类就可以了。
    static void animalCry(Animal a) {
        a.shout();
    }
 
    /* 如果没有多态，我们这里需要写很多重载的方法。
     * 每增加一种动物，就需要重载一种动物的喊叫方法。非常麻烦。
    static void animalCry(Dog d) {
        d.shout();
    }
    static void animalCry(Cat c) {
        c.shout();
    }*/
}
```

   执行结果如图所示：

![图5-17 示例5-12运行效果图.png](https://www.sxt.cn/360shop/Public/admin/UEditor/20170520/1495253451887350.png)