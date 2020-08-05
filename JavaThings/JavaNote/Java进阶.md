# Java进阶学习笔记

## Java基础09

### 多线程（Threads）

#### 1. 一些基础

+ 程序(program)：一组指令的集合，也就是一段静态的代码
+ 进程(process)：程序的一次执行过程，是资源分配的单位
+ 线程(thread)：是一个程序内部的一条执行路径，作为调度和执行的单位，拥有独立的运行栈和程序计数器(pc)

+ 单核CPU和多核CPU
  - 单核CPU，假的多线程
  - 多核CPU，更好的发挥多线程的效率
  - 一个Java应用程序的java.exe，至少有三个线程：main( )主线程、gc( )垃圾回收线程、异常处理线程。发生异常会影响主线程
+ 并行与并发
  - 并行，多个CPU同时处理多个任务
  - 并发，CPU采用时间片轮转同时执行多个任务



#### 2. 多线程的优点

> 即便是单核CPU下，多线程的效率更低，但仍有许多优点：

1. 提高应用程序的相应

2. 提高计算机系统CPU的利用率

3. 改善程序结构，将复杂的进程分为多个线程，独立运行

> 为何需要多线程？

+ 程序需要同时执行多个任务
+ 程序需要进行一些等待任务
+ 程序需要后台运行



#### 3. 多线程的创建和使用

> ``Thread类``的有关方法

+ ``void start()``：启动线程，执行对象的``run()``方法
+ ``run()``：线程在被调度时执行的操作
+ ``String getName()``：返回线程的名称
+ ``void setName(String name)``：设置该线程的名称
+ ``static Thread currentThread()``：返回当前线程。在Thread子类中就是this，通常用于主线程和Runnable实现类
+ ``yield()``：释放当前线程的CPU使用权
+ ``join()``：在线程A中调用线程B的``join()``方法，线程A进入阻塞状态，直到线程B完全执行完以后，线程A结束阻塞状态**（本身会报异常）**
+ ``stop()``：强行结束当前线程（不建议使用）
+ ``sleep(long millitime)``：让当前线程睡眠指定的millitime毫秒数，当前的线程为阻塞状态
+ ``isAlive()``：判断当前线程是否还存活



##### 1）方式一：继承``Thread``类

> ``Java``的``JVM``允许程序运行多个线程，通过``java.lang.Thread类``来实现

```java
public class ThreadTest {
    public static void main(String[] args) {
        //3. 创建子类对象
        MyThread mythread = new MyThread();
        
        //4. 调用start()，启动当前线程，调用当前线程的run()
        mythread.start();
        
        //创建Thread类的匿名子类
        new Thread() {
            @Override
            public void run() {
                /*线程-2
                do somethings*/
            }
        }.start();
        
        /*主线程
        do somethings*/
        try {
            if (...) {
                mythread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

//1. 继承Thread类
class MyThread extends Thread {
    //2. 重写run()方法
    @Override
    public void run() {
        /*线程-1的操作
        do something;*/
       	
        if (...) {
        	//释放CPU
            yield();
        }
    }
}
```

> 1. 只能用``start()``启动线程，不能直接调用``run()``的方式启动线程，否则只是相当于顺序调用子类的方法
> 2. 不能再``start()``已经``start()``的线程，否则出现``IllegalThreadException``异常，但可以再``new``一个线程对象去``start()``



##### 2）方式二：实现``Runnable``接口

```java
public class ThreadTest02 {
    public static void main(String[] args) {
        //3. 创建实现类的对象
        MyThread myThread1 = new MyThread();

        //4. 将对象作为参数传递到Tread类的构造器中，创建Thread对象
        Thread thread1 = new Thread(myThread1);

        //5. 调用start()，①启动线程，②调用该线程的run()，调用了Runnable类型的target的run()
        thread1.start();
    }
}

//1. 创建一个实现了Runnable接口的类
class MyThread implements Runnable {
    //2. 实现类重写run()方法
    @Override
    public void run() {
        for (int i=0; i<=100; i++) {
            if (i%2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}
```



##### 3）两种方式的对比

1. 均需要重写``run()``方法
2. ``Java``是单继承的，如果有显示继承的类，那么则不能用继承``Thread类``的方式创建多线程
3. 如果创建多线程有共享的数据，采用继承``Thread类``的方式需要采用``static``；而实现``Runnable接口``的方式天然共享其中的数据
4. ``Thread类``本身也实现了``Runnable接口``



#### 4. 线程的调度

+ 调度策略
  - 时间片轮转
  - 抢占式
+ Java的调度方法
  - 先来先服务(FCFS)
  - 优先权调度



