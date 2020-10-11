package com.longyx.study.java8.future;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 改造：实现一个监听，你一旦有数据了，返回给我就好，我不需要苦苦地白等
 * @author Mr.Longyx
 * @date 2020年07月09日 14:27
 */
public class FuturePlus {
    public static void main(String[] args) {
        Future<String> future = invoke(() -> {
            try {
                Thread.sleep(10000);
                return "Task Finished";
            } catch (Exception e) {
                return "Error";
            }
        });

        //此处注册监听事件
        future.setCompletable(new Completable<String>() {

            @Override
            public void complete(String s) {
                System.out.println(s);
            }

            @Override
            public void exception(Throwable cause) {
                System.out.println("Generated some errors");
                cause.printStackTrace();
            }
        });
    }

    private static <T> Future<T> invoke(Callable<T> callable) {
        AtomicReference<T> result = new AtomicReference<T>();
        AtomicBoolean finished = new AtomicBoolean(false);

        /**
         * Future实现
         * @author Mr.Longyx
         * @date 2020/7/9 14:34
         * @param callable
         * @return com.longyx.study.java8.future.FuturePlus.Future<T>
         */
        Future<T> future = new Future<T>() {
            private Completable<T> completable;
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
            try {
                T value = callable.obtain();
                result.set(value);
                finished.set(true);
                if (future.getCompletable() != null){
                    future.getCompletable().complete(value);
                }
            }catch (Throwable cause) {
                if (future.getCompletable() != null){
                    future.getCompletable().exception(cause);
                }
            }

        }).start();

        return future;
    }

}
