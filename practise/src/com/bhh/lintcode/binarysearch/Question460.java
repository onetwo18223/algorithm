package com.bhh.lintcode.binarysearch;

/**
 * @author bhh
 * @description
 * @date Created in 2021-11-28 17:42
 * @modified By
 */
public class Question460 {
    public class Solution {
        /*
        实现思路 : 要获取离target最近的数集合, 这个有点像是从target位置分割开来,
        向俩边走, 哪一边离得近, 哪一边就被选择
        所以选择 中性线 很重要
        选择方案 : >= target的最小值得左边
        <= target的最大值的右边
         */
        public int[] kClosestNumbers(int[] A, int target, int k) {
            int[] arr = new int[k];
            int len = A.length - 1;
            int right;
            if ((right = binarySearch(A, target)) == -1) {
                for (int i = 0, j = len; i < k; i++, j--) {
                    arr[i] = A[j];
                }
                return arr;
            }
            // 背向双指针
            int left = right - 1;
            for (int i = 0; i < k; i++) {
                if (left < 0) {
                    arr[i] = A[right];
                    right++;
                } else if (right > len) {
                    arr[i] = A[left];
                    left--;
                } else if (target - A[left] <= A[right] - target) {
                    arr[i] = A[left];
                    left--;
                } else {
                    arr[i] = A[right];
                    right++;
                }
            }
            return arr;
        }

        // 1 2 | 4
        // | 1 2
        private int binarySearch(int[] a, int target) {
            int start = 0, end = a.length - 1;
            // 获取 >= target的最小值
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (a[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            if (a[start] >= target) {
                return start;
            }
            if (a[end] >= target) {
                return end;
            }
            return -1;
        }
    }
}
