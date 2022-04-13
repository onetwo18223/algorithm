package com.bhh.leetcode.three;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bhh
 * @description 和为s的连续正数序列
 * @date Created in 2022-01-28 19:57
 * @modified By
 */
public class Question57_2sword {
    class Solution {
        /*
        快慢双指针
         */
        public int[][] findContinuousSequenceError(int target) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            int sum = 0;
            for (int i = 0; i < target; i++) {
                sum += i;
                list.add(i);
                if (sum == target) {
                    res.add(new ArrayList<>(list));
                    sum = 0;
                    list = new ArrayList<>();
                }
            }
            return res.toArray(new int[res.size()][]);
        }

        /*
        快慢双指针 滑动窗口 比较大小
        sum > target left++;
        sum < target right++;
         */
        public int[][] findContinuousSequence(int target) {
            List<int[]> res = new ArrayList<>();
            int sum = 0;
            int left = 1;
            int right = 1;
            while (right < target) {
                if (sum > target) {
                    sum -= left;
                    left++;
                } else if (sum < target) {
                    sum += right;
                    right++;
                } else {
                    int[] array = new int[right - left];
                    for (int i = left; i < right; i++) {
                        array[i - left] = i;
                    }
                    res.add(array);
                    sum -= left;
                    left++;
                }
            }
            return res.toArray(new int[res.size()][]);
        }
    }
}
