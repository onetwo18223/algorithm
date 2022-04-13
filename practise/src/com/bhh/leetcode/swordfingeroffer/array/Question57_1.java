package com.bhh.leetcode.swordfingeroffer.array;

import java.util.Arrays;

/**
 * @author bhh
 * @description 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 * @date Created in 2021-09-16 12:08
 * @modified By
 */
public class Question57_1 {
    class Solution {
        /*
        实现思路 :
        因为数组是排序的, 所以可以使用双指针来实现
        一端指针l指向数组头, 另一端r指向数组尾
        若是nums[l] + nums[r] > target, 则r--;
        nums[l] + nums[r] < target, 则l++;
        nums[l] + nums[r] == target, 则返回;
         */
        public int[] twoSum(int[] nums, int target) {
            int[] array = new int[2];
            int l = 0, r = nums.length - 1;

            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    array[0] = nums[l];
                    array[1] = nums[r];
                    break;
                } else if (nums[l] + nums[r] < target) {
                    l++;
                } else {
                    r--;
                }
            }
            return (array[0] == 0 && array[1] == 0) ? new int[]{} : array;
        }
        /*
        比较正确返回数组的方式
         */
        public int[] twoSumPlus(int[] nums, int target) {
            int l = 0, r = nums.length - 1;

            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    return new int[]{nums[l], nums[r]};
                } else if (nums[l] + nums[r] < target) {
                    l++;
                } else {
                    r--;
                }
            }
            return new int[]{};
        }
    }

    public static void main(String[] args) {
        Arrays.stream(new Question57_1().new Solution().
                twoSum(new int[]{2, 7, 11, 15}, 100)).forEach(System.out::println);
    }
}
