**Collection集合笔记**  

----------


集合分为单列集合(Collection)和双列集合（Map）  
**一、Collection集合概述**  
集合与数组的区别：  
1.数组长度固定，集合长度可变  
2.数组可以存储基本类型和对象，集合只能存储对象  

**二、集合框架介绍**  
学习集合的目标：  
1.会使用集合存储数据  
2.会遍历集合，把数据取出来  
3.掌握每种集合的特性  

集合框架的学习方法  
1.学习顶层：学习顶层接口/抽象类中共性的方法，因为所有的子类都可以使用  
2.使用底层：顶层不是接口就是抽象类，无法直接创建对象使用，所以我们需要使用底层的子类来创建对象进行使用  

1.List接口和Set接口的区别：  

    List接口：
        a.有序的集合（存储和取出元素的顺序相同）
        b.允许存储重复的元素
        c.有索引，可以使用普通的for循环遍历
    Set接口：
        a.不允许存储重复的元素
        b.没有索引（不能使用普通的for循环遍历）
        其中：TreeSet和HashSet是无序的集合（存储和取出元素的顺序有可能不一致）
              LinkedHashSet是有序的集合

2.Collection接口：是所有单列集合的最顶层的接口，定义了所有单列集合中共性的方法，所有的单列集合都可以使用这些共性的方法（Collection接口没有带索引的方法）  

**三、Collection集合常用功能（java.util.Collection）**  
1.public boolean add(E e)：把给定的对象添加到当前集合中  
2.public void clear()：清空集合中所有的元素  
3.public boolean remove(E e)：把给定的对象从当前集合中删除  
4.public boolean contains(E e)：判断当前集合中是否包含给定的对象  
5.public boolean isEmpty()：判断当前对象是否为空  
6.public int size()：返回集合中元素的个数  
7.public Object[] toArray()：把集合中的元素，存储到数组中  

**四、Iterator接口介绍**  
1.迭代：即【Collection集合元素的通用获取方式】；在取元素之前先要判断集合中有没有元素，如果有，就把这个元素取出来，继续再判断，如果还有就再取出来，一直到把集合中的所有元素全部取出，这种取出方式专业术语称为迭代  
2.java.util.Iterator接口：迭代器（对集合进行遍历）  

    boolean	hasNext()：如果仍有元素可以迭代，则返回true
    E next()：返回迭代中的下一个元素

3.注意：java.util.Iterator是一个接口，无法直接创建对象使用，需要使用它的实现类对象
获取Iterator接口实现类对象的方式：使用Collection接口的iterator()方法  
4.【迭代器的使用步骤】：  
a.使用集合中的方法iterator()获取迭代器的实现类对象，使用Iterator接口来接收这个对象（多态）  
b.使用Iterator接口中的方法hasNext()判断还有没有下一个元素  
c.使用Iterator接口中的方法next()取出集合中的下一个元素  

**五、迭代器的代码实现**  

```java
public static void main(String[] args) {
    Collection<String> collection = new ArrayList<>();
    collection.add("张三");
    collection.add("李四");
    collection.add("王五");

    //Iterator<E>接口也是有泛型的，迭代器的泛型跟着集合走，集合是什么泛型，迭代器就是什么泛型

    Iterator<String> iterator = collection.iterator();
    while (iterator.hasNext()) {
        System.out.println(iterator.next());
    }
}
```

**六、迭代器的实现原理**  

**七、增强for循环**  
1.增强for循环：也称foreach循环，专门用来【遍历数组和集合】；它的底层原理其实就是一个Iterator迭代器，所以在遍历的过程中不能对集合中的元素进行增删操作；简化了迭代器的操作，工作中多使用增强for循环  
2.格式：  

    for(集合或数组的数据类型 变量名：集合名或数组名) {
        //...
    }

3.public interface Iterable<T>实现这个接口就允许对象成为"foreach"语句的目标  
而Collection<E> extends Iterable<E>：因此所有的单列集合都可以使用增强for循环  

```java
public static void main(String[] args) {
    Collection<String> collection = new ArrayList<>();
    collection.add("张三");
    collection.add("李四");
    collection.add("王五");
    
    for (String name:collection) {
        System.out.println(name);
    }
}  
```