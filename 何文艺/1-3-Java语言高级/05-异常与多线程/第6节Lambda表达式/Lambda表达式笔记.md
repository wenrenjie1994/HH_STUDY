**Lambda表达式笔记**  

----------


**一、函数式编程思想概述**  
在数学中，函数就是有输入量、输出量的一套计算方案，也就是“拿什么东西做什么事情”；相对而言，面向对象过分强调“必须通过对象的形式来做事情”，而函数式思想则尽量忽略面向对象的复杂语法---强调做什么，而不是以什么形式做  
1.面向对象的思想：做一个事情，找一个能做这个事情的对象，调用对象的方法，完成事情  
2.函数式编程的思想：只要能获取到结果，谁去做的，怎么做的都不重要，重视的是结果而不重视过程  

**二、冗余的Runnable代码**  

**三、编程思想转换和体验Lambda（JDK1.8的重量级新特性）的更优写法**  

```java
public class Demo01Lambda {
    public static void main(String[] args) {
        RunnableImpl run = new RunnableImpl();
        Thread t = new Thread(run);
        t.start();

        //匿名内部类简化代码
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "新线程执行了");
            }
        };
        new Thread(runnable).start();

        //匿名内部类更优化代码
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "新线程执行了");
            }
        }).start();

        //使用Lambda表达式简化代码
        new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "新线程执行了");
            }
        ).start();
    }
}
```

**四、Lambda标准格式**  
1.匿名内部类的好处与弊端：匿名内部类可以帮我们省去实现类的定义；但是匿名内部类的语法实在是太复杂了  
2.Lambda表达式的标准格式，由三部分组成：一些参数、一个箭头、一段代码  

    (参数列表) -> {一些重写方法的代码}
    
    ()：接口中抽象方法的参数列表，没有参数就空着，有参数就写出参数，多个参数使用逗号分隔
    ->：传递的意思，把参数传递给方法体{}
    {}：重写接口的抽象方法的方法体

**五、Lambda表达式_无参数无返回值**  
给定一个厨子Cook接口，内含唯一的抽象方法makeFood，且无参数无返回值

```java
public interface Cook {
    void makeFood();
}
```

在下面的代码中，请使用Lambda的标准格式调用invokeCook方法，打印输出“吃饭啦！”

```java
public class InvokeCook {
    public static void main(String[] args) {
    
    }

    private static void invokeCook(Cook cook) {
        cook.makeFood();
    }
}
```

1.定义一个Cook接口Cook.java  

```java
package lambda;

public interface Cook {
    void makeFood();
}
```

2.实现Cook接口CookImplements.java  

```java
package lambda;

public class CookImplements implements Cook{
    @Override
    public void makeFood() {
        System.out.println("吃饭啦！");
    }
}
```

3.测试类：Demo02InvokeCook.java  

```java
package lambda;

public class Demo02InvokeCook {
    public static void main(String[] args) {
        //原始代码
        CookImplements c = new CookImplements();
        invokeCook(c);

        //匿名内部类简化代码
        invokeCook(new Cook() {
            @Override
            public void makeFood() {
                System.out.println("吃饭啦！");
            }
        });

        //Lambda表达式简化代码
        invokeCook(() -> {
            System.out.println("吃饭啦！");
        });
    }
    private static void invokeCook(Cook cook) {
        cook.makeFood();
    }
}
```

**六、Lambda表达式_有参数有返回值练习一**  
使用数组存储多个Person对象  
对数组中的Person对象使用Arrays的sort方法通过年龄进行升序排序  

1.创建一个Person类Person.java  

```java
package lambda;

public class Person {
    private String name;
    private int age;

    //此处省略getter/setter方法
    //此处省略全参/无参构造方法
    //此处省略toString()重写方法
}
```

2.测试类Demo03AgeSort.java  

```java
package lambda;

import java.util.Arrays;
import java.util.Comparator;

public class Demo03AgeSort {
    public static void main(String[] args) {
        Person[] array = {
                new Person("张三",20),
                new Person("李四",16),
                new Person("王五",18)
        };
        //对数组中的Person对象使用Arrays的sort方法通过年龄进行升序（前边-后边）排序
        //使用匿名内部类
        Arrays.sort(array, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        //使用Lambda表达式
        Arrays.sort(array, (Person o1, Person o2) -> {
            return o1.getAge() - o2.getAge();
        });

        //遍历数组
        for (Person person : array) {
            System.out.println(person.toString());
        }

    }
}
```

**七、Lambda表达式_有参数有返回值练习二**  
给定一个计算器Calculator接口，内含抽象方法calc可以将两个int数字相加得到和值  

```java
public interface Calculator {
    int calc(int a, int b);
}
```

在下面的代码中，请使用Lambda的标准格式调用invokeCalc方法，完成120+130的计算  

```java
public class InvokeCalc {
    public static void main(String[] args) {
    
    }

    private static void invokeCalc(int a, int b, Calculator calc) {
        int result = calc.calc(a, b);
        System.out.println("结果是：" + result);
    }
}
```

1.创建Calculator接口Calculator.java  

```java
package lambda;

public interface Calculator {
    int calc(int a, int b);
}
```

2.测试类Demo04Add.java  

```java
package lambda;

public class Demo04Add {
    public static void main(String[] args) {
        //匿名内部类
        invokeCalc(120, 130, new Calculator() {
            @Override
            public int calc(int a, int b) {
                return a + b;
            }
        });
        //Lambda表达式
        invokeCalc(120, 130, (int a, int b) -> {
            return a + b;
        });
    }

    private static void invokeCalc(int a, int b, Calculator calc) {
        int result = calc.calc(a, b);
        System.out.println("结果是：" + result);
    }
}
```

**八、Lambda省略格式和Lambda使用前提**  
1.Lambda表达式：可推导、可以省略  
凡是根据上下文推导出来的内容，都可以省略书写  
可以省略的内容有：  
a.(参数列表)：括号中参数列表的数据类型可以省略不写  
b.(参数列表)：括号中的参数如果只有一个，那么类型和()都可以省略  
c.{一些代码}：如果{}中的代码只有一行，无论是否有返回值，都可以省略{}和return以及;【注意：要省略就必须一起省略】  

```java
//使用Lambda表达式
Arrays.sort(array, (Person o1, Person o2) -> {
    return o1.getAge() - o2.getAge();
});

//Lambda表达式省略优化
Arrays.sort(array, (o1, o2) -> o1.getAge() - o2.getAge());
```

2.Lambda使用前提  
a.使用Lambda必须具有接口，且要求接口中有且仅有一个抽象方法：无论是JDK内置的Runnable、Comparator接口还是自定义的接口，只有当接口中的抽象方法存在且唯一时，才可以使用Lambda  
b.使用Lambda必须具有上下文推断：也就是方法的参数或局部变量类型必须为Lambda对应的接口类型，才能使用Lambda作为该接口的实例  
备注：有且仅有一个抽象方法的接口，称为"函数式接口"  

  