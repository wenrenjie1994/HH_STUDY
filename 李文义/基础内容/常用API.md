Java的API是JDK所提供的使用类，这些类将底层的代码给封装起来了。Object类是java语言中的根类，它所描述的所有方法子类都可以使用，所有类在创建对象的时候，最终找的父类就是Object。在Objec类中，最常见的就是euqals方法和toString方法。equals方法用于比较两个对象是否相同，实质是比较两个对象的内存地址。在复写Object中的equals方法时，一定要注意public boolean equals(Object obj)的参数是Object类型。在调用对象的属性时，一定要进行类型转换，转换之前一定要进行类型判断。toString方法返回该对象的字符串表示。

常用API：

java.lang.Math：提供sin, cos, tan, exp, log, log10 等类方法，PI和E等类字段。

java.lang.String：StringBuilder线程不安全，StringBuffer线程安全。
char charAt(int index)
返回给定位置的代码单元
boolean equals(Object other)
boolean equalsIngoreCase(String other)    如果字符串与other相等，返回true
忽略大小写
int length()    返回字符串的长度
String substring(int beginIndex)
String substring(int beginIndex, int endIndex)    返回一个新字符串，包含原始字符串从beginIndex到串尾或到endIndex-1的所有代码单元
String toLowerCase()
String toUpperCase()
返回小写字符串
返回大写字符串
int indexOf(String str[, int fromIndex])
int lastIndexOF(String str[, int fromIndex])    返回第一个/最后一个子串的位置,从起始位置或者fromIndex开始

java.util.Scanner：
Scanner(InputStream in)
Scanner(File f)
Scanner(String data)    用给定的输入流创建一个Scanner对象
例子：Scanner in = new Scanner(System.in)
String nextLine()    读取输入的下一行内容
String next()    读取输入的下一个单词（以空格作为间隔）
int nextInt()
double nextDouble()    读取并转换下一个表示整数或浮点数的字符序列
for each循环
for(variable : collection) statement
collection这一集合表达式必须是一个数组或者是一个实现了Iterable接口的类对象

java.util.Arrays:
static String toString(type[] a)    返回包含a中数据元素的字符串
static void sort(type[] a)    采用优化的快速排序算法对数组进行排序
static void binarySearch(type[] a, type v)    使用二分搜索算法查找值v
static Boolean equals(type[] a, type[] b)    如果两个数字相同，返回true
数组名.length    数组长度

java.util.Radom:
Random()    构建一个新的随机数生成器
int nextInt(int n)    返回一个 0 ~ n-1之间的随机数

java.lang.Object:
String toString()    返回描述该对象值的字符串。在自定义类中应覆盖这个方法
boolean equals(Object otherObject)    比较两个对象是否相等。在自定义类中应覆盖这个方法
Class getClass()
int hashCode()
返回包含对象信息的类对象
返回对象的散列码
static wait()
static notify()
static notifyAll() 

java.lang.Class
String getName()    返回这个类的名字
static Class forName(String className)    返回描述类名为className的Class对象
Object newInstance()    返回这个类的一个新实例
Field[] getFields()
Field[] getDeclareFields()    getFields()返回一个包含Field对象的数组，这些对象记录了这个类或其超类的公有域
getDeclareFields()返回的Field对象记录了这个类的全部域
Method[] getMethods()
Method[] getDeclareMethods()    getMethods()返回一个包含Method对象的数组，这些对象记录了这个类或其超类的公用方法
getDeclareMethods()返回的Field对象记录了这个类的全部方法
Constructor[] getConstructors()
Constructor[] getDeclareConstructors()
getConstructors()返回一个包含Constructor对象的数组，这些对象记录了这个类的公有构造器
getDeclareConstructors()返回的Constructor对象记录了这个类的全部构造器

断言：
assert 条件;
assert 条件:表达式;

