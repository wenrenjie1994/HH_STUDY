## **异常分类**

JDK 中定义了很多异常类，这些类对应了各种各样可能出现的异常事件，所有异常对象都是派生于Throwable类的一个实例。如果内置的异常类不能够满足需要，还可以创建自己的异常类。

   Java对异常进行了分类，不同类型的异常分别用不同的Java类表示，所有异常的根类为java.lang.Throwable，Throwable下面又派生了两个子类：Error和Exception。Java异常类的层次结构如图所示。

![图6-2 Java异常类层次结构图.png](https://www.sxt.cn/360shop/Public/admin/UEditor/20170520/1495272017528669.png)

## Exception

Exception是程序本身能够处理的异常，如：空指针异常(NullPointerException)、数组下标越界异常(ArrayIndexOutOfBoundsException)、类型转换异常(ClassCastException)、算术异常(ArithmeticException)等。

   Exception类是所有异常类的父类，其子类对应了各种各样可能出现的异常事件。 通常Java的异常可分为：

1. RuntimeException 运行时异常

2. CheckedException 已检查异常



## **自定义异常**

 1.在程序中，可能会遇到JDK提供的任何标准异常类都无法充分描述清楚我们想要表达的问题，这种情况下可以创建自己的异常类，即自定义异常类。

   2.自定义异常类只需从Exception类或者它的子类派生一个子类即可。

   3.自定义异常类如果继承Exception类，则为受检查异常，必须对其进行处理;如果不想处理，可以让自定义异常类继承运行时异常RuntimeException类。

   4.习惯上，自定义异常类应该包含2个构造器：一个是默认的构造器，另一个是带有详细信息的构造器。

**自定义异常类**

```java
/**IllegalAgeException：非法年龄异常，继承Exception类*/
class IllegalAgeException extends Exception {
    //默认构造器
    public IllegalAgeException() {
     
    }
    //带有详细信息的构造器，信息存储在message中
    public IllegalAgeException(String message) {
        super(message);
    }
}
```

**自定义异常类的使用**

```java
class Person {
    private String name;
    private int age;
 
    public void setName(String name) {
        this.name = name;
    }
 
    public void setAge(int age) throws IllegalAgeException {
        if (age < 0) {
            throw new IllegalAgeException("人的年龄不应该为负数");
        }
        this.age = age;
    }
 
    public String toString() {
        return "name is " + name + " and age is " + age;
    }
}
```



## 总结

1. Error与Exception都继承自Throwable类

2. Error类层次描述了Java运行时系统内部错误和资源耗尽错误。

3. Exception类是所有异常类的父类，其子类对应了各种各样可能出现的异常事件。

4. 常见的异常类型

   --ArithmeticException

   --NullPointerException

   --ClassCastException

   --ArrayIndexOutOfBoundsException

   --NumberFormatException

5. 方法重写中声明异常原则：子类声明的异常范围不能超过父类声明的范围

6. 异常处理的三种方式

   --捕获异常:try-catch-finally

   --声明异常:throws

7. 自定义异常类只需从Exception类或者它的子类派生一个子类即可。