##### 1）线程的优先级

+ 优先等级
  - MAX_PRIORITY: 10
  - NORM_PRIORITY:  5
  - MIN_PRIORITY:  1
+ 方法
  - ``getPriority()``：返回线程的优先值
  - ``setPriority(int p)``：改变线程的优先级
+ 说明
  - 线程创建时继承父线程的优先级
  - 低优先级线程只是获得**调度的概率低**，并不是一定在高优先级线程之后调度



#### 5. 线程的生命周期

+ JDK中用``Thread.State类``定义了几种线程状态
  - 新建：一个``Thread类``或其子类的对象被声明并创建时
  - 就绪：新建状态的线程被``start()``后，等待分配CPU资源时
  - 运行：就绪的线程获得CPU执行权，执行``run()``
  - 阻塞：特殊情况下，被挂起回执行IO操作时
  - 消亡：线程完成了全部工作，或提前被强制中止，或出现异常



#### 6. 线程安全问题

> 通过同步机制

##### 1）方式一：同步代码块

```java
//操作共享数据的代码
synchronized (同步监视器) {
    //需要被同步的代码
}
//同步监视器：锁。任何一个类的对象都可以当锁，且多个线程共用同一把锁

Object obj = new Object();
synchronized (obj) {
    //
}
```

+ 实现类：天然共享数据，最方便使用``this``对象
+ 继承Thread：需要将共享数据声明为``static``



##### 2）方式二：同步方法

> 1. 解决Runnable接口的线程安全

```java
//同步监视器，this 
public synchronized void method() {

}
```

> 2. 解决继承Thread类的线程安全

```java
//同步监视器，当前类
public static synchronized void method() {
    //共享代码
}
```



##### 3）线程死锁

+ 死锁
  - 两个或两个以上的进程在执行过程中，由于竞争资源或者由于彼此通信而造成的一种阻塞的现象，若无外力作用，它们都将无法推进下去
  - 不是异常、不会有提示、只是处于阻塞态
+ 解决办法
  - 专门的算法
  - 减少同步资源
  - 避免嵌套同步



##### 4）方式三：Lock(锁)

+ JDK5.0开始，Java提供了线程同步机制——通过显示定义同步锁对象来实现同步，同步锁使用Lock对象充当
+ ``java.util.concurrent.locks.Lock接口``是控制多个线程对共享资源进行访问的工具。锁提供了对共享资源的独占访问，每次只能有一个线程对Lock对象加锁
+ **``ReentrantLock类``**实现了Lock，它拥有与synchronized相同的并发性和内存语义

```java
class Window implements Runnable {
    private int ticeket = 100;
    
    //1. instantiate ReentrantLock object
    private ReentrantLock lock = new ReentrantLock();
    
    @Override
    public void run() {
        while (true) {
            try {
                //2. call lock() method
                lock.lock();
                
                if (ticket > 0) {
                    System.out.println(Thread.currentThread.getName() + ": sell ticket number is " ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                //3. call unlock() method
                lock.unlock();
            }
            
        }
    }
}
```



***面试题：***

***``synchronized`` 与  ``lock`` 的异同***

+ 均解决线程安全问题
+ ``synchronized机制``在执行完同步代码后自动释放同步监视器（锁）
+ ``lock``需要手动启动（``lock()``）和释放同步（``unlock()``）



##### 5）线程通信

1. ``wait()``

> 有异常
>
> 当前线程进入阻塞状态，并释放同步监视器

2. ``notify()``

> 唤醒被``wait``的另一个线程，如果存在多个阻塞的线程，则唤醒优先级高的那一个

2. ``notifyAll()``

> 唤醒所有被``wait``的线程

*说明：*

+ ***``wait()、notify()、notifyAll()``只能出现在同步代码块或者同步方法中，即``synchronized(obj){}``中***

+ ***调用者必须是同步代码块或者同步方法中的同步监视器，也就是说``synchronized(obj)``中的同步监视器obj，那么调用者也必须是obj，否则会出现``IllegleMonitorStateException``***
+ ***``wait()、notify()、notifyAll()``定义在``java.lang.Object类``中***



***面试题：***

***``sleep()`` 和 ``wait()`` 的异同***

1. 相同点：均可使当前线程进入阻塞状态
2. 不同点：
   + 声明的位置不同：``Thread类``中声明``sleep()``，``Object类``中声明``wait()``
   + 调用的范围不同：任何场景可以调用``sleep()``，``wait()``必须使用在同步代码块 或同步方法中
   + 是否释放同步监视器：如果两者都在同步代码块或同步方法中，``sleep()``不会释放锁，``wait()``会释放锁



