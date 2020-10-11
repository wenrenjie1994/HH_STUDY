package com.longyx.study.java8.future;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Mr.Longyx
 * @date 2020年07月09日 13:44
 */
public class FutureTask {
    public static void main(String[] args) {
        Future<String> future = invoke(() -> {
            try {
                Thread.sleep(10000);
                return "I'm finished";
            } catch (Exception e) {
                e.printStackTrace();
                return "Error";
            }
        });

        System.out.println(future.get());
        while (!future.isDone()){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(future.get());

        String block = block(() -> {
            try {
                Thread.sleep(10000);
                return "Task Finished";
            } catch (Exception e) {
                e.printStackTrace();
                return "Error";
            }
        });
        System.out.println(block);
    }

    /**
     * 阻塞的方式
     * @author Mr.Longyx
     * @date 2020/7/9 14:01
     * @param callable
     * @return T
     */
    private static <T> T block(Callable<T> callable){
        return callable.obtain();
    }

    /**
     * 非阻塞式方式
     * @author Mr.Longyx
     * @date 2020/7/9 14:04
     * @param callable
     * @return com.longyx.study.java8.future.FutureTask.Future<T>
     */
    private static <T> Future<T> invoke(Callable<T> callable){
        AtomicReference<T> result = new AtomicReference<>();
        AtomicBoolean finished = new AtomicBoolean(false);

        Future<T> future = new Future<T>() {
            Completable<T> completable;
            @Override
            public T get() {
                return result.get();
            }

            @Override
            public boolean isDone() {
                return finished.get();
            }

            @Override
            public void setCompletable(Completable<T> completable) {
                    this.completable = completable;
            }

            @Override
            public Completable<T> getCompletable() {
                return completable;
            }
        };

        new Thread(()->{
            T value = callable.obtain();
            result.set(value);
            finished.set(true);
        }).start();

        return future;
    }

}
