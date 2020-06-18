### 栈：java.util.Stack<E>
![f8ad2a0058a8290a25127cb9bac3744f](resources/0D88A679-16ED-4990-BE81-BAC4FEB43915.png)

### 队列：java.util.Queue<E>
是接口的形式，可以创建一个实现该接口的对象，比如LinkedList：
Queue<Node> queue = new LinkedList<>();
常用add, remove, peek等方法

### 优先队列：java.util.PriorityQueue<E>
是最小堆。
默认使用类实现的compareTo方法；
但更常用比较器来初始化，便于定义符合自己要求的优先级。

```java
PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
```