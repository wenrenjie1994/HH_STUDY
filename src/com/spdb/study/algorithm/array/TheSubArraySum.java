package com.spdb.study.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组nums和一个整数k,返回该数组中和为k的连续子数组的个数
 * @author Mr.Longyx
 * @date 2020年07月10日 11:21
 */
public class TheSubArraySum {
    /**
     * 初始写法
     * 思路：
     * 先求出所有前缀和，然后根据前缀和求出所有可能的子数组之和
     * 时间复杂度：o(n^2)
     * 空间复杂度：o(n)
     *
     * public int subarraySum(int[] nums, int k){
     *         int len = nums.length;
     *
     *         //计算前缀和数组
     *         int[] preSum = new int[len+1];
     *         int sum = 0;
     *         for(int i=0;i<len;i++){
     *             preSum[i] = sum;
     *             sum += nums[i];
     *         }
     *         int count = 0;
     *        //将整个数组元素的和计入到最后一个位置上
     *        preSum[len] = sum;
     *         for (int i=0;i<=len;i++){
     *             for (int j=i+1;j<=len;j++){
     *                 if (preSum[j] - preSum[i] == k){
     *                     count++;
     *                 }
     *             }
     *         }
     *         return count;
     *
     *   for (int i=0;i<=len;i++){
     *         for (int j=i+1;j<=len;j++){
     *          if (preSum[j] - preSum[i] == k){
     *                    count++;
     *              }
     *         }
     *     }
     *     等价于：
     *     for(int j=1;j<= len;j++){
     *         for(int i=0;i<j;i++){
     *             if (preSum[i] = preSum[j]-k){
     *                 count++;
     *             }
     *         }
     *     }
     * @author Mr.Longyx
     * @date 2020/7/10 11:23
     */

    /**
     * 优化写法(Hash表写法，key:前缀和值 value:出现次数)
     * 时间复杂度：o(n)
     * 空间复杂度：o(n)
     * @author Mr.Longyx
     * @date 2020/7/10 11:42
     */
    public static int subarraySum(int[] nums, int k){
        Map<Integer, Integer> preSum = new HashMap<>();

        /**
         * 初始化前缀和0出现的次数为1
         * @author Mr.Longyx
         * @date 2020/7/10 11:45
         * @param nums
         * @param k
         * @return int
         */
        preSum.put(0,1);

        int sum = 0;
        int result = 0;
        for (int n : nums) {
            /**
             * 计算前缀和
             * @author Mr.Longyx
             * @date 2020/7/10 11:46
             * @param nums
             * @param k
             * @return int
             */
            sum += n;
            /**
             * 查找sum[i]=sum[j]-k的元素个数
             * @author Mr.Longyx
             * @date 2020/7/10 11:47
             * @param nums
             * @param k
             * @return int
             */
            if (preSum.containsKey(sum - k)){
                result += preSum.get(sum - k);
            }
            /**
             * 更新sum[i]个数
             * @author Mr.Longyx
             * @date 2020/7/10 11:48
             * @param nums
             * @param k
             * @return int
             */
            if (preSum.containsKey(sum)){
                preSum.put(sum, preSum.get(sum)+1);
            }else {
                preSum.put(sum, 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ins = new int[]{1,2,3,4,2,6,8};
        System.out.println(TheSubArraySum.subarraySum(ins,6));
    }

}
