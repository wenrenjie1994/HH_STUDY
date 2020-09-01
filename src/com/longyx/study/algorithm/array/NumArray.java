package com.spdb.study.algorithm.array;

/**
 * 给定一个数组，返回该数组任意i到j之间数的和
 * @author Mr.Longyx
 * @date 2020年07月10日 9:43
 */
public class NumArray {
    /**
     * 使用前缀和方式
     * preSum:数组开头若干个元素的和
     * 时间复杂度：o(1)
     * 空间复杂度：o(n)
     * @author Mr.Longyx
     * @date 2020/7/10 9:46
     * @param nums
     */
    private int[] preSum;
    /**
     * private int[][] res;
     * @author Mr.Longyx
     * @date 2020/7/10 10:17
     * @param nums
     */

    //预处理阶段
    public NumArray(int[] nums){

        int len = nums.length;

        if (len < 0 || nums == null){
            return;
        }
        preSum = new int[len+1];
        preSum[0] = 0;
        //遍历数组
        for (int i = 0; i < len; i++) {
            preSum[i+1] = preSum[i] + nums[i];
        }

        /**
         * 应用二维数组存储预处理结果方式
         * 空间的复杂度：n(n^2)
         * 时间复杂度：o(1)
         * int n = nums.length;
         *  res = new int[n][n];
         *  //遍历所有行
         *  for(int i=0;i<n;i++){
         *     int sum = 0;
         *     //遍历i到n的行
         *     for(int j=i;j<n;j++){
         *         sum += nums[j];
         *         res[i][j] = sum;
         *        }
         * }
         * @author Mr.Longyx
         * @date 2020/7/10 10:01
         */
    }
    public int sumRange(int i,int j){
        return preSum[j+1] - preSum[i];
        /**
         * 应用二维数组存储预处理结果方式
         * return res[i][j];
         * @author Mr.Longyx
         * @date 2020/7/10 10:01
         */
    }


}
