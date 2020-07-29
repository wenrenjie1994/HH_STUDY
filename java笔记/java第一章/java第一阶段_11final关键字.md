**final关键字的作用：**

1. 修饰变量: 被他修饰的变量不可改变。一旦赋了初值，就不能被重新赋值。

```java
final  int   MAX_SPEED = 120;
```

2. 修饰方法：该方法不可被子类重写。但是可以被重载!

```java
final  void  study(){}
```

3. 修饰类: 修饰的类不能被继承。比如：Math、String等。

```java
final   class  A {}
```

