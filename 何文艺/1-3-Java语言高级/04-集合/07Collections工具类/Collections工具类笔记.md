**Collections工具类笔记**  

----------


Collections集合工具类（操作集合的工具类）的方法  

1.public static <T> boolean	addAll(Collection<T> c, T... elements)：往集合中添加一些元素  

2.public static void shuffle(List<?> list)：打乱集合顺序  

3.public static <T> void sort(List<T> list)：将集合中的元素按照默认规则（升序）排序  

    注意事项：
    sort(List<T> list)方法的使用前提：被排序的集合里面存储的元素，必须实现Comparable接口，重写接口中的compareTo方法定义排序的规则
    Comparable接口的排序规则：
    自己（this）- 参数：升序

4.public static <T> void sort(List<T> list, Comparator<? super T> c)：将集合中的元素按照指定规则排序
Comparator和Comparable的区别：  
Comparator：相当于找一个第三方的裁判来进行比较  
Comparable：自己（this）和别人（参数）比较，自己需要实现Comparable接口，重写比较的规则compareTo方法  

Comparator的排序规则：  
o1-o2：升序  