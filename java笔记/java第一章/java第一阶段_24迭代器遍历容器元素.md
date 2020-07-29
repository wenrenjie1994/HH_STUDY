## **使用Iterator迭代器遍历容器元素(List/Set/Map)**

### **迭代器遍历List**

```java

public static void testListIterator(){
    List<String> list = new LinkedList<>();
    list.add("a");
    list.add("b");
    list.add("c");
    for(Iterator<String> itr = list.iterator();itr.hasNext();){
        String temp = itr.next();
        System.out.println(temp);
    }
}
```



### **迭代器遍历Set(同list)**



### **迭代器遍历Map方法1**

```java
public static void testMapIterator(){
    Map<String,String> map = new HashMap<>();
    map.put("a","1");
    map.put("b","2");
    map.put("c","3");
    Set<Map.Entry<String,String>> myset = map.entrySet();
    for(Iterator<Map.Entry<String,String>> itr = myset.iterator();itr.hasNext();){
        Map.Entry<String,String> temp =itr.next();
        System.out.println(temp);
    }
}
```



### **迭代器遍历Map方法2（利用keySet或者valueSet）**

```java
//  我们也可以通过map的keySet()、valueSet()获得key和value的集合，从而遍历它们。
public static void testMapIterator(){
    Map<String,String> map = new HashMap<>();
    map.put("a","1");
    map.put("b","2");
    map.put("c","3");

    Set<String> myset = map.keySet();
    for (Iterator<String> iter = myset.iterator();iter.hasNext();){
        String temp = iter.next();
        System.out.println(temp+"----"+map.get(temp));
    }

}
```