java.util.Collection<E>：
Iterator<E> iterator()    返回一个用于访问集合中每个元素的迭代器
int size()    返回当前存储在集合中的元素个数
boolean isEmpty()    如果集合中没有元素，返回true
boolean contains(Object obj)
boolean containAll(Collection<? extend E> other)    如果集合中包含相等对象，返回true
boolean add(Object element)
boolean addAll(Collection<? extend E> other)  将一个元素添加到集合中，集合改变返回true
boolean remove(Object element)
boolean removeAll(Collection<?> other)   删除相等元素，成功删除返回true

java.util.Iterator<E>
boolean hasNext()    如果存在可访问的元素，返回true
E next()    返回将要访问的下一个对象
void remove()    删除上次访问的元素

java.util.List<E>
ListIterator<E> listIterator()
ListIterator<E> listIterator(int index)
返回一个列表迭代器
迭代器第一次调用next返回给定位置元素
void add(int i, E element)
void addAll(int i, Colletion<? extend E> elements)    向集合指定位置添加元素
E remove(int i)    删除给定位置元素并返回
E get(int i)    获得给定位置元素并返回
E set(int i, E element)
设置给定位置元素并返回原来的元素
int indexOf(Object element)
int lastIndexOf(Object element)    返回与指定元素相等元素在列表中第一次出现的位置
返回与指定元素相等元素在列表中最后一次出现的位置
java.util.ListIterator<E>
void add(E Element)    在当前位置添加一个元素
void set(E Element)    用新元素代替next或previous上次访问的元素
boolean havaPrevious()    反向迭代列表时是否还有可供访问的值
E previous()    返回前一个对象
int nextIndex()    返回下一次调用next时返回的元素索引
int previousIndex()    返回下一次调用previous时返回的元素索引

java.util.ArrayList<E>
ArrayList<E>()
构造一个空数组列表
boolean add(E obj)    在数组列表尾端添加一个元素，永远返回true
int size()    返回存储在数组中的当前元素数量
void set(int index, E obj)    设置数组列表指定位置的值
E get(int index)    获的指定位置的元素值
void add(int index, E obj)    向后移动元素，插入元素
E remove(int index)    删除一个元素，并将后面元素前移

java.util.LinkedList<E>
LinkedList()
LinkedList(Colletion<? extend E> elements)    构造一个链表
void addFirst(E element)
void addLast(E element)    添加元素到表头或表尾
E getFirst()
E getLast()    返回表头或表尾的元素
E removeFirst()
E removeLast()    删除表头或表尾的元素并返回

java.util.HashSet<E>
HashSet()
HashSet(Colletion<? extend E> elements)
HashSet(int initialCapacity)    构造散列表

java.util.LinkedHashSet<E>
LinkedHashSet是用一个链表实现来扩展HashSet类，它支持对规则集内的元素排序。HashSet中的元素是没有被排序的，而LinkedHashSet中的元素可以按照它们插入规则集的顺序提取。

java.util.TreeSet<E>
TreeSet扩展自AbstractSet，并实现了NavigableSet，AbstractSet扩展自AbstractCollection，树形集是一个有序的Set，其底层是一颗树,用红黑树实现，这样就能从Set里面提取一个有序序列了。在实例化TreeSet时，我们可以给TreeSet指定一个比较器Comparator来指定树形集中的元素顺序。树形集中提供了很多便捷的方法。

java.util.Queue<E>(接口)
boolean add(E element)
boolean offer(E element)    如果队列没有满，将元素添加到队列尾部
E remove()
E poll()    如果队列不为空，删除并返回这个队列头部元素
E element()
E peek()    如果队列不为空，返回这个队列头部元素
java.util.Deque<E>
接口Deque，是一个扩展自Queue的双端队列，它支持在两端插入和删除元素，Deque接口由ArrayDeque和LinkedList这两个类实现，所以通常我们可以使用LinkedList来创建一个队列。PriorityQueue类实现了一个优先队列，优先队列中元素被赋予优先级，拥有高优先级的先被删除。

