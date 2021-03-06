package com.bhh.lintcode.binarysearch;

/**
 * @author bhh
 * @description 寻找旋转排序数组中的最小值
 * 描述
 * 假设一个按升序排好序的数组在其某一未知点发生了旋转（比如0 1 2 4 5 6 7 可能变成4 5 6 7 0 1 2）。你需要找到其中最小的元素。
 * 你可以假设数组中不存在重复元素。
 * 样例
 * 样例 1:
 * 输入：[4, 5, 6, 7, 0, 1, 2]
 * 输出：0
 * 解释：
 * 数组中的最小值为0
 * <p>
 * 样例 2:
 * 输入：[2,1]
 * 输出：1
 * 解释：
 * 数组中的最小值为1
 * @date Created in 2021-11-28 21:22
 * @modified By
 */
public class Question159 {
    public class Solution {
        /*
        求最小值
        // 4, 5, 6, 7, 0, 1, 2
        // mid在阶段一
        arr[mid] > arr[arr.length - 1] 则 start = mid;
        // mid在阶段二
        arr[mid] < arr[arr.length - 1] 则 end = mid;
        // 情况不一, 例如 : 2 2 2 1 2 || 2 1 2 2 2
        arr[mid] == arr[arr.length - 1] 则 end--;
         */
        public int findMin(int[] nums) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int right = nums.length - 1;
            int start = 0, end = right;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                // mid在阶段一
                if (nums[mid] > nums[right]) {
                    start = mid;
                }
                // mid在阶段二
                else if (nums[mid] < nums[right]) {
                    end = mid;
                }
                // 情况不一, 例如 : 2 2 2 1 2 || 2 1 2 2 2
                // end--; 逐个试试
                else {
                    end--;
                }
            }
            return Math.min(nums[start], nums[end]);
        }
    }
}
