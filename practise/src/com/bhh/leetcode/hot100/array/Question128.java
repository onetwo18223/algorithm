package com.bhh.leetcode.hot100.array;

import com.bhh.lintcode.bfs.Question433;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author bhh
 * @description 最长连续序列
 * @date Created in 2021-12-21 18:34
 * @modified By
 */
public class Question128 {
    class Solution {
        /*
        错误题解, 错误原因 : 复杂度要求是O(logn), 不可以使用排序
        排序 + 遍历一遍
         */
        public int longestConsecutive1(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            Arrays.sort(nums);
            int max = 0;
            int num = 1;
            for (int i = 1; i < nums.length; i++) {
                int temp = nums[i] - nums[i - 1];
                if (temp == 0) {
                    continue;
                }
                if (temp == 1) {
                    num++;
                } else {
                    max = Math.max(max, num);
                    num = 1;
                }
            }
            return Math.max(max, num);
        }

        /*
        使用Hash表
         */
        public int longestConsecutive(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int length = nums.length;
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < length; i++) {
                set.add(nums[i]);
            }
            int num = 1;
            int max = 0;
            for (int i = 0; i < length; i++) {
                int temp = nums[i];
                if (set.contains(temp - 1)){
                    continue;
                }
                while (set.contains(temp + 1)) {
                    temp++;
                    num++;
                }
                max = Math.max(num, max);
                num = 1;
            }
            return max;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question128().new Solution().longestConsecutive(new int[]{
                0, 3, 7, 2, 5, 8, 4, 6, 0, 1
        }));
    }
}
