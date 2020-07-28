package basic.method.demo1.day14;

public class Demo03InnerClassThread {
    public static void main(String[] args) {
        //线程的父类是Thread
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName()+"---Thread");
                }
            }
        }.start();
        //线程的接口是Runnable
        //Runable run = new RunnableImpl();//多态
       Runnable run =  new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName()+"---Runnable");
                }
            }
        };
       new Thread(run).start();
        new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName()+"---简化Runnable");
                }
            }
        }).start();
    }
}
