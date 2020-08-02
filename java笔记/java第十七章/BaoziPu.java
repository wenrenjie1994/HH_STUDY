package basic.method.demo1.day15;
/*
    生产者（包子铺）类：是一个线程类，可以继承Thread
    设置线程任务（run）:生产包子
    对包子的状态进行判断
    true：有包子。false：没有包子
    包子铺交替生产两种包子，生产好了包子，修改包子状态为true,有
    唤醒吃货线程，让吃货线程吃包子

    注意：
    1.包子铺线程和包子线程关系为——》通信（互斥），必须使用同步技术保证两个线程只有一个在执行
    2.锁对象必须保证唯一，可以使用包子对象作为锁对象
    3.包子铺类和吃货的类就需要把包子对象作为参数传递进来
        （1）需要在成员位置创建一个包子变量
        （2）使用带参数构造方法，为这个包子变量赋值

 */
public class BaoziPu extends Thread{
    private Baozi bz;
    public BaoziPu(Baozi bz){
        this.bz = bz;
    }

    @Override//设置线程任务，生产包子
    public void run() {
        int count = 0;
        synchronized (bz){//使用同步技术，保证两个线程只能有一个在执行
            if (bz.flag == true){//对包子的状态进行判断
                try {
                    bz.wait();//包子铺调用wait方法进入等待状态
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }//交替生产两种包子
            if (count%2 == 0){
                bz.pi = "薄皮";
                bz.xian = "三鲜";
            }else {
                bz.pi = "冰皮";
                bz.xian = "三鲜";
            }
            count++;
            System.out.println("包子铺正在生产："+bz.pi+bz.xian+"包子");
            bz.flag = true;
            bz.notify();//唤醒吃货线程，让吃货吃包子
            System.out.println("包子铺生产好了："+bz.pi+bz.xian+"吃货可以开吃了");
        }
    }
}