#### 7. 新增线程创建方式

##### 1）方式三：实现``Callable接口``

> 与Runnable相比，Callable功能更强大

+ 相比run()方法，可以有返回值
+ 方法可以抛出异常
+ 支持泛型的返回值
+ 需要借助``FutureTask类``，比如获取返回结果

> ``Futher接口``

+ 可以对``Runnable、Callable``任务的执行结果进行取消、查询是否完成、获取结果等
+ **``FutureTask``是``Future接口``的唯一实现类**
+ ``FutureTask``同时实现了``Runnable、Future接口``，它既可以作为``Runnable``被线程执行，又可以作为``Future``得到``Callable``的返回值

```java
//1. 创建一个实现Callable的实现类
class ThreadA implements Callable {
    //2. 实现call()方法，将此线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception {
        //可以返回int（被封装成Integer返回）、String等
        return null;
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        //3. 创建Callable接口实现类的对象
        ThreadA threadA = new ThreadA();
        
        //4. 将此Callable接口实现类的对象作为参数传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask futureTask = new FutureTask(threadA);
        
        //5. 将FutureTask类的对象作为参数传递到Thread类的构造器中，创建Thread类的对象，并调用start()，启动线程
        new Thread(futureTask).start();
        
        //得到返回值
        try {
            //6. 获取Callable中的call方法返回值
            //get()返回值即为FutureTask构造器参数Callable实现类重写call()的返回值
            Object obj = futureTask.get();
            System.out.println(obj);
        } catch (InterrupedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
```



##### 2）方式四：使用线程池

> **线程池相关API：``ExecuotorService``和``Executors``**

+ ``ExecutorService``：真正的线程池接口，常见子类``ThreadPoolExecutor``
  - ``void execute(Runnable command)``：执行任务/命令，没有返回值，一般用来执行Runnable
  - ``<T>Future<T>submit(Callable<T>task)``：执行任务，有返回值，一般用来执行Callable
  - ``void shutdown()``：关闭连接池
+ ``Executors``：工具类、线程池的工厂类，用于创建并返回不同类型的线程池
  - ``Executors.newCachedThreadPool()``：创建一个可根据需要创建新线程得线程池
  - ``Executors.newFixedThradPool(n)``：创建一个可重用固定线程数的线程池
  - ``Executors.newSingleThreadExecutor()``：创建一个只有一个线程的线程池
  - ``Executors.newScheduledThreadPool(n)``：创建一个线程池，它可安排在给定延迟后运行命令或定期地执行

```java
//1. 提供指定线程数的线程池
ExecutorService service = Executors.newFixedThreadPool(10);

//设置线程池的属性
ThreadPoolExecutor ser = (ThreadPoolExecutor)service;
ser.setCorePoolSize(15);
ser.setKeepAliveTime(10);

//2. 执行指定的线程的操作，需要提供一个实现Runnable或Callable接口的实现类的对象
service.execute(Runnable runnable);          //适用于Runnable
//        service.submit(Callable callable);           //适用于Callable

//3. 关闭连接池
service.shutdown();
```



## Java基础10

### String类

#### 1. 特性

+ 字符串
+ ``String``是一个``final类``，代表**不可变**的字符序列，不能被继承
  - 当对字符串重新赋值时，需重写指定内存区域赋值，不能在原有的value数组进行赋值
  - 进行拼接操作时，也需重新指定内存区域赋值
  - 调用``replace()``方法时，也要重新指定内存区域赋值赋给新变量
+ ``String``对象的字符内容是存储在一个字符数组``value[]``中的
+ 实现了``Serializable接口``和``Comparable接口``，表示支持序列化和可比较大小



#### 2. 创建

> ``String``的实例化方式

```java
//字面量赋值，str1和str2的数据javaEE声明在方法区的字符串常量池中
String s1 = "javaEE";
String s2 = "javaEE";

//new + 构造器，str3和str4保存的地址值，在堆空间保存数据的地址值
//创建了两个对象，一个是堆空间new的结构，另一个是char[]数组对应的常量池中的数据"javaEE"
String s3 = new String("javaEE");
String s4 = new String("javaEE");

String s5 = s3.intren();			//intern()的返回值在常量池中

System.out.println(s1 == s2);		//true
System.out.println(s1 == s3);		//false
System.out.println(s3 == s4);		//false
System.out.println(s2 == s5);   	//true
```



#### 3. 方法

##### 1）String--->包装类

```java
int num = Integer.parseInt(str);
String str = String.valueOf(num);
```

##### 2）String--->char[]

