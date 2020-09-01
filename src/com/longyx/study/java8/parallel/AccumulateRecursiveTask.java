package com.spdb.study.java8.parallel;

import java.util.concurrent.RecursiveTask;

/**
 * @author Mr.Longyx
 * @date 2020年07月08日 21:48
 */
public class AccumulateRecursiveTask extends RecursiveTask<Integer> {

    private static final long serialVersionUID = 1808170579923726686L;

    private final int start;
    private final int end;
    private final int[] data;
    private final int LIMIT = 3;

    public AccumulateRecursiveTask(int start, int end, int[] data) {
        this.start = start;
        this.end = end;
        this.data = data;
    }

    @Override
    protected Integer compute() {
        if (end - start <= LIMIT){
            int result = 0;
            for(int i=start;i<end;i++){
                result += data[i];
            }
            return result;
        }

        int mid = (start+end)>>1;
        AccumulateRecursiveTask left = new AccumulateRecursiveTask(start, mid, data);
        AccumulateRecursiveTask right = new AccumulateRecursiveTask(mid,end,data);
        left.fork();

        Integer rightResult = right.compute();
        Integer leftResult = left.join();

        return leftResult + rightResult;
    }
}
