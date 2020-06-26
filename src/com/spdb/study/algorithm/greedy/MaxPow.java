package com.spdb.study.algorithm.greedy;

/**
 * 使用贪心算法思想解决裁剪绳子问题
 * @author Mr.Longyx
 * @date 2020年06月26日 19:57
 */
public class MaxPow {
    public int cuttingRope(int n){
        if (n <= 3){
            return n-1;
        }
        int numOf3 = n / 3;
        if (n - numOf3*3 == 1){
            numOf3--;
        }
        /**
         * 尽可能多的裁剪长度为3的绳子段，如果余数为1，则裁剪为两段长度为2的绳子段
         * @author Mr.Longyx
         * @date 2020/6/26 20:03
         * @param n 
         * @return int
         */
        int numOf2 = (n-numOf3*3)/2;

        return (int)Math.pow(3,numOf3) * (int)Math.pow(2,numOf2);
    }
    public static void main(String[] args) {
        MaxPow pow = new MaxPow();
        int h = pow.cuttingRope(8);
        System.out.println("最大乘积："+h);
    }
}
