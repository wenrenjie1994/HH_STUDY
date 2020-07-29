## **Set接口**

Set接口继承自Collection，Set接口中没有新增方法，方法和Collection保持完全一致。我们在前面通过List学习的方法，在Set中仍然适用。因此，学习Set的使用将没有任何难度。

Set容器特点：无序、不可重复。无序指Set中的元素没有索引，我们只能遍历查找;不可重复指不允许加入重复的元素。更确切地讲，新元素如果和Set中某个元素通过equals()方法对比为true，则不能加入;甚至，Set中也只能放入一个null元素，不能多个。

Set常用的实现类有：HashSet、TreeSet等，我们一般使用HashSet。



**HashSet的使用**

```java
public class Test {
    public static void main(String[] args) {
        Set<String> s = new HashSet<String>();
        s.add("hello");
        s.add("world");
        System.out.println(s);
        s.add("hello"); //相同的元素不会被加入
        System.out.println(s);
        s.add(null);
        System.out.println(s);
        s.add(null);
        System.out.println(s);
    }
}
```

   执行结果如图9-24所示：

![图9-24示例9-9运行效果图.png](https://www.sxt.cn/360shop/Public/admin/UEditor/20170525/1495697440640267.png)



## **HashSet底层实现**

 HashSet是采用哈希算法实现，底层实际是用HashMap实现的(HashSet本质就是一个简化版的HashMap)，因此，查询效率和增删效率都比较高。我们来看一下HashSet的源码：

![图9-25 HashSet底层源码.png](https://www.sxt.cn/360shop/Public/admin/UEditor/20170525/1495697834473119.png)

图 HashSet底层源码

   我们发现里面有个map属性，这就是HashSet的核心秘密。我们再看add()方法，发现增加一个元素说白了就是在map中增加一个键值对，键对象就是这个元素，值对象是名为PRESENT的Object对象。说白了，就是“往set中加入元素，本质就是把这个元素作为key加入到了内部的map中”。

   由于map中key都是不可重复的，因此，Set天然具有“不可重复”的特性。