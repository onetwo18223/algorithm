package org.qa.bisection;

/**
 * @Desc  在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 实现：
 * 使用二分法（数组有序，查找数target）
 * @Author bhh
 * @Date 2023-03-29 19:54
 * @Version 1.0
 */
public class Question34 {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (null == nums || nums.length == 0) return new int[]{-1, -1};
            int len = nums.length;
            int start = 0, end = len - 1;
            // 结束条件为 start + 1 == end
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] >= target) end = mid;
                else start = mid;
            }
            int index = start;
            if (nums[start] != target && nums[end] == target)
                index = end;
            else if (nums[start] != target && nums[end] != target)
                return new int[]{-1, -1};

            int[] res = new int[2];
            res[0] = index;
            while(index < len && nums[index] == target) index++;
            res[1] = index - 1;
            return res;
        }
    }
}
