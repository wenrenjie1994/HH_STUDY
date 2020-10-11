package com.longyx.study.java8.future;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * CompletableFuture流水线方式的工作
 * @author Mr.Longyx
 * @date 2020年07月09日 16:37
 */
public class CompletableFuturePipeLine {
    private static final Random RANDOM = new Random(System.currentTimeMillis());
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10,r->{
            Thread t = new Thread(r);
            t.setDaemon(false);
            return t;
        });

        CompletableFuture.supplyAsync(CompletableFutureTask::get,executorService)
                .thenApply(CompletableFuturePipeLine::multiply)
                .whenComplete((v,t)->{
                    Optional.ofNullable(v).ifPresent(System.out::println);
                    Optional.ofNullable(t).ifPresent(x->x.printStackTrace());
                });

        List<Integer> prodIds = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Stream<CompletableFuture<Double>> completableFutureStream = prodIds.stream().map(i -> CompletableFuture.supplyAsync(() -> getProduct(i), executorService));
        Stream<CompletableFuture<Double>> futureStream = completableFutureStream.map(future -> future.thenApply(CompletableFuturePipeLine::multiply));
        List<Double> result = futureStream.map(CompletableFuture::join).collect(toList());
        Optional.ofNullable(result).ifPresent(System.out::println);
    }

    private static Double getProduct(int index){
        return CompletableFutureTask.get();
    }

    private static Double multiply(Double value){
        try {
            Thread.sleep(RANDOM.nextInt(10000));
        }catch (Exception e){
            e.printStackTrace();
        }
        return value * 10.0d;
    }
}
