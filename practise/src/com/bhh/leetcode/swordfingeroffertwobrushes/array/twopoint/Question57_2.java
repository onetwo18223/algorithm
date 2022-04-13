package com.bhh.leetcode.swordfingeroffertwobrushes.array.twopoint;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bhh
 * @description 和为s的连续正数序列
 * @date Created in 2022-01-20 14:23
 * @modified By
 */
public class Question57_2 {
    class Solution {
        /*
        滑动窗口, 求和sum,
        若是sum > target, left左移
        若是sum < target, right右移
         */
        public int[][] findContinuousSequence(int target) {
            List<int[]> res = new ArrayList<>();
            int sum = 0;
            int left = 1, right = 1;
            while (right <= target - 1) {
                if (sum > target) {
                    sum -= left;
                    left++;
                } else if (sum < target) {
                    sum += right;
                    right++;
                } else {
                    int[] tmp = new int[right - left];
                    for (int i = left; i <= right; i++) {
                        tmp[i - left] = i;
                    }
                    res.add(tmp);
                    sum -= left;
                    left++;
                }
            }
            return res.toArray(new int[0][]);
        }
    }
}
