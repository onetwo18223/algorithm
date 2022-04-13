package com.bhh.leetcode.hot100twobrushes.array.twopoint.twosum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author bhh
 * @description 三数之和
 * @date Created in 2022-01-21 9:55
 * @modified By
 */
public class Question15 {
    class Solution {
        /*
        俩数之和 + for = O(n ^ 2)复杂度
         */
        private List<List<Integer>> res;

        public List<List<Integer>> threeSum(int[] nums) {
            res = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return res;
            }
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                findTwo(nums, i);
            }
            return res;
        }

        /**
         * 转换成俩数之和
         *
         * @param nums 数组
         * @param i    第三个数索引
         */
        private void findTwo(int[] nums, int i) {
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            // 结束 left == right
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }
    }
}
