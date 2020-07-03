## 属性初始化
### 一、初始化方式
### 1、对象属性
* 属性声明时
```java
public class a{ 
public int i = 1;
}
```
* 构造方法中
```java
public class a{ 
public a(){i = 1;}
} 
```
* 初始化块
```java
public class a{ 
{i = 1;}
}
```
### 2、类属性
* 属性声明时
```java
public class a{
    public static int i = 1;
}
```
* 静态初始化块
```java
public class a{
    static{i = 1;}
}
```

### 2、初始化顺序
静态属性 -> 静态初始化块 -> 对象属性 -> 对象初始化块 -> 构造方法
