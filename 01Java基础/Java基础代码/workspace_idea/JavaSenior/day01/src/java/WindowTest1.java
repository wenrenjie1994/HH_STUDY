package java;

/**
 * 例子：创建三个窗口卖票，总票数为100张，使用实现Runnable接口的方式
 * @author zhaopan@163.com
 * @creat 2020-04-15 13:45
 */

//方式二：存在线程安全的问题，待解决
class Window1 implements Runnable{
    private int ticket = 100;//不用加static
    @Override
    public void run() {
       while (true){
           if(ticket>0){
               System.out.println(Thread.currentThread().getName()+"卖票：票号为："+ticket);
               ticket--;
           }else{
               break;
           }
       }

    }
}

public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w = new Window1();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();


    }
}