```java
char[] charArray = str.toCharArray();
String str = new String(charArray);
```

##### 3）String--->byte[]

```java
//默认编码方式
byte[] bytes = str.getBytes();
//默认解码方式
String str = new String(bytes);
```

```java
//指定gbk字符集进行编码
byte[] gbks = str.getBytes("gbk");
//乱码，编码和解码方式不一致
String str = new String(gbks);
//指定gbk字符集进行解码
String str = new String(gbks, "gbk");
```



### ``StringBuffer类``和``StringBulider类``

> 均是可变的字符序列

#### 1. StringBuffer

> 线程安全的，效率较低

#### 2. StringBuilder

> 线程不安全，效率高



### 日期时间API

#### 1. JDK8之前

##### 1）时间戳

> 返回当前时间与1970年1月1日0时0分0秒以毫秒记的时间差

``long time = System.currentTimeMillis()``



##### 2）Date类

> ``java.util.Date``

+ 构造器的使用

  ```java
  import java.util.Date;
  
  //创建当前时间的Date对象
  Date date1 = new Date();
  //显示当前的年、月、日、时、分、秒
  System.out.println(date1.toString());
  //时间戳
  System.out.println(date.getTime());
  
  //创建指定毫秒数的Date对象
  Date date2 = new Date(1550306204104L);
  
  //java.util.Date的子类java.sql.Date
  java.sql.Date date3 = new java.sql.Date(550306204104L);
  
  //java.util.Date--->java.sql.Date
  Date date3 = new Date();
  java.sql.Date date4 = new java.sql.Date(date6.getTime());
  ```



##### 3）``java.text.SimpleDateFormat类``

> 对日期Date类的格式化和解析

```java
//实例化，默认构造器
SimpleDateFormat sdf = new SimpleDateFormat();

//格式化：日期--->字符串
Date date = new Date();
String format = sdf.format(date);

//解析：字符串--->日期
String str = "19-2-18 上午9:00";
Date date = sdf.parse(str);			//会抛异常

//实例化，指定格式
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
System.out.println(sdf.format(date));
```



##### 4）java.util.Calendar

> 抽象类

```java
//实例化，1. 创建子类对象GregorianCalendar的对象
//实例化，2. 调用其静态方法getInstance()
Calendar calendar = Calendar.getInstance();
System.out.println(calendar.getClass());			//GregorianCalendar

//常用方法
//get()
int days = calendar.get(Calendar.DAY_OF_MONTH);

//set()
calendar.set(Calendar.DAY_OF_MONTH, 22);

//add()
calendar.add(Calendar.DAY_OF_MONTH, 3);

//getTime()：日历类--->Date
Date date = calendar.getTime();

//setTime()：Date--->日历类
Date date = new Date();
//具有可变性
calendar.setTime(date);
```



#### 2. JDK8的新日期API

##### 1）LocalDate、LocalTime、LocalDateTime

```java
//实例化：now()：获取当前的日期、时间、日期时间
LocalDate localDate = LocalDate.now();
LocalTime localTime = LocalTime.now();
LocalDateTime localDateTime = LocalDateTime.now();

//of()：设置指定的年月、日、时、分、秒
LocalDateTime localDateTime1 = LocalDateTime.of(2019, 10, 1, 9, 40, 0);

//getXxx()
System.out.println(localDateTime.getDayOfMonth());

//withXxx()：设置相关属性
//不可变性
```



##### 2）Instant：瞬时

```java
//实例化：now()：本初子午线标准时间
Instant instant = Instant.now();
//添加时间的偏移量
OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
System.out.println(offsetDateTime);

//获取时间戳
long milli = instant.toEpochMilli();
//通过给定的毫秒数获取Instant实例
Instant instant1 = Instant.ofEpochMilli(159653513587L);
```



##### 3）``java.time.format.DateTimeFormatter``

> 格式化或者解析时间

```java
//预定义
DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
//格式化：日期--->字符串
LocalDateTime localDateTime = LocalDateTime.now();
String str1 = formatter.format(localDateTime);

//解析：字符串-->日期
TemporalAccessor parse = formatter.parse("2019-10-01T9:40:20.797");
```

```java
//本地化相关的格式
DateTimeFormatter formatter = DateTimeFormatter.ofLocalizeDateTime(FormatStyle.SHORT);
//格式化
String str2 = formatter.format(localDateTime);
```

```java
//自定义格式：如ofPatten("yyyy-MM-dd hh:mm:ss")
DateTimeFormatter formatter = DateTimeFormatter.ofPatten("yyyy-MM-dd hh:mm:ss");
//格式化
String str3 = formatter.format(LocalDateTime.now());
//解析
TemporalAccessor accessor = formatter.parse("2019-10-01");
```



