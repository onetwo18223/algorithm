package com.bhh.leetcode.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bhh
 * @description 三数之和
 * @date Created in 2022-02-23 18:20
 * @modified By
 */
public class Question15 {
    class Solution {
        /*
        求三数之和就是先循环再求俩数之和
         */
        List<List<Integer>> res;
        public List<List<Integer>> threeSum(int[] nums) {
            res = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return res;
            }
            // 先排序
            Arrays.sort(nums);

            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                twoSum(nums, i, -nums[i]);
            }
            return res;
        }

        private void twoSum(int[] nums, int index, int target) {
            int left = index + 1, right = nums.length - 1;
            // 结束 : left == right
            while (left < right) {
                int value = nums[left] + nums[right];
                if (value > target) {
                    right--;
                } else if (value < target) {
                    left++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[left]);
                    list.add(nums[right]);
                    list.add(-target);
                    res.add(list);
                    left++;
                    while (left <= right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }
    }
}
