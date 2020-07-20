package thread;

/**
 * @program: TODO
 * @className:MyThread
 * @description:TODO
 * @author: 何文艺
 * @create: 2020/7/16 16:26
 **/
public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println(getName());
    }
}
