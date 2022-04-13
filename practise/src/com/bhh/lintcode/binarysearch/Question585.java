package com.bhh.lintcode.binarysearch;

/**
 * @author bhh
 * @description 山脉序列中的最大值
 * 描述
 * 给 n 个整数的山脉数组，即先增后减的序列，找到山顶（最大值）。
 * 数组严格递增，严格递减
 * 样例
 * 例1:
 * 输入: nums = [1, 2, 4, 8, 6, 3]
 * 输出: 8
 * 例2:
 * 输入: nums = [10, 9, 8, 7],
 * 输出: 10
 * @date Created in 2021-11-28 20:58
 * @modified By
 */
public class Question585 {
    public class Solution {
        /*
        这道题在于这个'排序'的题目并不是完全有序,
        所以主要难点就是在 升序＋倒序 的情况下完成获取最大值

        升序加倒序也可以使用二分查询
        升序情况下, start = mid;
        降序情况下, end = mid;

        那么如何判断是升序还是降序?
        arr[mid] > arr[mid + 1]为降序
        arr[mid + 1] > arr[mid]为升序
         */
        public int mountainSequence(int[] nums) {
            if (nums == null || nums.length == 0) {
                return -1;
            }

            int start = 0, end = nums.length - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                // 降序情况
                if (nums[mid] > nums[mid + 1]) {
                    // 赋值mid, 防止出现mid是最大值情况
                    end = mid;
                }
                // 升序
                else {
                    // 赋值mid
                    start = mid;
                }
            }
            // 返回最大值
            return Math.max(nums[start], nums[end]);
        }
    }
}
