# LeetCode 41.缺失的第一个正数

## 题目

给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。

示例 1:

输入: [1,2,0]
输出: 3
示例 2:

输入: [3,4,-1,1]
输出: 2
示例 3:

输入: [7,8,9,11,12]
输出: 1


提示：

你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。

## 解答：

为了满足时间复杂度，就会使用到Hash的方式用于保存数组情况。

```java
//我直接使用的HashMap，但是空间复杂度不满足。
class Solution {
    public int firstMissingPositive(int[] nums) {
        HashMap<Integer,Boolean> map=new HashMap<Integer,Boolean>();
        int res=1;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],true);
        }
        while(map.get(res)!=null){
            res++;
        }
        return res;
    }
}
```

使用原地Hash的方式。

本质思想是：修改Hash规则，使的对应元素放在对应下标的位置，若是超出数组范围的就不处理。最后对数组再遍历一次，找到第一个数字和下标不对应的地方即可。

```java
class Solution {
    //原地hash，修改hash规则方式。
    public int firstMissingPositive(int[] nums) {
        //进行原地hash的过程：
        for(int i=0;i<nums.length;i++){
            while(nums[i]>0&&nums[i]<=nums.length&&nums[nums[i]-1]!=nums[i]){
                int ex=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=ex;
            }
        }
        //找到第一个不相等的
        for(int i=0;i<nums.length;i++){
           if(nums[i]!=i+1){
               return i+1;
           }
        }
        return nums.length+1;
    }
}
```

