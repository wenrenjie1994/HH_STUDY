## 多线程 生产者和消费者

代码举例

```java

package testThread;

/**
 * 生产和消费不能同时进行
 */
public class ProducerAndConsumer {
    public static void main(String[] args) {
        Clerk c = new Clerk();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (c){
                    //无限循环代表生产次数
                    while (true){
                        if (c.productNum==0){
                            System.out.println("库存不足，开始生产");
                            while (c.productNum<4){
                                c.productNum++;
                                System.out.println("库存为: "+c.productNum);
                            }
                            System.out.println("生产完毕，最新库存为："+c.productNum);
                            //生产结束，唤醒消费者线程
                            c.notify();
                        }else {
                            try {
                                //生产者线程开始等待
                                c.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        },"生产者").start();

        new Thread(() -> {
            synchronized (c){
                while (true){
                    if (c.productNum==4){
                        System.out.println("库存足，开始消费");
                        while (c.productNum>0){
                            c.productNum--;
                            System.out.println("库存为: "+c.productNum);
                        }
                        System.out.println("消费完毕，最新库存为："+c.productNum);
                        //消费完毕，启动生产者
                        c.notify();
                    }else {
                        try {
                            //消费者线程开始等待
                            c.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        },"消费者").start();
    }
}

class Clerk{
    public static int productNum = 0;
}
```

<img src="/Users/lafeier/Library/Application Support/typora-user-images/截屏2020-08-06 下午11.02.54.png" alt="截屏2020-08-06 下午11.02.54" style="zoom:50%;" />



**线程并发协作总结：**

   线程并发协作(也叫线程通信)，通常用于生产者/消费者模式，情景如下：

1. 生产者和消费者共享同一个资源，并且生产者和消费者之间相互依赖，互为条件。

2. 对于生产者，没有生产产品之前，消费者要进入等待状态。而生产了产品之后，又需要马上通知消费者消费。

3. 对于消费者，在消费之后，要通知生产者已经消费结束，需要继续生产新产品以供消费。

4. 在生产者消费者问题中，仅有synchronized是不够的。

​    · synchronized可阻止并发更新同一个共享资源，实现了同步;

​    · synchronized不能用来实现不同线程之间的消息传递(通信)。

5. 那线程是通过哪些方法来进行消息传递(通信)的呢?见如下总结：

![表11-2 线程通信常用方法.png](https://www.sxt.cn/360shop/Public/admin/UEditor/20170526/1495792837120930.png)

   6. 以上方法均是java.lang.Object类的方法;

   都只能在同步方法或者同步代码块中使用，否则会抛出异常。