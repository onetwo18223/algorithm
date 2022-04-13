package com.bhh.leetcode.hot100twobrushes.dp;

/**
 * @author bhh
 * @description 乘积最大子数组
 * @date Created in 2022-01-21 14:07
 * @modified By
 */
public class Question152 {
    class Solution {
        /*
        求最值 尝试dp 坐标型dp
        1.状态
            本题需要俩个dp数组, 一个是最小乘积(因为是乘法), 一个是最大乘积
            最后一步 : 最后一个元素乘前几个连续元素的最大值, 获取最大值
                因为负负得正所以最后一个元素需要前几个元素的最小值也乘该元素, 判断是否是最大值
            子问题 : 前几个元素的最大值
            dpMax[len]
            dpMin[len]
        2.转换公式
            dpMax[i] = Math.max(nums[i], Math.max(nums[i] * dpMax[i - 1], nums[i] * dpMin[i - 1]))
            dpMin同理
        3.初始值和边界值
            dpMax[0] = nums[0]
            dpMin[0] = nums[0]
        4.顺序
         */
        public int maxProduct(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int len = nums.length;
            int[] dpMax = new int[len];
            int[] dpMin = new int[len];
            dpMax[0] = nums[0];
            dpMin[0] = nums[0];
            int max = nums[0];
            for (int i = 1; i < len; i++) {
                dpMax[i] = Math.max(nums[i], Math.max(
                        nums[i] * dpMax[i - 1], nums[i] * dpMin[i - 1]));
                dpMin[i] = Math.min(nums[i], Math.min(
                        nums[i] * dpMax[i - 1], nums[i] * dpMin[i - 1]));
                max = Math.max(max, dpMax[i]);
            }
            return max;
        }
    }
}
