package org.problem.twopointer.reversepointer.partition;

/**
 * md文件中Question31
 * 数组划分
 * 实现：快速排序简化版
 */
public class Question31MD {
    public class Solution {
        public int partitionArray(int[] nums, int k) {
            if (nums == null && nums.length == 0) return 0;
            int start = 0, end = nums.length - 1;
            while(start <= end) {
                while(start <= end && nums[start] < k) start++;
                while(start <= end && nums[end] > k) end--;
                if (start <= end) {
                    int temp = nums[start];
                    nums[start] = nums[end];
                    nums[end] = temp;

                    start++;
                    end--;
                }
            }
            return start;
        }
    }
}
