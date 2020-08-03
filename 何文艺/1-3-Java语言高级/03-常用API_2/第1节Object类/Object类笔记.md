**Object类笔记**  

----------


**一、Object类的toString方法**  
Object是类结构的根，每个类都以Object作为超类，所有对象（包括数组）都实现了这个类的方法  
任何一个类都可以使用Object类中的方法  
String toString()：返回对象的字符串表示形式  

```java
public String toString() {
    return getClass().getName() + "@" + Integer.toHexString(hashCode());
}
```

直接打印对象的名字其实就是调用对象的toString方法  
System.out.println(对象名.toString())等价于System.out.println(对象名)  
直接打印对象的地址没有意义，因此我们需要重写toString方法打印对象的属性  
IDEA快捷生成  

```java
@Override
public String toString() {
    return "Person{" +
            "name='" + name + '\'' +
            ", age=" + age +
            '}';
}
```

**二、Object类的equals方法**    
public boolean equals(Object obj)：指示其他某个对象是否与此对象“相等”  
源码：  

```java
public boolean equals(Object obj) {
    return (this == obj);
}
```

注意：  
1.参数(Object obj)：可以传递任意的对象  
2.==比较运算符，返回的是一个boolean值，不是true就是false  
【基本数据类型：比较的是值】  
【引用数据类型：比较的是两个对象的地址值】  
3.this：谁调用了这个方法谁就是this  

**三、重写Object类的equals方法**  
Object类的equals方法默认比较的是两个对象的地址值，没有意义；所以我们要重写equals方法，比较两个对象本身是否相等（也就是各属性是否都相等）  
问题：隐含着一个多态（多态的弊端：无法使用子类特有的内容（属性和方法））  
解决：可以使用向下转型（强转）  

Person.java  

```java
package day0803.object.demo01;

import java.util.Objects;

public class Person {
    private String name;
    private int age;

    //自己写的
    /*@Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o instanceof Person) {
            Person person = (Person)o;
            return this.name.equals(person.name) && this.age == person.age;
        }
        return false;
    }*/

    //IDEA快捷生成
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //getClass() != o.getClass()使用反射技术判断o是否是Person类型 等效于 o instanceof Person
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
```

**四、Objects类的equals方法**  
IDEA自动重写equals代码中，使用到了java.lang.Objects类  
JDK 7添加了一个Objects工具类，提供了一些方法来操作对象，由一些静态的实用方法组成，这些方法是null-save（空指针安全的）或null-tolerant（容忍空指针的），用于计算对象的hashcode、返回对象的字符串表达形式、比较两个对象  

Objects类的equals方法：对两个对象进行比较，【防止空指针异常】  
1.先(a == b)比较地址是否相同，若相同则表示a、b是同一个对象，直接返回true，(a != null && a.equals(b))不再执行  
2.若地址不相同，则表示a、b不是同一个对象，再比较a、b对象本身是否相同  
3.若a为null，则直接返回false，a.equals(b)不再执行  
4.否则用Object类的equals方法判断a、b对象本身是否相同  

```java
public static boolean equals(Object a, Object b) {
    return (a == b) || (a != null && a.equals(b));
}
```