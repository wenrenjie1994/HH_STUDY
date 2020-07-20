package thread;

/**
 * @program: TODO
 * @className:InnerClassThread
 * @description:TODO
 * @author: 何文艺
 * @create: 2020/7/17 9:50
 **/
public class InnerClassThread {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                //重写run方法，设置任务
                for (int i = 0; i < 20; i++) {
                    System.out.println(i);
                }
            }
        }.start();

        new Thread(new RunnableImpl() {
            @Override
            public void run() {
                //重写run方法，设置任务
                for (int i = 0; i < 20; i++) {
                    System.out.println(i);
                }
            }
        }).start();
    }
}
