package org.problem.bisection;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 */
public class Question34 {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[]{-1, -1};
            }
            int l = 0, r = nums.length - 1;
            // 结束条件为 l + 1 == r
            while (l + 1 < r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] >= target) {
                    r = mid;
                } else {
                    l = mid;
                }
            }

            int start, end;
            // 判断l索引和r索引
            if (nums[l] == target) {
                start = l;
            } else if (nums[r] == target) {
                start = r;
            } else {
                return new int[]{-1, -1};
            }

            end = start + 1;
            // 判断边界
            while(end < nums.length && nums[end] == nums[start]) {
                end++;
            }
            return new int[]{start, end - 1};
        }
    }
}
