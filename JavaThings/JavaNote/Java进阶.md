# Java进阶学习笔记

## Java基础09

### 多线程（Threads）

#### 一些基础

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



#### 多线程的优点

> 即便是单核CPU下，多线程的效率更低，但仍有许多优点：

1. 提高应用程序的相应

2. 提高计算机系统CPU的利用率

3. 改善程序结构，将复杂的进程分为多个线程，独立运行

> 为何需要多线程？

+ 程序需要同时执行多个任务
+ 程序需要进行一些等待任务
+ 程序需要后台运行



#### 多线程的创建和使用

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

##### 方式一：``Thread``类

> ``Java``的``JVM``允许程序运行多个线程，通过``java.lang.Thread类``来实现

```java
public class ThreadTest {
    public static void main(String[] args) {
        //创建子类对象
        MyThread mythread = new MyThread();
        
        //调用start()，启动当前线程，调用当前线程的run()
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

//继承Thread类
class MyThread extends Thread {
    //重写run()方法
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

##### 方式二：实现``Runnable``接口







#### 线程的调度

+ 调度策略
  - 时间片轮转
  - 抢占式
+ Java的调度方法
  - 先来先服务(FCFS)
  - 优先权调度

##### 线程的优先级

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