### Java比较器

> 正常情况下，Java中只能比较``==`` 或`` !=``，不能使用``>`` 、``< ``；如何比较两个对象的大小，使用两个接口：``Comparable``或``Comparator``

#### 1. Comparable

> 自然排序

+ String、包装类实现了Comparable接口，重写了compareTo()方法，比较两个对象大小

+ 重写``compareTo()``的规则
  - 当前对象this大于形参对象obj，返回正整数
  - 当前对象this小于形参对象obj，返回负整数
  - 当前对象this等于形参对象obj，返回零

+ 自定义类实现Comparable接口，重写``compareTo(obj)``，在``compareTo(obj)``方法中指明如何排序

```java
class Goods implements Comparable {
    private int value;
    private String str;
    
    @Override
    public int compareTo(Objcet o) {
        if (o instanceof Object) {
            if (this.getName().equals(o.getName())) {
                if (this.getValue() > o.getVaule()) {
                    return 1;
                } else if (this.getValue() < o.getValue()) {
                    return -1;
                } else {
                    return 0;
                }
            } else {
                return this.getStr().compareTo(o.getStr());
            }
        }
        throw new RuntimeException("...");
    }
}
```



#### 2. Comparator

> 定制排序

```java
class Goods {
    private int value;
    private String str;
}

Goods[] arr = new Goods[5];
Arrays.sort(arr, new Comparator() {
   @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Goods && o2 instanceof Goods) {
            Goods g1 = (Goods)o1;
            Goods g2 = (Goods)o2;
            if (g1.getValue() == g2.getValue()) {
                return g1.getStr().compareTo(g2.getStr());
            } else {
                return -Integer.compare(g1.getValue(), g2.getValue());
            }
        }
        throw new RuntimeException("...");
    } 
});

System.out.println(Arrays.toString(arr));
```



### System类

> + java.lang包
> + 构造器是private的，无法实例化，成员变量和成员方法都是static的
> + 成员变量
>   - in
>   - out
>   - err
> + 成员方法
>   - ``native long currentTimeMillis()``
>   - ``void exit(int status)``
>   - ``void gc()``：请求系统进行垃圾回收
>   - ``String getProperty(String key)``：获取系统中属性名为key的属性对应的值



### Math类



### ``BigInteger``与``BigDecimal``



## Java基础11

### 枚举类

#### 1. JDK5.0以前

> + 类的对象是有限个的，确定的
> + 需要定义一组常量时，建议使用枚举类
> + 如果枚举类只有一个对象，则作为单例模式的实现方式

```java
class Season {
    //1. 声明属性是private final
    private final String Name;
    private final String Desc;
    //2. 私有化构造器，并给属性赋值
    private Season(String Name, String Desc) {
        this.Name = Name;
        this.Desc = Desc;
    }
    //3. 提供枚举类对象，声明为public static final
    public static final Season SPRING = new Season("春天", "百花齐放");
    public static final Season SUMMER = new Season("夏天", "映日荷花");
    public static final Season AUTUMN = new Season("秋天", "金色大地");
    public static final Season WINTER = new Season("冬天", "白雪皑皑");
    //4. 其他诉求，获取枚举类对象的属性
    public String getName() {
        return Name;
    }
    public String getDesc() {
        return Desc;
    }
    @Override
    public String toString() {
        return "Season{Name: " + Name + ", Desc: " + Desc + "}";
    }
}
```



#### 2. 枚举类的实现

> + 用enum关键字定义枚举类
>
> + 默认继承于``java.lang.Enum``类

```java
enum Season {
    //1. 一开始就需要提供枚举类对象，每个对象之间用逗号隔开
    SPRING("春天", "百花齐放");
    SUMMER("夏天", "映日荷花"),
    AUTUMN("秋天", "金色大地"),
    Season("冬天", "白雪皑皑");
    
    //2. 声明属性是private final
    private final String Name;
    private final String Desc;

    //3. 私有化构造器，并给属性赋值
    private Season(String Name, String Desc) {
        this.Name = Name;
        this.Desc = Desc;
    }

    //4. 其他诉求，获取枚举类对象的属性，不必重写toString()
    public String getName() {
        return Name;
    }
    public String getDesc() {
        return Desc;
    }
}

System.out.println(Season.AUTUMN);			//output: AUTUMN
```



#### 3. Enum的主要方法

+ ``values()``
+ ``valueOf(String str)``
+ ``toString()``
+ 



### 注解

