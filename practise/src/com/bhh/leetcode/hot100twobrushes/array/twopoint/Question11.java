package com.bhh.leetcode.hot100twobrushes.array.twopoint;

/**
 * @author bhh
 * @description 盛最多水的容器
 * @date Created in 2022-01-21 11:34
 * @modified By
 */
public class Question11 {
    class Solution {
        /*
        使用双指针
        left和right, 哪个边较短就移动哪边
         */
        public int maxArea(int[] height) {
            int left = 0, right = height.length - 1;
            int max = 0;
            // 结束 left == right
            while (left < right) {
                // 面积
                max = Math.max(max,
                        Math.min(height[left], height[right]) * (right - left));
                // 动短边
                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }
            return max;
        }
    }
}
