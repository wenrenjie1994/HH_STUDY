package com.spdb.study.algorithm.math;

/**
 * 使用数学方式解决裁剪绳子问题
 * @author Mr.Longyx
 * @date 2020年06月26日 19:36
 */
public class MaxPow {
    public int cuttingRope(int n){
        //n 绳子的长度
        if (n <= 3){
            return n-1;
        }

        int x = n / 3;
        int y = n % 3;
        if (0 == y){
            return (int)Math.pow(3,x);
        }else if (1 == y){
            return (int)Math.pow(3,x-1)*4;
        }else{
            return (int)Math.pow(3,x)*2;
        }
    }

    public static void main(String[] args) {
        MaxPow measure = new MaxPow();
        int k = measure.cuttingRope(8);
        System.out.println("最大乘积："+k);
    }
}
