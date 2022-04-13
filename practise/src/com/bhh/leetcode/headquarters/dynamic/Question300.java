package com.bhh.leetcode.headquarters.dynamic;

/**
 * @author bhh
 * @description 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * 示例 1：
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * <p>
 * 示例 2：
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * <p>
 * 示例 3：
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 * @date Created in 2021-10-09 12:06
 * @modified By
 */
public class Question300 {
    class Solution {
        /*
        实现思路 : 暴力解法 :
        将数组分为当前index和index + 1 到 nums.length - 1
        递归结束 : index >= nums.length
        递归过程 : for(index到nums.length - 1), 寻找nums[i] > nums[index]
         */
        public int lengthOfLIS(int[] nums) {
            return re(nums, 0);
        }

        /**
         * @param nums
         * @param index
         * @return 返回当前index下, 最长子集合长度
         */
        private int re(int[] nums, int index) {
            if (index >= nums.length) {
                return 0;
            }
            int num = 0;
            int tmp = index;
            for (int i = index + 1; i < nums.length; i++) {
                if (nums[i] > nums[tmp]) {
                    num = 1 + re(nums, index + 1);
                    tmp = i;
                }
            }
            num = Math.max(num, re(nums, index + 1));
            return num;
        }
    }
}
