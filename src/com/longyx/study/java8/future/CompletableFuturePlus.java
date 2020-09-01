package com.spdb.study.java8.future;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Mr.Longyx
 * @date 2020年07月09日 16:13
 */
public class CompletableFuturePlus {
    public static void main(String[] args) {
        AtomicBoolean finished = new AtomicBoolean(false);

        ExecutorService executor = Executors.newFixedThreadPool(10,r->{
            Thread t = new Thread(r);
            //是否为守护线程
            t.setDaemon(false);
            return t;
        });

        CompletableFuture.supplyAsync(CompletableFutureTask::get,executor)
                .whenComplete((v,t)->{
                   Optional.ofNullable(v).ifPresent(System.out::println);
                   Optional.ofNullable(t).ifPresent(x->x.printStackTrace());
                   finished.set(true);
                });
        System.out.println("=================non block==================");

       while (!(finished.get())){
           try {
               Thread.sleep(100);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }

       executor.execute(()-> System.out.println("Test"));
       executor.shutdown();
    }
}
