package Thread.NewThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description 实现Callable接口
 * @author liuclo
 * @date 2020.8.2 23:10
 */

//1. 创建一个实现Callable的实现类
class NumThread implements Callable {
    //2. 实现call()方法，将此线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception {
        int everSum = 0;
        for (int i=1; i<=100; i++) {
            if (i%2 == 0) {
                everSum += i;
            }
        }
        return everSum;
    }
}

public class CallableTest {
    public static void main(String[] args) {
        //3. 创建Callable接口实现类的对象
        NumThread numThread = new NumThread();

        //4. 将此Callable接口实现类的对象作为参数传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask futureTask = new FutureTask(numThread);

        //5. 将FutureTask类的对象作为参数传递到Thread类的构造器中，创建Thread类的对象，并调用start()，启动线程
        new Thread(futureTask).start();

        try {
            //6. 获取Callable中的call方法返回值
            //get()返回值即为FutureTask构造器参数Callable实现类重写的call()返回值
            Object obj = futureTask.get();
            System.out.println(obj);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
