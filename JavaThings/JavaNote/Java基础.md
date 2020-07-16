# Java学习笔记(SE)

## 一些基础

1. 查看IP地址

   ``ipconfig``

   ``ipconfig /all``

2. 两台计算机能否正常通信

   ``ping IP地址``

   ``ping 域名``

   ``ping IP地址 -t``			#forever    ``Ctrl + c``强行终止



## 卸载JDK

1. 删除Java的安装目录
2. 删除JAVA_HOME
3. 删除path下关于Java的目录
4. Java -version



## 安装JDK

1. 下载JDK8（企业使用的版本）
2. 安装电脑对应版本，记住安装路径
3. 配置环境变量
   + 我的电脑--->属性
   + 环境变量--->JAVA_HOME
   + 配置path变量
4. java -version，测试JDK是否安装成功



## notepad++



## 第一个程序

1. 新建一个java文件

   + 文件后缀名为.java

2. 第一行java代码

   ```java
   public class Hello {
   	public static void main(String[] args) {
           //output
   		System.out.print("Hello, World!");
           //input
           Scanner in = new Scanner(System.in);
           int val = in.nextInt();		//input integar
           
           System.out.println("100 - " + val "= " + (100 - val));
           System.out.println("echo: " + in.nextLine());		//input a line
   	}
   }
   ```

3. 编译java文件，生成一个class文件

   *``javac java文件的路径``*

4. 运行class文件 

   *``java className``*			#不含.class

>+ Java是大小写敏感的
>+ 尽量使用英文
>+ 文件名和类名必须保持一致，且首字母大写



## Java基础00

### 注释

+ 单行注释

  ``// AlohaWorld``

+ 多行注释

  ```java
  /*
  AlohaWorld
  */
  ```

