package com.bhh.lintcode.binarysearch;

/**
 * @author bhh
 * @description 寻找峰值
 * 给定一个整数数组(size为n)，其具有以下特点：
 * 相邻位置的数字是不同的
 * A[0] < A[1] 并且 A[n - 2] > A[n - 1]
 * 假定P是峰值的位置则满足A[P] > A[P-1]且A[P] > A[P+1]，返回数组中任意一个峰值的位置。
 * @date Created in 2021-12-01 9:20
 * @modified By
 */
public class Question75 {
    public class Solution {
        /*
        返回任意一个峰值, 给出了判断条件 + 目标值,
        排序时 升序 + 降序 + 升序 + 降序 循环, 虽然排序不规则是多段排序,
            但是排序一般用来确定判断如何缩小范围
        A[mid] > A[mid - 1] && A[mid] > A[mid + 1] 返回 mid
        A[mid] < A[mid - 1] 则 end = mid
        A[mid] < A[mid + 1] 则 start = mid
         */
        public int findPeak(int[] A) {
            if (A == null || A.length == 0){
                return -1;
            }
            int start = 0, end = A.length - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                    return mid;
                }
                if (A[mid] < A[mid - 1]) {
                    end = mid;
                } else if (A[mid] < A[mid + 1]) {
                    start = mid;
                }
            }
            // start - 1, start + 1 有没有可能越界
            if (A[start] > A[(start - 1) > 0 ? (start - 1) : start] &&
                    A[start] > A[(start + 1) > A.length - 1 ? (start + 1) : start]){
                return start;
            }
            if (A[end] > A[(end - 1) > 0 ? (end - 1) : end] &&
                    A[end] > A[(end + 1) > A.length - 1 ? (end + 1) : end]){
                return end;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question75().new Solution().findPeak(new int[]{
                1, 2, 3, 4, 1
        }));
    }
}
