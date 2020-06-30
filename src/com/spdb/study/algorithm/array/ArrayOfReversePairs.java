package com.spdb.study.algorithm.array;

/**
 * 数组中的逆序对
 * @author Mr.Longyx
 * @date 2020年07月01日 0:07
 */
public class ArrayOfReversePairs {
    public static int reversePairs(int[] nums){
        if (nums == null || nums.length <1) {
            return 0;
        }
        /**
         *  创建与原数组长度相同的辅助数组
         * @author Mr.Longyx
         * @date 2020/7/1 0:11
         */
        int[] copy = new int[nums.length];

        /**
         * 将nums中的元素依次拷贝到辅助数组中
         * @author Mr.Longyx
         * @date 2020/7/1 0:13
         */
        System.arraycopy(nums,0,copy,0,nums.length);

        return reversePairsCore(nums,copy,0,nums.length-1);
    }

    private static int reversePairsCore(int[] data, int[] copy, int start, int end){
        /**
         * 如果指向同一位置，说明没有逆序对
         * @author Mr.Longyx
         * @date 2020/7/1 0:16
         */
        if (start == end){
            copy[start] = data[end];
            return 0;
        }

        /**
         * 获取中点
         * @author Mr.Longyx
         * @date 2020/7/1 0:17
         */
        int mid = (start+end) >>1;
        /**
         *  使左半段有序，并返回逆序对数
         * @author Mr.Longyx
         * @date 2020/7/1 0:18
         */
        int leftCount = reversePairsCore(copy,data,start,mid);
        /**
         *  使右半段有序，并返回逆序对数
         * @author Mr.Longyx
         * @date 2020/7/1 0:19
         */
        int rightCount = reversePairsCore(copy,data, mid + 1,end);

        /**
         * 初始化i为左半段最后一个元素的下标
         * @author Mr.Longyx
         * @date 2020/7/1 0:20
         */
        int i = mid;
        /**
         * 初始化j为右半段的最后一个元素的下标
         * @author Mr.Longyx
         * @date 2020/7/1 0:22
         */
        int j = end;
        /**
         * 初始化辅助数组的index为最后一个元素下标
         * @author Mr.Longyx
         * @date 2020/7/1 0:23
         */
        int index = end;
        /**
         * 统计逆序对
         * @author Mr.Longyx
         * @date 2020/7/1 0:24
         */
        int count = 0;

        while (i >= start && j>=mid+1){
            if (data[i] > data[j]){
                //说明有逆序对
                copy[index--] = data[i--];
                count += j - mid;
            }else{
                copy[index--] = data[j--];
            }
        }
        /**
         * 左半段元素有剩余，直接加到辅助数组中
         * @author Mr.Longyx
         * @date 2020/7/1 0:27
         */
        for(;i>=start;){
            copy[index--] = data[i--];
        }
        for(;j>=mid+1;){
            copy[index--] = data[j--];
        }
        return leftCount + rightCount + count;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 7, 6, 5};
        //3
        System.out.println(reversePairs(data));
        int[] data2 = {6, 5, 4, 3, 2, 1};
        //15
        System.out.println(reversePairs(data2));
        int[] data3 = {1, 2, 3, 4, 5, 6};
        //0
        System.out.println(reversePairs(data3));
        int[] data4 = {1};
        //0
        System.out.println(reversePairs(data4));
        int[] data5 = {1, 2};
        //0
        System.out.println(reversePairs(data5));
        int[] data6 = {2, 1};
        //1
        System.out.println(reversePairs(data6));
        int[] data7 = {1, 2, 1, 2, 1};
        //3
        System.out.println(reversePairs(data7));
    }
}
