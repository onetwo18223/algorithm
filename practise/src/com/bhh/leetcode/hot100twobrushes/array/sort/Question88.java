package com.bhh.leetcode.hot100twobrushes.array.sort;

import java.util.Arrays;

/**
 * @author bhh
 * @description 合并两个有序数组
 * @date Created in 2022-01-27 9:46
 * @modified By
 */
public class Question88 {
    class Solution {
        /*
        与合并俩个链表方法相同, 使用归并
         */
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] array = Arrays.copyOf(nums1, m);
            int left = 0, right = 0;
            for (int i = 0; i < nums1.length; i++) {
                if (left >= array.length) {
                    nums1[i] = nums2[right];
                    right++;
                }
                else if (right >= nums2.length) {
                    nums1[i] = array[left];
                    left++;
                }
                // 比较
                else if (array[left] <= nums2[right]) {
                    nums1[i] = array[left];
                    left++;
                } else {
                    nums1[i] = nums2[right];
                    right++;
                }
            }
        }
    }
}
