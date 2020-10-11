package com.longyx.study.java8.parallel;

import java.util.concurrent.ForkJoinPool;

/**
 * @author Mr.Longyx
 * @date 2020年07月08日 21:42
 */
public class ForkJoinPoolTest {
    private static int[] data = {1,2,3,4,5,6,7,8,9,10};

    public static void main(String[] args) {
        System.out.println(calc());
        AccumulateRecursiveTask task = new AccumulateRecursiveTask(0,data.length, data);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Integer result = forkJoinPool.invoke(task);
        System.out.println(result);

        AccumulateRecursivePlus accumulate = new AccumulateRecursivePlus(0,data.length,data);
        forkJoinPool.invoke(accumulate);
        System.out.println(AccumulateRecursivePlus.AccumulatorHelper.getResult());
    }

    private static int calc(){
        int result = 0;
        for(int i=0;i<data.length;i++){
            result += data[i];
        }
        return result;
    }
}
