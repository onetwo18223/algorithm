package com.bhh.leetcode.three;

import java.util.Arrays;

/**
 * @author bhh
 * @description  寻找重复数
 * @date Created in 2022-01-29 20:35
 * @modified By
 */
public class Question287hot100 {
    class Solution {
        /*
        二分搜索和循环链表
         */
        public int findDuplicate(int[] nums) {
            int slow = 0;
            int fast = 0;
            while (true) {
                slow = nums[slow];
                fast = nums[nums[fast]];
                if (slow == fast) {
                    break;
                }
            }
            slow = 0;
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return nums[slow];
        }

        // 二分搜索法
        public int findDuplicateBinary(int[] nums) {
            // 排序
            Arrays.sort(nums);
            int left = 0, right = nums.length - 1;
            while (left + 1 < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < mid + 1) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            if (nums[left] != left + 1) {
                return nums[left];
            }
            return nums[right];
        }
    }
}
