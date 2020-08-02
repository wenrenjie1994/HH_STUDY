package basic.method.demo1.day15;

public class Watting {
    public static void main(String[] args) {
        Object obj = new Object();//创建一个锁对象
        new Thread(){  //创建一个顾客线程，用匿名内部类
            @Override
            public void run() {
                synchronized (obj){
                    System.out.println("我是顾客，我要告知老板我要的包子种类和数量" );
                    try {
                        obj.wait();//调用wait方法，放弃cpu的执行，进入到WATTING状态，wait方法有异常，使用try catch
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //唤醒之后执行代码
                    System.out.println("包子做好后，开吃");
                }
            }
        }.start();

        //创建一个老板的线程
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(3000); //老板花3秒钟做包子
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //保证等待和唤醒的线程只有一个能执行，所以需要用同步技术
                synchronized (obj){
                    System.out.println("老板做好包子后叫顾客吃包子");
                    obj.notify();
                }
            }
        }.start();
    }
}
