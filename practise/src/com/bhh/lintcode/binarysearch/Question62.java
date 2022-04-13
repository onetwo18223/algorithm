package com.bhh.lintcode.binarysearch;

/**
 * @author bhh
 * @description 搜索旋转排序数组
 * @date Created in 2021-11-30 14:22
 * @modified By
 */
public class Question62 {
    public class Solution {
        /*
        相对于 "寻找旋转排序数组中的最小值" 来说, 这道题的 '目标值' 发生了改变
        主要解决的要点 : 如何判断? mid 要和谁判断?
            如果mid直接和target判断,
            4, 5, 6, 7, 0, 1, 2 | 6
            假设 mid = 7, A[mid] > target, 我应该向右还是向左?
            假设 mid = 0, A[mid] < target, 我应该向右还是想左?
            第一段和第二段需要再加一个判断
            如果在第一段, 再判断target 是否在 A[start] 和 A[mid]范围,
                是则 end = mid
                不是则 start = mid
            如果在第二段, 再判断target 是否在 A[mid] 和 A[end]范围
                是则 start = mid
                不是则 end = mid
         */
        public int search(int[] A, int target) {
            if (A == null || A.length == 0) {
                return -1;
            }
            int right = A.length - 1;
            int start = 0, end = right;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                // mid在阶段一
                if (A[mid] > A[right]) {
                    // 判断target是否在阶段一
                    if (A[start] <= target && target <= A[mid]) {
                        end = mid;
                    } else {
                        start = mid;
                    }
                }
                // mid在阶段二
                else if (A[mid] < A[right]) {
                    // 判断target是否在阶段二
                    if (A[mid] <= target && target <= A[end]) {
                        start = mid;
                    } else {
                        end = mid;
                    }
                }
            }
            if (A[start] == target) {
                return start;
            }
            if (A[end] == target) {
                return end;
            }
            return -1;
        }
    }
}
