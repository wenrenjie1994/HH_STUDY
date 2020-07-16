import multiplethread.Hero;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThread {
    // public static void main(String[] args) {
    // Hero gareen = new Hero();
    // gareen.name = "盖伦";
    // gareen.hp = 616;
    // gareen.damage = 50;

    // Hero teemo = new Hero();
    // teemo.name = "提莫";
    // teemo.hp = 300;
    // teemo.damage = 30;

    // Hero bh = new Hero();
    // bh.name = "赏金猎人";
    // bh.hp = 500;
    // bh.damage = 65;

    // Hero leesin = new Hero();
    // leesin.name = "盲僧";
    // leesin.hp = 455;
    // leesin.damage = 80;

    // 不使用多线程的情况：盖伦杀死提莫后，赏金猎人才开始杀盲僧
    // 盖伦攻击提莫
    // while(!teemo.isDead()){
    // gareen.attackHero(teemo);
    // }

    // //赏金猎人攻击盲僧
    // while(!leesin.isDead()){
    // bh.attackHero(leesin);
    // }

    // 设计一个类KillThread 继承Thread，并且重写run方法
    // 启动线程办法： 实例化一个KillThread对象，并且调用其start方法
    // KillThread killThread1 = new KillThread(gareen, teemo);
    // killThread1.start();
    // KillThread killThread2 = new KillThread(bh, leesin);
    // killThread2.start();

    // 使用Runnable接口创建多线程
    // 启动的时候，首先创建一个Battle对象，
    // 然后再根据该battle对象创建一个线程对象，并启动
    // Battle battle1 = new Battle(gareen, teemo);
    // new Thread(battle1).start();
    // Battle battle2 = new Battle(bh, leesin);
    // new Thread(battle2).start();

    // 使用匿名类创建多线程
    // 继承Thread,重写run方法，直接在run方法中写业务代码
    // Thread t1 = new Thread() {
    // public void run() {
    // while (!teemo.isDead()) {
    // gareen.attackHero(teemo);
    // }
    // }
    // };
    // t1.start();

    // Thread t2 = new Thread() {
    // public void run() {
    // while (!leesin.isDead()) {
    // bh.attackHero(leesin);
    // }
    // }
    // };
    // t2.start();

    // 把上述3种方式再整理一下：

    // 1. 继承Thread类
    // 2. 实现Runnable接口
    // 3. 匿名类的方式

    // 注： 启动线程是start()方法，run()并不能启动一个新的线程

    // Thread.sleep()当前线程暂停
    // Thread t1 = new Thread(){
    // public void run(){
    // int seconds = 0;
    // while(true){
    // try{
    // Thread.sleep(1000);
    // }catch(InterruptedException e){
    // e.printStackTrace();
    // }
    // System.out.printf("已经玩了LOL %d秒%n",seconds++);
    // }
    // }
    // };
    // t1.start();

    // Thread.join()加入到当前线程中
    // 主线程会等待该线程结束完毕， 才会往下运行
    // final Hero gareen = new Hero();
    // gareen.name = "盖伦";
    // gareen.hp = 616;
    // gareen.damage = 50;

    // final Hero teemo = new Hero();
    // teemo.name = "提莫";
    // teemo.hp = 300;
    // teemo.damage = 30;

    // final Hero bh = new Hero();
    // bh.name = "赏金猎人";
    // bh.hp = 500;
    // bh.damage = 65;

    // final Hero leesin = new Hero();
    // leesin.name = "盲僧";
    // leesin.hp = 455;
    // leesin.damage = 80;

    // Thread t1 = new Thread() {
    // public void run() {
    // while (!teemo.isDead()) {
    // gareen.attackHero(teemo);
    // }
    // }
    // };

    // t1.start();

    // // 代码执行到这里，一直是main线程在运行
    // try {
    // // t1线程加入到main线程中来，
    // // 只有t1线程运行结束，才会继续往下走
    // t1.join();
    // } catch (InterruptedException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }

    // Thread t2 = new Thread() {
    // public void run() {
    // while (!leesin.isDead()) {
    // bh.attackHero(leesin);
    // }
    // }
    // };
    // // 会观察到盖伦把提莫杀掉后，才运行t2线程
    // t2.start();

    // 设置线程的优先级
    // final Hero gareen = new Hero();
    // gareen.name = "盖伦";
    // gareen.hp = 6160;
    // gareen.damage = 1;

    // final Hero teemo = new Hero();
    // teemo.name = "提莫";
    // teemo.hp = 3000;
    // teemo.damage = 1;

    // final Hero bh = new Hero();
    // bh.name = "赏金猎人";
    // bh.hp = 5000;
    // bh.damage = 1;

    // final Hero leesin = new Hero();
    // leesin.name = "盲僧";
    // leesin.hp = 4505;
    // leesin.damage = 1;

    // Thread t1= new Thread(){
    // public void run(){

    // while(!teemo.isDead()){
    // gareen.attackHero(teemo);
    // }
    // }
    // };

    // Thread t2= new Thread(){
    // public void run(){
    // while(!leesin.isDead()){
    // //临时暂停，使得t1有更多机会使用CPU资源
    // Thread.yield();
    // bh.attackHero(leesin);
    // }
    // }
    // };

    // 两个线程会抢占CPU，但t1优先级较高，所以会先运行完
    // t1.setPriority(Thread.MAX_PRIORITY);
    // t2.setPriority(Thread.MIN_PRIORITY);

    // t1.setPriority(5);
    // t2.setPriority(5);
    // t1.start();
    // t2.start();

    // 守护线程：
    // 当一个进程里，所有的线程都是守护线程的时候，结束当前进程。
    // 通常会被用来做日志，性能统计等工作。
    // Thread t1 = new Thread() {
    // public void run() {
    // int seconds = 0;

    // while (true) {
    // try {
    // Thread.sleep(1000);
    // } catch (InterruptedException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // System.out.printf("已经玩了LOL %d 秒%n", seconds++);

    // }
    // }
    // };
    // t1.setDaemon(true);
    // t1.start();

    // final Hero gareen = new Hero();
    // gareen.name = "盖伦";
    // gareen.hp = 10000;

    // System.out.printf("盖伦的初始血量是 %.0f%n", gareen.hp);
    // 多线程同步问题指的是多个线程同时修改一个数据的时候，导致的问题

    // 假设盖伦有10000滴血，并且在基地里，同时又被对方多个英雄攻击

    // 用JAVA代码来表示，就是有多个线程在减少盖伦的hp
    // 同时又有多个线程在恢复盖伦的hp

    // n个线程增加盖伦的hp
    // int n = 10000;
    // Thread[] addThreads = new Thread[n];
    // Thread[] reduceThreads = new Thread[n];
    // for (int i = 0; i < n; i++) {
    // Thread t = new Thread() {
    // public void run() {
    // gareen.recover();
    // try {
    // Thread.sleep(100);
    // } catch (Exception e) {
    // // TODO: handle exception
    // e.printStackTrace();
    // }
    // }
    // };
    // t.start();
    // addThreads[i] = t;
    // }

    // // n个线程减少盖伦的hp
    // for (int i = 0; i < n; i++) {
    // Thread t = new Thread() {
    // public void run() {
    // gareen.hurt();
    // try {
    // Thread.sleep(100);
    // } catch (InterruptedException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }
    // };
    // t.start();
    // reduceThreads[i] = t;
    // }
    // // 等待所有增加线程结束
    // for (Thread t : addThreads) {
    // try {
    // t.join();
    // } catch (InterruptedException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }
    // // 等待所有减少线程结束
    // for (Thread t : reduceThreads) {
    // try {
    // t.join();
    // } catch (InterruptedException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }
    // // 代码执行到这里，所有增加和减少线程都结束了

    // // 增加和减少线程的数量是一样的，每次都增加，减少1.
    // // 那么所有线程都结束后，盖伦的hp应该还是初始值

    // // 但是事实上观察到的是：

    // System.out.printf("%d个增加线程和%d个减少线程结束后%n盖伦的血量变成了 %.0f%n", n, n, gareen.hp);

    // 这是因为产生了脏数据，增加运算还没来得及修改Hp的值，减少线程就来了
    // 总体解决思路是： 在增加线程访问hp期间，其他线程不可以访问hp
    // }

    // synchronized 同步对象概念
    // synchronized表示当前线程，独占对象 someObject
    // 释放同步对象的方式： synchronized块自然结束，或者有异常抛出
    // public static String now() {
    // return new SimpleDateFormat("HH:mm:ss").format(new Date());
    // }

    // public static void main(String[] args) {
    // final Object someObject = new Object();

    // Thread t1 = new Thread() {
    // public void run() {
    // try {
    // System.out.println(now() + " t1 线程已经运行");
    // System.out.println(now() + this.getName() + " 试图占有对象：someObject");
    // synchronized (someObject) {

    // System.out.println(now() + this.getName() + " 占有对象：someObject");
    // Thread.sleep(5000);
    // System.out.println(now() + this.getName() + " 释放对象：someObject");
    // }
    // System.out.println(now() + " t1 线程结束");
    // } catch (InterruptedException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }
    // };
    // t1.setName(" t1");
    // t1.start();
    // Thread t2 = new Thread() {

    // public void run() {
    // try {
    // System.out.println(now() + " t2 线程已经运行");
    // System.out.println(now() + this.getName() + " 试图占有对象：someObject");
    // synchronized (someObject) {
    // System.out.println(now() + this.getName() + " 占有对象：someObject");
    // Thread.sleep(5000);
    // System.out.println(now() + this.getName() + " 释放对象：someObject");
    // }
    // System.out.println(now() + " t2 线程结束");
    // } catch (InterruptedException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }
    // };
    // t2.setName(" t2");
    // t2.start();
    // }

    // 使用synchronized 解决同步问题
    // public static void main(String[] args) {

    // final Object someObject = new Object();

    // final Hero gareen = new Hero();
    // gareen.name = "盖伦";
    // gareen.hp = 10000;

    // int n = 10000;

    // Thread[] addThreads = new Thread[n];
    // Thread[] reduceThreads = new Thread[n];

    // for (int i = 0; i < n; i++) {
    // Thread t = new Thread() {
    // public void run() {

    // // 任何线程要修改hp的值，必须先占用someObject
    // synchronized (someObject) {
    // gareen.recover();
    // }

    // try {
    // Thread.sleep(100);
    // } catch (InterruptedException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }
    // };
    // t.start();
    // addThreads[i] = t;

    // }

    // for (int i = 0; i < n; i++) {
    // Thread t = new Thread() {
    // public void run() {
    // // 任何线程要修改hp的值，必须先占用someObject
    // synchronized (someObject) {
    // gareen.hurt();
    // }

    // try {
    // Thread.sleep(100);
    // } catch (InterruptedException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }
    // };
    // t.start();
    // reduceThreads[i] = t;
    // }

    // for (Thread t : addThreads) {
    // try {
    // t.join();
    // } catch (InterruptedException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }
    // for (Thread t : reduceThreads) {
    // try {
    // t.join();
    // } catch (InterruptedException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }
    // System.out.printf("%d个增加线程和%d个减少线程结束后%n盖伦的血量是 %.0f%n", n, n, gareen.hp);
    // }

    // 使用hero对象作为同步对象
    // 或者在方法前加上修饰符synchronized都可以和上述效果一致
    // 如果一个类，其方法都是有synchronized修饰的，
    // 那么该类就叫做线程安全的类
    // StringBuffer的方法都是有synchronized修饰的，StringBuffer就叫做线程安全的类
    // 而StringBuilder就不是线程安全的类
    // public static void main(String[] args) {

    // final Hero gareen = new Hero();
    // gareen.name = "盖伦";
    // gareen.hp = 10000;

    // int n = 10000;

    // Thread[] addThreads = new Thread[n];
    // Thread[] reduceThreads = new Thread[n];

    // for (int i = 0; i < n; i++) {
    // Thread t = new Thread() {
    // public void run() {

    // // recover自带synchronized
    // gareen.recover();

    // try {
    // Thread.sleep(100);
    // } catch (InterruptedException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }
    // };
    // t.start();
    // addThreads[i] = t;

    // }

    // for (int i = 0; i < n; i++) {
    // Thread t = new Thread() {
    // public void run() {
    // // hurt自带synchronized
    // gareen.hurt();

    // try {
    // Thread.sleep(100);
    // } catch (InterruptedException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }
    // };
    // t.start();
    // reduceThreads[i] = t;
    // }

    // for (Thread t : addThreads) {
    // try {
    // t.join();
    // } catch (InterruptedException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }
    // for (Thread t : reduceThreads) {
    // try {
    // t.join();
    // } catch (InterruptedException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }

    // System.out.printf("%d个增加线程和%d个减少线程结束后%n盖伦的血量是 %.0f%n", n, n, gareen.hp);
    // }

    // 常见线程安全的类：Hashtable/StringBuffer/Vector
    // ArrayList是非线程安全的类，可以变为线程安全的类
    // public static void main(String[] args) {
    // List<Integer> list1 = new ArrayList<>();
    // List<Integer> list2 = Collections.synchronizedList(list1);
    // }

    // public static void main(String[] args) {
    // final Hero gareen = new Hero();
    // gareen.name = "盖伦";
    // gareen.hp = 616;

    // Thread t1 = new Thread() {
    // public void run() {
    // while (true) {

    // // 无需循环判断
    // // while(gareen.hp==1){
    // // continue;
    // // }

    // gareen.hurt();

    // try {
    // Thread.sleep(10);
    // } catch (InterruptedException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }

    // }
    // };
    // t1.start();

    // Thread t2 = new Thread() {
    // public void run() {
    // while (true) {
    // gareen.recover();

    // try {
    // Thread.sleep(100);
    // } catch (InterruptedException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }

    // }
    // };
    // t2.start();
    // }

    // 线程池的简要实现
    // public static void main(String[] args) {
    // ThreadPool pool = new ThreadPool();

    // for (int i = 0; i < 5; i++) {
    // Runnable task = new Runnable() {
    // @Override
    // public void run() {
    // // System.out.println("执行任务");
    // // 任务可能是打印一句话
    // // 可能是访问文件
    // // 可能是做排序
    // }
    // };

    // pool.add(task);

    // try {
    // Thread.sleep(1000);
    // } catch (InterruptedException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }
    // }

    // public static void main(String[] args) {
    // ThreadPool pool= new ThreadPool();
    // int sleep=1000;
    // while(true){
    // pool.add(new Runnable(){
    // @Override
    // public void run() {
    // //System.out.println("执行任务");
    // try {
    // Thread.sleep(1000);
    // } catch (InterruptedException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }
    // });
    // try {
    // Thread.sleep(sleep);
    // sleep = sleep>100?sleep-100:sleep;
    // } catch (InterruptedException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }

    // }
    // }

    // 使用java自带的线程池
    // 第一个参数10 表示这个线程池初始化了10个线程在里面工作
    // 第二个参数15 表示如果10个线程不够用了，就会自动增加到最多15个线程
    // 第三个参数60 结合第四个参数TimeUnit.SECONDS，表示经过60秒，多出来的线程还没有接到活儿，就会回收，最后保持池子里就10个
    // 第四个参数TimeUnit.SECONDS 如上
    // 第五个参数 new LinkedBlockingQueue() 用来放任务的集合
    // public static void main(String[] args) throws InterruptedException {

    //     ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS,
    //             new LinkedBlockingQueue<Runnable>());

    //     threadPool.execute(new Runnable() {
    //         @Override
    //         public void run() {
    //             // TODO Auto-generated method stub
    //             System.out.println("任务1");
    //         }
    //     });
    // }

    
}
