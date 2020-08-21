**List集合笔记**  

----------


**一、List集合介绍和常用方法**  
1.java.util.List接口 extends Collection接口  

2.List接口的三大特点：  
a.【有序的集合】，存储元素和取出元素的顺序是一致的  
b.【有索引】，包含了一些带索引的方法  
c.【允许存储重复的元素】  

3.List接口中特有的带索引的方法：  

    a.public void add(int index, E element)：将指定的元素插入此列表中的指定位置
    b.public E get(int index)：返回此列表中指定位置的元素
    c.public E remove(int index)：删除该列表中指定位置的元素，返回被删除的元素
    d.public E set(int index, E element)：用指定的元素替换此列表中指定位置的元素，返回被替代的元素

4.注意：操作索引的时候，一定要防止索引越界异常  
IndexOutOfBoundsException（索引越界异常）  
ArrayIndexOutOfBoundsException（数组索引越界异常）  
StringIndexOutOfBoundsException（字符串索引越界异常）  

5.List集合遍历有三种方式：  
a.普通的for循环  
b.迭代器  
c.增强for循环  

**二、ArrayList集合（底层是数组结构）**  

**三、LinkedList集合**  
java.util.LinkedList集合 implements List接口  
LinkedList集合的特点：  
1.底层是链表结构：查询慢，增删快  
2.该集合包含了大量操作首尾元素的方法  

注意：使用LinkedList特有的方法，不能使用多态  

    a.public void addFirst(E e)：在该列表开头插入指定的元素             ---等效于push(E e)
    b.public void addLast(E e)：将指定的元素追加到此列表的末尾          ---等效于add()
    
    c.public E getFirst()：返回此列表中的第一个元素
    d.public E getLast()：返回此列表中的最后一个元素
    
    e.public E removeFirst()：从此列表中删除并返回第一个元素            ---等效于pop()
    f.public E removeLast()：从此列表中删除并返回最后一个元素
    
    g.public E pop()：从此列表表示的堆栈中弹出一个元素
    h.public void push(E e)：将元素推送到由此列表表示的堆栈上

四、Vector集合（了解 底层是数组结构，被ArrayList取代）  
ArrayList和LinkedList都是多线程，速度快  
Vector的底层实现也是数组，但是是单线程的，速度慢  