+ 文档注释

  ```java
  /**
  * class infomation
  * @version 1.0
  * @author ChenglLiu
  * ...
  */
  ```

  **JavaDoc**

  + javadoc命令用来生成自己API文档
  + 参数信息
    - @author 作者名
    - @version 版本号
    - @since 指明需要最早使用的jdk版本
    - @param 参数名
    - @return 返回值情况
    - @throws 异常抛出情况
  + 命令行打开doc文件

  ```java
  javadoc -encoding UTF-8 -charset UTF-8 Doc.java
  ```

  + 使用IDEA生成javaDoc文档

    [IDEA生成Javadoc文档]([https://blog.csdn.net/weixin_42140580/article/details/89635775?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522159170359019726869024446%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=159170359019726869024446&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduend~default-2-89635775.first_rank_ecpm_v1_pc_rank_v3&utm_term=IDEA%E7%94%9F%E6%88%90Javadoc%E6%96%87%E6%A1%A3](https://blog.csdn.net/weixin_42140580/article/details/89635775?ops_request_misc=%7B%22request%5Fid%22%3A%22159170359019726869024446%22%2C%22scm%22%3A%2220140713.130102334..%22%7D&request_id=159170359019726869024446&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduend~default-2-89635775.first_rank_ecpm_v1_pc_rank_v3&utm_term=IDEA生成Javadoc文档))

  **书写注释很重要**

### 类体

> Java中有效的代码必须在“类体”中，最外层是一个类的定义
>
> **类体中放方法，不能直接放Java语句**
>
> **一个Java文件可以有多个类，但只能有一个public修饰的类且该类要与文件名相同**
>
> + for example：有一个test.java文件
>
> ```java
> class A {
>     
> }
> public class B {
>     
> }
> ```
>
> > 编译报错 class B is public，应该在B.java文件中声明
>
> 一个Java程序需要一个main方法，没有main方法可以编译通过，但是不能执行



## Java基础01

### 标识符与关键字

#### 1. 关键字

> abstract	assert	boolean	break	byte
>
> case	catch	char	class	const	continue
>
> default	do	double
>
> else	enum	extends	final	finally	float	for
>
> goto	if	implments	import	instanceof	int
>
> interface	long	native	new	package	private
>
> protected	public	return	strictfp	short	static
>
> super	switch	synchronized	this	throw	throws
>
> transient	try	void	volatile	while

#### 2. 标识符

+ 以字母、$、_开始

```java
public class Test {
    public static void main(String[] args) {
        
    }
    public static void doSomething() {
        int k = 100;
    }
}
/*
标识符：Test、k
类名：Test
方法名：doSomething
*/
```

+ 区分大小写，但若在Java源文件中同时出现A类和a类，谁在前就生成谁

+ **命名规范**

  - 见名知义

    标识符测试：``IdentifierTest``

  - ***驼峰命名法***

  - 类名、接口特殊要求

    > 类名和接口名首字母**大写**，后续单词首字母**大写**

  - 变量名和方法名首字母**小写**，后续单词首字母**大写**

  - 常量名**大写**，多个单词用_连接

    ``MAXN_PI``



### 变量

#### 0. 字面量

+ 整数型字面量
+ 浮点型字面量
+ 布尔型字面量
+ 字符型字面量
+ 字符串型字面量

#### 1. 变量

+ 数据类型、变量名、数值

+ 分类

  > 方法体中声明的变量：局部变量
  >
  > 方法体之外，类中声明的变量：成员变量



### 数据类型

- 强类型语言

  > 变量必须先定义再使用

- Java数据类型

  - 基本类型

    > **大容量转小容量需要强制类型转换**
    >
    > byte: 1字节
    >
    > short: 2字节
    >
    > int: 4字节
    >
    > long: 8字节
    >
    > > 整数型字面量默认是 ``int`` 型
    > >
    > > 但这个字面量不超过 ``byte/short`` 的取值范围，那么可以直接复制给 ``byte/short``类型的变量
    > >
    > > ```java
    > > 
    > > ```
  > > byte x = 127;			//ok
  > > byte y = 128;			//error
  > > long i = 214783647		//ok
  > > long j = 214783648		//error
  > > long j = 214783648L		//ok
  > >
  > > ```
  > > 
  > > ```
  >
  > float: 4字节
  >
  > double: 8字节
  >
  > > 字面量默认为 ``double`` 类型
  > >
  > > ```java
  > > float i = 3.14;			//error
  > > double j = 3.1415936;
  > > float k = 3.14F;		//ok
  > > ```
  >
  > char: 2字节
  >
  > > ``byte char short``做混合运算时，均转换为 ``int`` 再做运算
  > >
  > > ```java
  > > int i = 98;
  > > short x = i;			//error
  > > short x1 = (short)i;	//ok
  > > short y = 98;			//ok
  > > ```
  >
  > boolean: 1bit
  >
  > > **不同于 ``C/C++`` 无法用 ``0 1`` 表示布尔类型**
  >
  > + 原码：
  > + 反码：符号位变，数字位取反
  > + 补码：符号位不变，数字位取反加1
  
  - 转义字符
  
    - 制表符 ``/t``		#Tab键
    - 换行符 ``\n``
    - 输出``" ' \`` 用 ``\`` 转义 
    
  - 引用类型
  
    > 类
    >
    > 接口
    >
    > 数组
  
  - 类型转换
  
    > 强制类型转换：高---->低
    >
    > 自动类型转换：低---->高
    >
    > *转换的时候可能出现内存溢出、精度缺失*



### 运算符

+ 算术运算

+ 关系运算

+ 逻辑运算

  > - 逻辑与 ``&``	逻辑或 ``|``
  >
  > - 短路与 ``&&``  短路或 ``||``   

+ 赋值运算

+ 三目运算

+ 字符串连接运算符

  ``+``  字符串拼接



## Java基础02

### 包机制

+ 为了组织类，Java提供包机制，用于区别类名的命名空间

+ 语法

  ```java
  package pkg1[. pkg2[. pkg3...]];
  ```

+ 一般用公司域名倒置作为包名

+ 为使用一个包的成员，在Java中明确导入该包，使用```import```语句

  ``` java
  import package1[.package2...].(classname|*);
  ```



### Java流程控制

#### 用户交互Scanner

+ **Scanner对象**
  + ``java.util.Scanner``是Java5的新特征，通过Scanner类来获取用户的输入

  + 基本语法

  ```java
  Scanner s = new Scanner(System.in);
  ```

  + 通过Scanner类的``next()``与``nextLine()``方法获取输入的字符串，在读取前一半需要使用``hasNext()``与``hasNextLine()``判断是否还有输入的数据

  + next()

    - 读取到有效字符才结束输入

    - 输入的有效字符前遇到的空格，next()方法会将其自动去掉

    + 将有效字符后的空格作为分隔符或者结束符

    + **next()不能得到带有空格的字符串**

  + nextLine()

    + 以**换行符**为结束符
    + **能够输入带有空格的字符串**



## Java基础03

### 方法

+ `` System.out.println()``

> System：系统的类
>
> out：输出对象
>
> println：方法

+ **Java方法是语句的集合**，一起执行一个功能
  - 解决一类问题步骤的有序组合
  - 方法包含于类或对象中
  - 方法在程序中被创建，在其他地方被引用
+ 设计方法的原则：保持原子性，一个方法只完成一个功能 

####  方法的定义

+ **类似于函数**，用来完成特定功能的代码片段
+ 包含一个方法头和方法体
  - 修饰符
  - 返回值类型
  - 方法名
  - 参数类型
  - 方法体

#### 方法的重载

+ 重载规则：
  - 方法名相同
  - 参数列表必须不同
  - 返回类型可以相同可以不同

#### 命令行传参

+ 运行程序时再传递消息，这靠传递命令行参数给main()函数实现

  ```java
  public class CommandLine {
      public static void main(String args[]) {
          for (int i=0; i<args.length; i++) {
              System.out.println("args[" + i + "]:" + args[i]);
          }
      }
  }
  ```


#### 可变参数

+ JDK1.5开始，Java支持传递同类型的可变参数给一个方法
+ 方法声明中，在指定参数类型后加一个省略号(...)
+ 一个方法**只能声明一个可变参数**，它必须是方法的最后一个参数，任何普通参数必须在其之前声明

```java
public static void printMax(double... numbers) {
    if(numbers.length == 0) {
        System.out.println("No number passed");
        return;
    }
    double result = numbers[0];
    //sort
    for(int i=0; i<numbers.length; i++) {
        if(numbers[i] > result) {
            result = numbers[i];
        }
    }
    System.out.println("This max value is: " + result);
}
```



### 数组

#### 声明和创建

+ 声明的语法

  `` dataType[] arrayRefVar;``**(首选)**

  `` dataType arrayRefVar[];``

+ Java使用`` new``操作符创建数组

  `` dataType[] arrayRefVar = new dataType[arraySize];``

+ 获取长度：`` arrays.length``

+ 二维数组

  ```java
  int[][] arr = new int[4][3];
  //外层元素：arr[0], arr[1]
  //内层元素：arr[0][0]
  
  //外层元素的初始化值：地址值
  //内层元素的初始化值：与一维数组初始化情况相同
  
  int[][] arr = new int[4][];
  //外层元素的初始化值为：null
  //内层元素的初始化值为：不能调用，否则报错
  ```

  

#### 内存分析

+ Java内存分析

  - 堆:

    > 存放`` new``的对象和数组
    >
    > 可以被所有线程共享，不存放别的对象引用

  - 栈：

    > 存放基本数据类型（包含数值）
    >
    > 引用对象的变量（存放这个引用在堆中的地址）

  - 方法区

    > 被所有线程共享
    >
    > 包含了所有的`` class``和`` static``变量

#### 初始化方式

+ 静态初始化

  ```java
  int[] a = {1, 2, 3};
  Man[] mans = {new Man(1,1), new Man(2,2)};
  ```

+ 动态初始化

  ```java
  int[] a = new int[2];
  a[0] = 1;
  a[1] = 2;
  ```

+ 默认初始化

#### Arrays类

+ 数组的工具类`` java.util.Arrays``
+ **查看JDK帮助文档**
+ Arrays类中的方法都是static修饰的**静态方法**，使用时直接使用类型进行调用
+ 常用功能：
  - 给数组赋值：fill
  
    ``void fill(int[] a, int val)``
  
  - 数组排序：sort，按升序
  
    ``void sort[int[] a]``
  
  - 比较数组：equals，比较数组元素是否相等
  
    ``boolean euqals(int[] a, int[] b)``
  
  - 查找数组元素：binarySearch，对排序好的数组进行二分查找
  
    ``int binarySearch(int[] a, int key)``
  
  - 输出数组信息
  
    ``String toString(int[] a)``

#### 常见异常

1. 数组下标越界异常：``ArrayIndexOutOfBoundsException``

2. 空指针异常：``NullPointerException``

   ```java
   int[] arr = null;
   System.out.println(arr[0]);			//exception2
   
   int[][] arr2 = new int[4][];
   Syetem.out.println(arr2[0]);		//output:null
   System.out.println(arr2[0][0]);		//exception2
   ```



## Java基础04

### 面向对象编程

#### 面向对象 & 面向过程

+ 面向过程(POP)
  - **步骤**清晰简单
  - 简单问题
+ 面向对象(OOP)
  - **问题分类**
  - 处理复杂问题
+ **宏观面向对象分析整个系统，微观上面向过程**

#### 面向对象

+ Object-Oriented Programming，OOP

+ 本质：**以类的方式组织代码，以对象的组织(封装)数据**

+ 抽象

+ 特性：
  - 封装
  - 继承
  - 多态
  
+ 关键字

  > ``this、super、static、final、abstract、interface、package、import``



### 类与对象

#### 1. 类

+ 一种抽象的数据类型

+ 构成：
  - 属性(filed)：成员变量
  - 方法(method)：可以**调用**当前类中的其他方法/属性
  - 构造器
  - 代码块
  - 内部类
  - (局部变量：声明在方法中、方法形参、代码块内、构造器形参、构造器内的变量)
  
+ 权限修饰符

  ``private public 缺省 protected``

#### 2. 对象

+ 构造方法

  > 创建对象，初始化实例变量

+ 对象是抽象概念的具体实例

+ 匿名对象

#### 创建与初始化对象

+ 使用new关键字创建对象
+ new一个对象时，分配内存空间，默认初始化，以及对类中构造器的调用
+ 构造器（构造方法），创建对象时必须调用的，构造器的**特点**
  - 与类名相同
  - 没有返回类型
  - Ait + Ins键快速生成构造器

#### 封装

+ “**高内聚，低耦合**”
  - 高内聚：类的内部数据操作细节自己完成，不允许外部干涉
  - 低耦合：仅暴露少量的方法给外部使用
+ 封装：数据隐藏，通过接口访问
+ 属性**私有**、不对外提供接口的方法
+ 提供公共的方法用以访问``get function()`` ``set function()``
+ ``private``
  - 只有这个类内部可以访问
  - 类内部的成员函数和定义初始化
  - **这个限制是对类的**而不是对对象的
+ ``public``
  - 
+ 没有``private``和``public``表示是``friendly``
  - 同一个包内部可以访问

#### 访问权限修饰符 

| 修饰符    | 类内部 | 同一个包 | 不同包的子类 | 同一个工程 |
| --------- | ------ | -------- | ------------ | ---------- |
| private   | Yes    |          |              |            |
| 缺省      | Yes    | Yes      |              |            |
| protected | Yes    | Yes      | Yes          |            |
| public    | Yes    | Yes      | Yes          | Yes        |

> 可以修饰类
>
> + 缺省
> + ``public``
>
> 可以修饰类的内部结构
>
> + 属性
> + 方法
> + 构造器
> + 内部类



 #### 继承

+ 继承的本质是对某一批类的抽象
+ 子类是父类的扩展
+ Java中类只有单继承，没有多继承
+ extends
+ 方法重写
  - 子类重写父类的方法
  - 方法名相同
  - 参数列表相同
  - 方法体不同

##### object类

- ``toString()``：返回一个对象的字符串表达形式
- ``equals()``：判断这两个管理者管理的是否是同一个对象

##### **super**

> 1. super调用父类的构造方法，在构造方法的第一个
> 2. super只能出现在子类的方法或构造方法中
> 3. super和this不能同时调用构造方法

##### 子类和子类型

+ 类定义了类型
+ 子类定义子类型
+ 子类的对象可以被当作父类的对象来使用
  - 赋值给父类的变量
  - 传递给需要父类对象的函数
  - 放进存放父类对象的容器里

#### 多态

+ 动态编译
+ 同一方法根据发送对象的不同采取不同的行为方式
+ 一个对象的实际类型是确定的，但可以指向对象的引用类型有很多
+ 存在条件
  - 继承关系
  - 子类重写父类
  - 父类引用指向子类对象
+ **instanceof**

##### **多态变量**

- Java的对象变量是多态的，它们能保存不止一种类型的对象

- 它们可以保存的是声明类型的对象，或声明类型的子类的对象

- 当把子类的对象赋给父类的变量的时候，会发生向上造型

- 造型cast

  - 子类的对象可以赋值给父类的变量

  - attention：Java中不存在对象对对象的赋值

  - 父类的对象不能赋值给子类的变量

    ```java
    Vechicle v;
    Car c = new Car();
    v = c;		//OK
    c = v;		//compile error
    ```

  - 造型:

    + ``c = (Car)v;``

    + 只有当v这个变量实际管理的是Car才行
    + 对象本身没有发生任何变化
    + ***不是类型转换***
    + 运行时检查是否合理
    + ``ClassCastException``

##### 函数调用的绑定

+ 通过对象变量调用函数的时候，调用哪个函数———绑定
  - 静态绑定：根据变量的声明类型来绑定
  - 动态绑定：根据变量的动态类型来决定
+ 在成员函数中调用其他成员函数也是通过this这个对象变量来调用的

##### 覆盖override

+ 子类和父类中存在名称和参数表完全相同的函数
+ 通过父类的变量调用存在覆盖关系的函数时，会调用变量当时所管理的对象所属的类的函数

#### 抽象类

+ 只能靠子类实现

#### 接口

+ 普通类：只有具体实现
+ 抽象类：具体实现和抽象方法
+ 接口：只有规范

***接口 & 抽象类***

> 接口：实现多继承、方法属性``public abstract``、数据属性``public static final``、使用interface、不能被实例化、子类用**implements**实现它并可以实现多个接口、并且子类必须重写接口的方法
>
> 抽象类：只能单继承、使用abstract、子类使用extends实现它

```java
public interface UserService {
    //接口中的定义默认是抽象的 public abstract
    void add(String name);
}
```

```java
public interface TimeService {
    void timer();
}
```

```java
//类实现接口：implements 接口
public class UserServiceImpl implements UserService, TimeService {
    @Override
    public void add(String name) {

    }

    @Override
    public void timer() {

    }
}
```

#### 内部类

+ 在一个类的内部中定义一个类

  > 1. 成员内部类
  > 2. 静态内部类
  > 3. 局部内部类
  > 4. 匿名内部类

### 异常(exception)

#### 异常处理机制

- 抛出异常
- 捕获异常
- 异常处理五个关键字
  - try、catch、finally、throw、throws 

```java
public static void main(String[] args) {
    try {
        new Test().test(a:1, b:0);
    } catch (ArithmeticException) {
        e.printStackTrace();
    } finally {
        System.out.println("finally");
    }
}

//方法中处理不了这个异常，则由方法上抛出
public void test(int a, int b) throws ArithmeticException {
    if (b == 0) {
        throw new ArithmeticException();	//主动抛出异常
    }
}
```

#### 自定义异常

+ 用户自定义异常，**只需继承Exception类**即可
+ 使用自定义异常类
  1. 创建自定义异常类
  2. 在方法中通过``throw``关键字抛出异常对象
  3. 如果在当前抛出异常的方法中处理异常，可以使用``try-catch``语句捕获并处理；否则在方法的声明初通过``throws``关键字指明要抛出给方法调用者的异常，进行下一步
  4. 在出现异常方法的调用者中捕获并处理异常

```java
public class MyException extends Exception {
	private int val;
    
    public MyException(int a) {
        val = a;
    }
    
    //toString
    @Override
    public String toString() {
        return "MyException{ " + "val= " + val + '}';
    }
}

//test
public class Test {
    /*抛出去
    static void test(int a) throws MyException {
        if(a < 0) {
            throw new MyException(a);
        }
        System.out.println("OK");
    }
    */
    //捕获
    static void test(int a) {
        if(a < 0) {
            throw new MyException(a);
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        try {
            test(a:1);
        } catch (MyException e) {
            System.out.println("MyException" + e);
        }
    }
}
```



### 设计原则

#### 消除代码复制

+ 代码复制是不良设计的一种表现
+ 消除代码复制的两种手段
  - **函数**
  - **父类**

#### 增加可扩展性

+ 可以运行的代码 != 良好的代码
+ 对代码做维护的时候最能看出代码的质量

#### 用封装来降低耦合

+ 类和类之间的关系称作耦合
+ 耦合度越低，保持距离是形成良好代码的关键

#### 用接口来实现聚合

+ 将细节彻底隐藏在类内部

#### 用容器来实现灵活性

#### 以框架+数据来提高可扩展性

+ 命令的解析是否可以脱离if-else
+ 定义一个Handler来处理命令
+ 用Hash Table来保存命令和Handler之间的关系



### 抽象函数/抽象类

+ 抽象函数——表达概念而无法实现具体代码的函数
+ 抽象类——表达概念而无法构造出实体的类

+ 带有``abstract``修饰符的函数
+ 有抽象函数的类一定是抽象类
+ 抽象类不能制造对象，但可以定义变量
  - 任何继承了抽象类的非抽象类的对象可以赋给这个变量

### 实现抽象函数

+ 继承自抽象类的子类必须覆盖父类中的抽象函数
+ 否则择机成为抽象类

### 两种抽象

+ 与具体相对
  - 表示一种概念而非实体
+ 与细节相对
  - 表示在一定程度上忽略细节而着眼大局

### 数据与表现分离

+ 程序的业务逻辑与表现无关
  - 表现可以是图形的也可以是文本的
  - 表现可以是当地的也可以远程的

### 责任驱动的设计

+ 将程序要实现的功能分配到合适的类/对象中去是设计中非常重要的一环

### 风格化

+ 图形界面本身有更高的解析度
+ 但是将画面网格化以后，数据就更容易处理了



----

### 接口(interface)

+ 接口是纯抽象类
  - 所有的成员函数都是抽象函数
  - 所有的成员变量都是`` public static final``
+ 接口规定了长什么样，但是不管里面有什么

### 实现接口

+ 类用``extends``，接口用``implements``
+ 类可以实现很多接口
+ 接口可以继承接口，**但不能继承类**
+ 接口不能实现接口

### 面向接口的编程方式

+ 设计程序时先定义接口，再实现类
+ 任何需要在函数间传入传出的一定是接口而不是具体的类
+ Java成功的关键之一，适合多人同时写一个大程序
+ Java被批评的要点之一，因为代码量膨胀起来很快

### 匿名类

+ 在``new``对象的时候给出的类的定义形成匿名类
+ 匿名类可以继承某类，也可以实现某接口
+ Swing的消息机制广泛使用匿名类

### 内部类

+ 定义在别的类内部、函数内部的类
+ 内部类能直接访问外部的全部资源
  - **包括任何私有的成员**
  - **外部是函数时，只能访问那个函数里``final``的变量**

### 注入反转

+ 由按钮公布一个收听者接口和一对注册/注销函数
+ 你的代码实现那个接口，将收听者对象注册在按钮上
+ 一旦按钮被按下，就会反过来调用你的收听者对象的某个函数





### ``JTable``

+ 用``JTbale``类可以用表格的形式显示和编辑数据。``JTbale``类的对象并不存储数据，它只是数据的**表现**

### MVC

+ 数据、表现、控制三者分离，各负其责
  - M——Model（模型）
  - V——View（表现）
  - C——Control（控制）
+ 模型：保存和维护数据，提供接口让外部修改数据，通知表现需要刷新
+ 表现：从模型获得数据，根据数据画出表现
+ 控制：从用户得到输入，根据输入调整数据



### 捕捉异常

```java
try {
    //可能产生异常的代码
} catch (Typel id1) {
    //处理Type1异常的代码
} catch (Typle id2) {
    //处理Type2异常的代码
} catch (Type3 id3) {
    //处理Type3异常的代码
}
```

#### 异常机制

####  捕捉异常做什么

+ 拿到异常对象之后
  - ``String getMessage();``
  - ``String toString();``
  - ``void printStackTrace();``

#### 用上异常机制

```java
try {
    open the file;
    determine its size;
    allocate that such memory;
    read the file into memory;
    close the file;
} catch (fileOPenFailed) {
    do somethings;
} catch (sizeDeterminationFailed) {
    do somethings;
} catch (memoryAllocationFailed) {
    do somethings;
} catch (readFailed) {
    do somethings;
} catch (closeFailed) {
    do somethings;
}
```

#### 异常

+ 有不寻常的事情发生了
+ 当这个事情发生时，原本打算要做的事情不能再继续了，必须停下来，让其他地方的某段短发来处理

> 异常机制的最大好处就是清晰地分开了正常的业务逻辑代码和遇到情况时的处理代码

#### 异常声明

+ 如果你的函数可能抛出异常，就必须在函数头部加以声明

  ```java
  void f() throws Toobig, Toosmall, DivZero {	//...
  void f() {...
  ```

+ 你可以声明并不会真的抛出的异常
+ 如果你调用一个声明会抛出异常的函数，那么你必须：
  - 把函数的调用放在try块中，并设置catch来捕捉所有可能抛出的异常；或
  - 声明自己会抛出无法处理的异常

#### 异常声明遇到继承关系

+ 当覆盖一个函数的时候，子类不能声明抛出比父类的版本更多的异常
+ 在子类的构造函数中，必须声明父类可能抛出的全部异常



### 什么能扔

+ 任何继承了``Throwable``类的对象
+ ``Exception``类继承了``Throwable``
  - ``throw new Exception();``
  - ``throw new Exception("HELP");``



#### catch怎么匹配异常的

+ Is-A的关系
+ 就是说，抛出子类异常会被捕捉父类异常的catch给捉住

#### 捕捉任何异常

```java
catch (Exception e) {
    System.out.println("Caught an exception");
}
```

#### 运行时刻异常

+ 像``ArrayIndexOutOfBoundsException``这样的异常是不需要声明的
+ 但是没有适当的机制来捕捉，就会最终导致程序终止



### 流

#### 流是输入输出的方式

+ 流是一维单向的
+ ``stream``

> ``System.out.println();``
>
> * ``System``：一个类
> * ``out``：System类的一个静态成员
> * ``println``：out成员可以做的事情
> * ``out``：某种用来做输出的流

#### 流的基础类

+ ``InputStream``
+ ``OutputStream``



### 文件流

+ ``FileInputStream``
+ ``FileOutputStream``
+ 对文件作读写操作
+ 实际工程中已较少使用
  - 更常用的是以在内存数据或通信数据上建立的流，如数据库的二进制数据读写或网络端口通信
  - 具体的文件读写往往有更专业的类，比如配置文件和日志文件

#### Reader & Writer

+ 二进制数据采用``InputStream/OutStreamStream``
+ 文本数据采用``Reader/Writer``

#### 在流上建立文本处理

```java
PrintWriter pw = new PrintWriter (
	new BufferedWriter (
    	new OutputStreamWriter (
        	new FileOutputStream("abc.txt"))));
```