java.util.Map<K,V>
V get(Object key)
获得与键对应的值
V put(K key, V value)
V putAll(Map<? extends K, ? extends V> entries)    将键与对应的值关系插入到映射中
boolean containKey(Object key)
boolean containValue(Object value)    查询
java.util.HashMap<K,V>
HashMap是基于哈希表的Map接口的非同步实现，继承自AbstractMap，AbstractMap是部分实现Map接口的抽象类。在之前的版本中，HashMap采用数组+链表实现，即使用链表处理冲突，同一hash值的链表都存储在一个链表里。但是当链表中的元素较多，即hash值相等的元素较多时，通过key值依次查找的效率较低。而JDK1.8中，HashMap采用数组+链表+红黑树实现，当链表长度超过阈值（8）时，将链表转换为红黑树，这样大大减少了查找时间。

java.util.LinkedHashMap<K,V>
LinkedHashMap继承自HashMap，它主要是用链表实现来扩展HashMap类，HashMap中条目是没有顺序的，但是在LinkedHashMap中元素既可以按照它们插入图的顺序排序，也可以按它们最后一次被访问的顺序排序。

java.util.TreeHashMap<K,V>
TreeMap基于红黑树数据结构的实现，键值可以使用Comparable或Comparator接口来排序。TreeMap继承自AbstractMap，同时实现了接口NavigableMap，而接口NavigableMap则继承自SortedMap。SortedMap是Map的子接口，使用它可以确保图中的条目是排好序的。在实际使用中，如果更新图时不需要保持图中元素的顺序，就使用HashMap，如果需要保持图中元素的插入顺序或者访问顺序，就使用LinkedHashMap，如果需要使图按照键值排序，就使用TreeMap。

java.util.Vector<E>
用法上，Vector与ArrayList基本一致，不同之处在于Vector使用了关键字synchronized将访问和修改向量的方法都变成同步的了，所以对于不需要同步的应用程序来说，类ArrayList比类Vector更高效。

java.util.Stack<E>
Stack，栈类，是Java2之前引入的，继承自类Vector。

java.util.CopyOnWriteArraySet
CopyOnWriteArraySet，是一个线程安全的set接口的实现，它使用了ReentrantLock锁来保证在并发情况下提供高性能的并发读取。
ConcurrentLinkedQuerue是一个先进先出的队列。它是非阻塞队列。
ConcurrentSkipListMap可以在高效并发中替代SoredMap（例如用Collections.synchronzedMap包装的TreeMap）。
ConcurrentSkipListSet可以在高效并发中替代SoredSet（例如用Collections.synchronzedSet包装的TreeMap）。

java.lang.Runnable
void run()    必须覆盖这个方法
java.lang.Thread

Thread()
Thread(Runnable target)    构造器
void start()    启动线程
void run()    如果没有重写，调用关联Runnable的run方法
void interupt()    中断线程（中止阻塞状态，对运行线程无作用）
void setPriority(int newPriority)    设置优先级（1-10，默认5）
static void yield()
static void sleep(long millis)    使当前线程处于让步状态（让步于同优先级或高优先级线程）休眠
void setDaemon()    设置为守护线程
Thread.State getState()    获得线程当前状态



Java库中具体集合
ArrayList    一种可以动态增长和缩减的索引序列
LinkedList    一种可以在任何位置进行高效插入和删除操作的有序序列
ArrayDeque    一种用循环数组实现的双端队列
HashSet    一种没有重复元素的无序集合
TreeSet    一种有序集
EnumSet    一种包含枚举类型值的集合
LinkedHashSet    一种可以记住元素插入次序的集
PriorityQueue    一种允许高效删除最小元素的集合
HashMap    一种存储键/值关联的数据结构
TreeMap    一种键值有序排列的映射表
EnumMap    一种键值属于枚举类型的映射表
LinkedHashMap    一种可以记住键/值项添加次序的映射表
WeakHashMap    一种其值无用武之地后可以被垃圾回收期回收的映射表
IdentityHashMap    一种用==而不是用equals比较键值的映射表
