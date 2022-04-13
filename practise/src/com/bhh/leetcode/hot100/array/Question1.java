package com.bhh.leetcode.hot100.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bhh
 * @description 两数之和
 * 给定一个整数数组 nums和一个整数目标值 target，
 * 请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * <p>
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * <p>
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * <p>
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * @date Created in 2021-10-13 8:10
 * @modified By
 */
public class Question1 {
    class Solution {

        /*
        双指针实现
         */
        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length == 0){
                return new int[0];
            }
            Arrays.sort(nums);
            int start = 0;
            int end = nums.length - 1;
            while (start < end){
                int sum = nums[start] + nums[end];
                if (sum == target){
                    return new int[]{nums[start], nums[end]};
                } else if (sum > target){
                    end--;
                } else {
                    start++;
                }
            }
            return new int[0];
        }

        /*
        实现思路 : 双指针滑动窗口, hash表
        尝试hash表(原版)
         */
        public int[] twoSumV1(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                map.put(nums[i], i);
            }
            for (int i = 0; i < n; i++) {
                int i1 = target - nums[i];
                if (map.containsKey(i1) && map.get(i1) != i) {
                    return new int[]{map.get(i1), i};
                }
            }
            return new int[0];
        }

        public int[] twoSumV2(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    return new int[]{map.get(target - nums[i]), i};
                }
                map.put(nums[i], i);
            }
            return new int[0];
        }
    }

    public static void main(String[] args) {
        for (int i : new Question1().new Solution().
                twoSum(new int[]{3, 2, 4}, 6)) {
            System.out.println(i);
        }
    }
}
