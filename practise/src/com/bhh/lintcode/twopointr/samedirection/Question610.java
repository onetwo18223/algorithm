package com.bhh.lintcode.twopointr.samedirection;

/**
 * @author bhh
 * @description 两数差等于目标值
 * @date Created in 2021-12-23 9:07
 * @modified By
 */
public class Question610 {
    public class Solution {
        /*
        俩数之和的变形题目, 俩数之差
        不同于求和, 位置不重要, 重要的是求和结果, 所以可以使用相向双指针
        求差需要俩指针之间差值的距离把控, 所以需要使用同向双指针
         */
        public int[] twoSum7(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[0];
            }
            target = Math.abs(target);
            int start = 0, end = 1;
            while (end < nums.length) {
                if (start == end) {
                    end++;
                    continue;
                }
                int subtractRes = nums[end] - nums[start];
                if (subtractRes == target) {
                    return new int[]{nums[start], nums[end]};
                }
                // 差值过大, end对应值过大(但是end不能--), start对应值过小
                else if (subtractRes > target) {
                    start++;
                } else {
                    end++;
                }
            }
            return new int[0];
        }
    }
}
