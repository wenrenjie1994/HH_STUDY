package com.testHR;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 资源类。以包子铺为例
 * @author: zeng
 * @modified By:
 */
public class Resource {
    private  String name;//生产对象名
    private int dir;//生产目标
    private int num = 0;//当前个数
    private boolean flag = false;//生产状态，false，没有包子。需要生产，不能消费

    private Lock lock = new ReentrantLock();//锁
    private Condition conPro = lock.newCondition();//生产者状态
    private Condition conBuy = lock.newCondition();//消费者状态

    public Resource(String name, int dir) {
        this.name = name;
        this.dir = dir;
    }

    /**
     * 生产包子的方法
     */
    public void pro(){
        lock.lock();//同步锁

        try {
            while (flag) {//标记为true，有包子，需要消费，不能生产
                try {
                    conPro.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //标记为false，可以生产
            if(num+1>dir){//是否达到生产目标
                System.out.println("包子卖完了");
                System.exit(0);
            }
            //未达到生产目标，生产
            System.out.println(Thread.currentThread().getName()+":做出第"+(++num)+"个包子");
            flag = true;
            conBuy.signal();
        } finally {
            lock.unlock();
        }

    }

    /**
     * 消费的方法
     */
    public void buy(){
        lock.lock();//同一把锁
        try {
            while(!flag){//flag=false时进入循环，没有包子，不能消费
                try {
                    conBuy.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //flag=true,且包子未卖完，可以消费了
            if(num <= dir){
                System.out.println(Thread.currentThread().getName()+"：买了第"+num+"个包子");
            }
            flag = false;
            conPro.signal();
        } finally {
            lock.unlock();
        }
    }
}
