**Map集合笔记**  

----------


**一、Map集合概述**  
java.util.Map<k,v>集合  
特点：  
1.Map集合是一个双列集合，一个元素包含两个值（一个key，一个value）  
2.Map集合中的元素，key和value的数据类型可以相同，也可以不同  
3.Map集合中的元素，key是不允许重复的，value是可以重复的  
4.Map集合中的元素，key和value是一一对应的  

**二、Map常用子类**  
java.util.HashMap<k,v>集合 implements Map<k,v>接口  
HashMap集合的特点：  
1.HashMap集合底层是哈希表：查询的速度特别快  
2.HashMap集合是一个无序的集合，存储元素和取出元素的顺序有可能不一致  

java.util.LinkedHashMap<k,v>集合 extends HashMap<k,v>集合  
LinkedHashMap集合的特点：  
1.LinkedHashMap集合底层是哈希表 + 链表（保证迭代的顺序）  
2.LinkedHashMap集合是一个有序的集合，存储元素和取出元素的顺序是一致的  

**三、Map接口中的常用方法**  

    1.public V put(K key, V value)：把指定的键与指定的值添加到Map集合中
      返回值V：
      存储键值对的时候，如果key没有重复，返回null；如果key重复，则会用新的value替换重复的value，返回被替换的value值
    
    2.public V get(Object key)：根据指定的键，在Map集合中获取对应的值
      返回值V：
      如果key存在，返回该键对应的值；如果key不存在，则返回null
    
    3.public V remove(Object key)：把指定的键所对应的键值对元素在Map集合中删除，返回被删除元素的值
      返回值V：
      删除键值对的时候，如果key存在，返回被删除的键值对的值；如果key不存在，则返回null
    
    4.public boolean containsKey(Object key)：判断集合中是否包含指定的键
    
    5.public Set<K>	keySet()：获取Map集合中所有的键，存储到Set集合中
    6.public Set<Map.Entry<K,V>> entrySet()：获取到Map集合中所有的键值对对象存储到一个Set集合中

**四、Map集合遍历1_键找值方式**  
实现步骤：   
1.使用Map集合中的方法public Set<K> keySet()把Map集合所有的key存储到一个Set集合中  
2.遍历Set集合，获取Map集合中的每一个key  
3.通过Map集合中的方法get(Object key)，通过key找到value  

**五、Entry键值对对象**  
在Map接口中有一个内部接口Entry  
作用：当Map集合一创建，那么就会在Map集合中创建一个Entry对象，用来记录键与值（键值对对象，键与值的映射关系）-> 结婚证  

**六、Map集合遍历2_键值对方式**  
实现步骤：  
1.使用Map集合中的方法public Set<Map.Entry<K,V>>   entrySet()把Map集合中多个Entry对象取出来，存储到一个Set集合中  
2.遍历Set集合，获取每一个Entry对象  
3.使用Entry对象中的方法getKey()和getValue()获取键与值  

**七、HashMap存储自定义类型键值**  
Map集合保证key是唯一的：作为key的元素，必须重写hashCode和equals方法  

**八、LinkedHashMap集合**

**九、Hashtable集合**  
java.util.Hashtable<k,v>集合 implements Map<k,v>接口  
Hashtable：底层也是一个哈希表，是一个线程安全的集合，是单线程的集合，速度慢  
HashMap集合：底层是一个哈希表，是一个线程不安全的集合，是多线程的集合，速度快  

HashMap集合（之前学的所有的集合）：可以存储null值、null键  
Hashtable集合不能存储null值、null键  

Hashtable集合和Vector集合一样，在jdk 1.2版本之后被更先进的集合（HashMap、ArrayList）取代  
Hashtable的子类Properties依然活跃在历史的舞台  

Properties集合是唯一一个和IO流相结合的集合  

**十、练习_计算一个字符串中每个字符出现的次数**

```java
public static void main(String[] args) {
    String str = "aaabbbccc你你你你你你5555";
    String[] strArr = str.split("");
    HashMap<String,Integer> map = new HashMap<>();
    for (int i = 0; i < strArr.length; i++) {
        if (!map.containsKey(strArr[i])) {
            map.put(strArr[i],1);
        } else {
            map.put(strArr[i],map.get(strArr[i]) + 1);
        }
    }
    Set<String> set = map.keySet();
    System.out.println(str);
    for (String key : set) {
        System.out.println(key + ":" + map.get(key));
    }
}
```