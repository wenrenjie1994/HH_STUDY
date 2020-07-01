package com.spdb.study.algorithm.dynamic;

/**
 * 动态规划方式解决裁剪绳子问题
 * @author Mr.Longyx
 * @date 2020年06月26日 19:45
 */
public class MaxPow {
    public int cuttingRope(int n){
        if (n <= 3){
            /**
             * 只能裁剪成1+1或1+2或2+1的方式
             * @author Mr.Longyx
             * @date 2020/6/26 19:47
             * @param n
             * @return int
             */
            return n-1;
        }
        int[] dp = {1,2,3};
        for(int i=3;i<n;i++){
            int tmp = Math.max(3*dp[0],Math.max(2*dp[1],1*dp[2]));
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = tmp;
        }
        return dp[2];
    }

    public static void main(String[] args) {
        MaxPow pow = new MaxPow();
        int m = pow.cuttingRope(8);
        System.out.println("最大乘积："+m);
    }
}
