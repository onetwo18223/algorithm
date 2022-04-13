package com.bhh.leetcode.hot100.dynamic;

/**
 * @author bhh
 * @description 乘积最大子数组
 * @date Created in 2022-01-02 9:58
 * @modified By
 */
public class Question152 {
    class Solution {
        /*
        求乘积最大的连续子数组
        求最值/ 考虑DP/ 序列性DP
        这道题最重要的点在于有负数, 则很大的正数会变成负数, 很小的负数会变成正数
        所以需要俩个dp数组
        1.状态
            最后一步 对于len - 1个元素, 判断前len - 1个元素子数组最大乘积 * 当前值 是否是最大
                   对于len - 1个元素, 判断前len - 1个元素子数组最大乘积 * 当前值 是否是最小
            子问题 前i - 1个元素子数组最大/最小乘积
            dpMax[]数组定义前i个元素的连续子数组最大乘积
            dpMin[]数组定义前i个元素的连续子数组最小乘积
        2.转换公式
            dpMax[i] = max(dpMax[i - 1] * nums[i - 1], max(nums[i - 1]), dpMin(i - 1) * nums[i - 1])
            dpMin[i] = min(dpMin[i - 1] * nums[i - 1], min(nums[i - 1]), dpMax(i - 1) * nums[i - 1])
        3.初始值和边界值
            dpMax[0] = 0;
            dpMin[0] = 0;
        4.顺序
            正序
         */
        public int maxProduct(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int len = nums.length;
            int[] dpMax = new int[len + 1];
            int[] dpMin = new int[len + 1];
            dpMax[0] = 1;
            dpMin[0] = 1;
            int max = Integer.MIN_VALUE;
            for (int i = 1; i < len + 1; i++) {
//                dpMax[i] = max(dpMax[i - 1] * nums[i - 1], max(nums[i - 1]), dpMin[i - 1] * nums[i - 1])
                dpMax[i] = Math.max(dpMax[i - 1] * nums[i - 1], Math.max(nums[i - 1], dpMin[i - 1] * nums[i - 1]));
                if (dpMax[i] > max) {
                    max = dpMax[i];
                }
//                dpMin[i] = min(dpMin[i - 1] * nums[i - 1], min(nums[i - 1]), dpMax[i - 1] * nums[i - 1])
                dpMin[i] = Math.min(dpMin[i - 1] * nums[i - 1], Math.min(nums[i - 1], dpMax[i - 1] * nums[i - 1]));
            }
            return max;
        }
    }
}
