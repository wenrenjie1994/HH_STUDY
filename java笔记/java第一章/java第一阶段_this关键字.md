## **this关键字**

**对象创建的过程和this的本质**

　　构造方法是创建Java对象的重要途径，通过new关键字调用构造器时，构造器也确实返回该类的对象，但这个对象并不是完全由构造器负责创建。创建一个对象分为如下四步：

　　1. 分配对象空间，并将对象成员变量初始化为0或空

　　2. 执行属性值的显示初始化

　　3. 执行构造方法

　　4. 返回对象的地址给相关的变量

　　this的本质就是“创建好的对象的地址”! 由于在构造方法调用前，对象已经创建。因此，在构造方法中也可以使用this代表“当前对象” 。

　　this最常的用法：

　　1.  在程序中产生二义性之处，应使用this来指明当前对象;普通方法中，this总是指向调用该方法的对象。构造方法中，this总是指向正要初始化的对象。

　　2. 使用this关键字调用重载的构造方法，避免相同的初始化代码。但只能在构造方法中用，并且必须位于构造方法的第一句。

　　3. **this不能用于static方法中。**

**【示例】this代表“当前对象”**

```java
public class User {
    int id;        //id
    String name;   //账户名
    String pwd;   //密码
 
    public User() {
    }
    public User(int id, String name) {
        System.out.println("正在初始化已经创建好的对象："+this);
        this.id = id;   //不写this，无法区分局部变量id和成员变量id
        this.name = name;
    }
    public void login(){
        System.out.println(this.name+",要登录！");  //不写this效果一样
    }  
     
    public static void main(String[] args) {
        User  u3 = new User(101,"高小七");
        System.out.println("打印高小七对象："+u3);
        u3.login();
    }
}
```

　　运行结果如图所示。

![1.png](https://www.sxt.cn/360shop/Public/admin/UEditor/20170516/1494927000371640.png)



**【示例】this()调用重载构造方法**

```java
public class TestThis {
    int a, b, c;
 
    TestThis() {
        System.out.println("正要初始化一个Hello对象");
    }
    TestThis(int a, int b) {
        // TestThis(); //这样是无法调用构造方法的！
        this(); // 调用无参的构造方法，并且必须位于第一行！
        a = a;// 这里都是指的局部变量而不是成员变量
// 这样就区分了成员变量和局部变量. 这种情况占了this使用情况大多数！
        this.a = a;
        this.b = b;
    }
    TestThis(int a, int b, int c) {
        this(a, b); // 调用带参的构造方法，并且必须位于第一行！
        this.c = c;
    }
 
    void sing() {
    }
    void eat() {
        this.sing(); // 调用本类中的sing();
        System.out.println("你妈妈喊你回家吃饭！");
    }
 
    public static void main(String[] args) {
        TestThis hi = new TestThis(2, 3);
        hi.eat();
    }
}
```