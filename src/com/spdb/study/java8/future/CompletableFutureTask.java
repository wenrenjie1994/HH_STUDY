package com.spdb.study.java8.future;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * @author Mr.Longyx
 * @date 2020年07月09日 16:00
 */
public class CompletableFutureTask {
    private static final Random RANDOM = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        CompletableFuture<Double> completableFuture = new CompletableFuture<>();
        new Thread(()->{
            Double value = get();
            completableFuture.complete(value);
        }).start();
        System.out.println("=====non block=======");

        completableFuture.whenComplete((v,t)->{
            Optional.ofNullable(v).ifPresent(System.out::println);
            Optional.ofNullable(t).ifPresent(x->x.printStackTrace());
        });
    }

    protected static Double get(){
        /**
         * 模拟去获取网络资源
         * @author Mr.Longyx
         * @date 2020/7/9 16:04
         * @return java.lang.Double
         */
        try {
            Thread.sleep(RANDOM.nextInt(10000));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RANDOM.nextDouble();
    }
}
