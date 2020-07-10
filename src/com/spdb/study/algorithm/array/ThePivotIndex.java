package com.spdb.study.algorithm.array;

/**
 * 对于一个数组中的元素x,若x左侧的所有元素之和等于右侧所有元素之和，则返回x的下标
 * @author Mr.Longyx
 * @date 2020年07月10日 10:45
 */
public class ThePivotIndex {
    /**
     * 应用前缀和方式
     * 思路：
     * 先计算出数组中所有元素的和S，将数组的左边部分的和计为A，右边部分的和计为B，要返回的元素计为x
     * 则B=S-A-x,而A=B=S-A-x，所以2A+x=S,便可求解
     * @author Mr.Longyx
     * @date 2020/7/10 10:50
     * @param nums
     * @return int
     */
    public int pivotIndex(int[] nums){
        int len = nums.length;
        if (len < 0 || nums == null){
            return -1;
        }
        /**
         * 计算整个数组和
         * @author Mr.Longyx
         * @date 2020/7/10 10:54
         * @param nums
         * @return int
         */
        int S = 0;
        for (int i : nums){
            S += i;
        }

        //指定A为前缀和
        int A = 0;

        //迭代求前缀和
        for(int i=0;i<len;i++){
            //指定枢纽节点
            int x = nums[i];
            if(2*A+x == S){
                return i;
            }
            A += x;
        }
        return -1;
    }

}
