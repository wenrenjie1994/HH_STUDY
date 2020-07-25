## **Collection接口**

Collection 表示一组对象，它是集中、收集的意思。Collection接口的两个子接口是List、Set接口。

**表Collection接口中定义的方法**

![表9-1 Collection接口中定义的方法.png](https://www.sxt.cn/360shop/Public/admin/UEditor/20170524/1495614959696503.png)

   由于List、Set是Collection的子接口，意味着所有List、Set的实现类都有上面的方法。



## **List特点和常用方法**

 List是有序、可重复的容器。

   **有序：**List中每个元素都有索引标记。可以根据元素的索引标记(在List中的位置)访问元素，从而精确控制这些元素。

   **可重复：**List允许加入重复的元素。更确切地讲，List通常允许满足 e1.equals(e2) 的元素重复加入容器。

   除了Collection接口中的方法，List多了一些跟顺序(索引)有关的方法，参见下表：



**List接口中定义的方法**

![表9-2 List接口中定义的方法.png](https://www.sxt.cn/360shop/Public/admin/UEditor/20170524/1495616109914665.png)

   List接口常用的实现类有3个：ArrayList、LinkedList和Vector。



## **ArrayList特点和底层实现**

ArrayList底层是用数组实现的存储。 特点：查询效率高，增删效率低，线程不安全。我们一般使用它。查看源码：

![图9-6 ArrayList底层源码(1).png](https://www.sxt.cn/360shop/Public/admin/UEditor/20170524/1495616601500147.png)

ArrayList底层源码(1)

   我们可以看出ArrayList底层使用Object数组来存储元素数据。所有的方法，都围绕这个核心的Object数组来开展。

   我们知道，数组长度是有限的，而ArrayList是可以存放任意数量的对象，长度不受限制，那么它是怎么实现的呢?本质上就是通过定义新的更大的数组，将旧数组中的内容拷贝到新数组，来实现扩容。 ArrayList的Object数组初始化长度为10，如果我们存储满了这个数组，需要存储第11个对象，就会定义新的长度更大的数组，并将原数组内容和新的元素一起加入到新数组中，源码如下：

![图9-7 ArrayList底层源码(2).png](https://www.sxt.cn/360shop/Public/admin/UEditor/20170524/1495616624527034.png)

 ArrayList底层源码(2)



## **LinkedList特点和底层实现**

LinkedList底层用双向链表实现的存储。特点：查询效率低，增删效率高，线程不安全。

   双向链表也叫双链表，是链表的一种，它的每个数据节点中都有两个指针，分别指向前一个节点和后一个节点。 所以，从双向链表中的任意一个节点开始，都可以很方便地找到所有节点。

![图9-8 LinkedList的存储结构图.png](https://www.sxt.cn/360shop/Public/admin/UEditor/20170524/1495616843888130.png)

 LinkedList的存储结构图

   每个节点都应该有3部分内容：

```java
 class  Node {
        Node  previous;     //前一个节点
        Object  element;    //本节点保存的数据
        Node  next;         //后一个节点
}
```

   我们查看LinkedList的源码，可以看到里面包含了双向链表的相关代码：

![图9-9 LinkedList的底层源码.png](https://www.sxt.cn/360shop/Public/admin/UEditor/20170524/1495616905610598.png)

 LinkedList的底层源码



## **Vector向量**

Vector底层是用数组实现的List，相关的方法都加了同步检查，因此“线程安全,效率低”。 比如，indexOf方法就增加了synchronized同步标记。

![图9-10 Vector的底层源码.png](https://www.sxt.cn/360shop/Public/admin/UEditor/20170524/1495617071989433.png)

Vector的底层源码

**建议**

   如何选用ArrayList、LinkedList、Vector?

1. 需要线程安全时，用Vector。

2. 不存在线程安全问题时，并且查找较多用ArrayList(一般使用它)。

3. 不存在线程安全问题时，增加或删除元素较多用LinkedList。