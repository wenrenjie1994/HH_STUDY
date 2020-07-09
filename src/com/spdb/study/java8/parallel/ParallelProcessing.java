package com.spdb.study.java8.parallel;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Stream并行体验
 * @author Mr.Longyx
 * @date 2020年07月08日 20:39
 */
public class ParallelProcessing {

    public static void main(String[] args) {
        /**
         * 调整CPU的可并行数量
         * @author Mr.Longyx
         * @date 2020/7/9 20:37
         */
        System.setProperty("java.util.concurrent.ForkJoin.common.parallelism","20");
        //CPU核数
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println("The best time =>"+getRunTimePerformance(ParallelProcessing::normal, 100000000)+"ms");
        /**
         * 低效实现
         * System.out.println("The best time =>"+getRunTimePerformance(ParallelProcessing::iterateStream, 10000000)+"ms");
         * System.out.println("The best time =>"+getRunTimePerformance(ParallelProcessing::parallel, 10000000)+"ms");
         * System.out.println("The best time =>"+getRunTimePerformance(ParallelProcessing::paraller, 10000000)+"ms");
         * @author Mr.Longyx
         * @date 2020/7/9 20:34
         */
        System.out.println("The best time =>"+getRunTimePerformance(ParallelProcessing::param, 100000000)+"ms");
    }

    private static long iterateStream(long limit){
        return Stream.iterate(0L,i->i+1).limit(limit).reduce(0L,Long::sum);
    }

    private static long parallel(long limit){
        return Stream.iterate(0L,i->i+1).parallel().limit(limit).reduce(0L,Long::sum);
    }

    private static long paraller(long limit){
        return Stream.iterate(0L,i->i+1).parallel().limit(limit).mapToLong(Long::longValue).reduce(0L,Long::sum);
    }

    private static long param(long limit){
        return LongStream.rangeClosed(1,limit).parallel().reduce(0L,Long::sum);
    }

    private static long getRunTimePerformance(Function<Long,Long> function, long limit){
        long fast = Long.MAX_VALUE;
        for(int i=0;i<10;i++){
            Long startTime = System.currentTimeMillis();
            Long result = function.apply(limit);
            Long duration = System.currentTimeMillis() - startTime;
            System.out.println("The Result of sum =>"+result);
            if (duration < fast) fast = duration;
        }
        return fast;
    }

    private static long normal(long limit){
        long result = 0L;
        for(long i=0L;i<limit;i++){
            result += i;
        }
        return result;
    }
}
