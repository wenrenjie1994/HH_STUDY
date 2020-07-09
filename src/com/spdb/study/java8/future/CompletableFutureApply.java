package com.spdb.study.java8.future;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import static java.util.stream.Collectors.toList;

/**
 * CompletableFuture常见API
 * @author Mr.Longyx
 * @date 2020年07月09日 17:08
 */
public class CompletableFutureApply {
    public static void main(String[] args) {
        try {
            CompletableFuture.supplyAsync(()->1)
                    .thenApply(i -> Integer.sum(i,10))
                    .whenCompleteAsync((v,t)->{
                        Optional.ofNullable(v).ifPresent(System.out::println);
                        Optional.ofNullable(t).ifPresent(x->x.printStackTrace());
                    })
                    .whenComplete((v,t)->System.out.println(v));

            CompletableFuture.supplyAsync(()->1)
                    .handle((v,t)->Integer.sum(v,10))
                    .whenComplete((v,t)->System.out.println(v))
                    .thenRun(System.out::println);

            CompletableFuture.supplyAsync(()->1)
                    .thenApply(i->Integer.sum(i,13))
                    .thenAccept(System.out::println);

            CompletableFuture.supplyAsync(() -> 1)
                    .thenCompose(i -> CompletableFuture.supplyAsync(() -> 10 * i))
                    .thenAccept(System.out::println);

            CompletableFuture.supplyAsync(()->1)
                    .thenCombine(CompletableFuture.supplyAsync(()->2.0d),(a,b)->a+b)
                    .thenAccept(System.out::println);

            CompletableFuture.supplyAsync(()->1)
                    .thenAcceptBoth(CompletableFuture.supplyAsync(()->2.0d),(a,b)->{
                        System.out.println(a);
                        System.out.println(b);
                        System.out.println(a + b);
                    });

            CompletableFuture.supplyAsync(()->{
                System.out.println(Thread.currentThread().getName()+"is running...");
                return 1;
            }).runAfterBoth(CompletableFuture.supplyAsync(()-> {
                System.out.println(Thread.currentThread().getName() + "is running");
                return 2;
            }),()-> System.out.println("Finished"));

            CompletableFuture.supplyAsync(()->{
                System.out.println("Future one");
                return 1;
            }).applyToEither(CompletableFuture.supplyAsync(()->{
                System.out.println("Future two");
                return 2;
            }),v->v*10)
                    .thenAccept(System.out::println);

            System.out.println("===================");
            CompletableFuture.supplyAsync(()->{
                System.out.println("Future one");
                return CompletableFutureTask.get();
            }).acceptEither(CompletableFuture.supplyAsync(()->{
                System.out.println("Future two");
                return CompletableFutureTask.get();
            }),System.out::println);

            CompletableFuture.supplyAsync(()->{
                System.out.println("Future one");
                return CompletableFutureTask.get();
            }).runAfterEither(CompletableFuture.supplyAsync(()->{
                System.out.println("Future two");
                return CompletableFutureTask.get();
            }),()->System.out.println("finished."));

            List<CompletableFuture<Double>> collect = Arrays.asList(3, 4, 5, 6, 7, 8, 9).stream().map(i -> CompletableFuture.supplyAsync(CompletableFutureTask::get)).collect(toList());
            CompletableFuture.allOf(collect.toArray(new CompletableFuture[collect.size()]))
                    .thenRun(()->System.out.println("done."));

            CompletableFuture.anyOf(collect.toArray(new CompletableFuture[collect.size()]))
                    .thenAccept(System.out::println);

            Thread.currentThread().join();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
