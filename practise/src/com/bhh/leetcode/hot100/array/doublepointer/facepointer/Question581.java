package com.bhh.leetcode.hot100.array.doublepointer.facepointer;

import java.util.Arrays;

/**
 * @author bhh
 * @description 最短无序连续子数组
 * @date Created in 2022-01-06 19:31
 * @modified By
 */
public class Question581 {
    class Solution {
        /*
        这个数组按照题意会被分割成 升序 乱序 升序的情况
        需要寻找乱序情况, 本题最优解是我认为泛用性降低的方法
        排序可能是比较好的方法
         */
        public int findUnsortedSubarray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] array = nums.clone();
            Arrays.sort(array);
            int start = 0, end = nums.length - 1;
            while (start < end && nums[start] == array[start]) {
                start++;
            }
            while (start < end && nums[end] == array[end]) {
                end--;
            }
            return end == start ? 0 : end - start + 1;
        }
        public int findUnsortedSubarrayNiuMa(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int len = nums.length;
            int start = 0, end = len - 1;
            int max = nums[start];
            int min = nums[end];
            for (int i = 0; i < len; i++) {
                if (max <= nums[i]) {
                    max = nums[i];
                } else {
                    start = i;
                }
            }
            for (int i = len - 1; i >= 0 ; i--) {
                if (min >= nums[i]) {
                    min = nums[i];
                } else {
                    end = i;
                }
            }

            if (start == 0 && end == len - 1) {
                return 0;
            }
            return start - end + 1;
        }
    }
}
