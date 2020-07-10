# 集合框架

### 一、集合常用方法
### 1、增加元素
* 末尾添加元素：array.add(object)
* 指定位置添加元素：array.add(locate, object)

### 2、判断元素是否存在
* 判断对象而非名称：array.contains(object)

### 3、获取指定位置的对象
* array.get(locate)

### 4、获取对象的位置
* array.indexOf(object)

### 5、删除对象
* 根据位置删除：array.remove(locate)
* 根据对象删除：array.remove(object)

### 6、替换指定位置对象
* array.set(locate, new_object)

### 7、获取集合大小
* array.size()

### 8、集合转换为数组
* Hero hs[] = (Hero[])heros.toArray(new Hero[]{});

### 9、添加另一个容器的所有对象
* array.addAll(another_array)

### 10、清空集合
* array.clear()

### 二、集合的遍历
### 1、for循环遍历
### 2、迭代器遍历
### 3、增强for循环
```java
public class TestCollection {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        
        //for循环遍历
        for (int i = 0; i < array.size(); i++) {
            num = array.get(i);
            System.out.println(num);
        }
        
        //迭代器遍历
        Iterator<Integer> it = array.iterator();
        while(it.hasNext()){
                num = it.next();
                System.out.println(num);
        }

        //增强for循环
        for (Integer num : array) {
            System.out.println(num);
        }
 
    }
 
}
```

### 三、集合的关系
### 1、ArrayList、HashSet
* 顺序：ArrayList：插入有顺序，HashSet：插入无顺序
* 重复性：ArrayList：数据可重复，HashSet：数据不可重复

### 2、ArrayList、LinkedList
* 结构：ArrayList：顺序结构，LinkedList：链表结构
* 速度：ArrayList：插入慢，定位快，LinkedList：插入快，定位慢

### 3、HashMap、Hashtable
* 数据：HashMap：可存NULL，Hashtable：不可存NULL
* 线程：HashMap：线程不安全，Hashtable：线程安全

### 4、 HashSet、LinkedHashSet、TreeSet 
* 存储顺序：HashSet：无序，LinkedHashSet：按照插入顺序，TreeSet：从小到大排序 