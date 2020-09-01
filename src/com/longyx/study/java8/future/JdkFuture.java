package com.spdb.study.java8.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *  Jdk 1.5之后加入Future
 * @author Mr.Longyx
 * @date 2020年07月09日 14:05
 */
public class JdkFuture {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> submit = executorService.submit(()->{
            try {
                Thread.sleep(10000);
                return "Task Finished";
            }catch (Exception e){
                return "Error";
            }
        });

        String value = null;
        try {
            //此处阻塞
            value = submit.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(value);

        while (!submit.isDone()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(submit.get());
        /**
         * 资源释放
         * @author Mr.Longyx
         * @date 2020/7/9 14:16
         */
        executorService.shutdown();
    }
}
