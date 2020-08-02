package lambda;

/**
 * @program: TODO
 * @className:Demo01Lambda
 * @description:TODO
 * @author: 何文艺
 * @create: 2020/7/24 9:27
 **/
public class Demo01Lambda {
    public static void main(String[] args) {
        RunnableImpl run = new RunnableImpl();
        Thread t = new Thread(run);
        t.start();

        //简化代码
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "新线程执行了");
            }
        };
        new Thread(runnable).start();

        //简化代码
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "新线程执行了");
            }
        }).start();

        //使用Lambda表达式简化代码
        new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "新线程执行了");
            }
        ).start();

        //Lambda表达式省略优化
        new Thread(() -> System.out.println(Thread.currentThread().getName() + "新线程执行了")).start();
    }
}
