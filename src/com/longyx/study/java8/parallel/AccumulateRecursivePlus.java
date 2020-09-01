package com.spdb.study.java8.parallel;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Mr.Longyx
 * @date 2020年07月08日 21:48
 */
public class AccumulateRecursivePlus extends RecursiveAction {

    private static final long serialVersionUID = 1808170579923726686L;

    private final int start;
    private final int end;
    private final int[] data;
    private final int LIMIT = 3;


    public AccumulateRecursivePlus(int start, int end, int[] data) {
        this.start = start;
        this.end = end;
        this.data = data;
    }

    @Override
    protected void compute() {
        int result = 0;
        if ((end - start) <= LIMIT){
            for (int i=start;i<end;i++){
                AccumulatorHelper.accumulate(data[i]);
            }
        }else{
            int mid = (start + end)>>1;
            AccumulateRecursivePlus left = new AccumulateRecursivePlus(start,mid,data);
            AccumulateRecursivePlus right = new AccumulateRecursivePlus(mid,end,data);

            left.fork();
            right.fork();
            left.join();
            right.join();
        }
    }

    protected static class AccumulatorHelper{
        private static final AtomicInteger result = new AtomicInteger(0);

        protected static  void accumulate(int value){
            result.getAndAdd(value);
        }

        public static int getResult(){
            return result.get();
        }

        public static void reset(){
            result.set(0);
        }
    }
}
