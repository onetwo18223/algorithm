package com.bhh.leetcode.three;

/**
 * @author bhh
 * @description 移动零
 * @date Created in 2022-01-29 21:30
 * @modified By
 */
public class Question283hot100 {
    class Solution {
        /*
        移动零
        方法一 : 同向双指针
        方法二 : 记录0的个数, 然后添加在尾部
         */
        public void moveZeroes(int[] nums) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    count++;
                } else {
                    nums[i - count] = nums[i];
                }
            }

            for (int i = nums.length - 1; i >= 0 && count >= 0; i--, count--) {
                nums[i] = 0;
            }
        }

        // 同向双指针
        public void moveZeroesTwoPoints(int[] nums) {
            int left = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    int tmp = nums[i];
                    nums[i] = nums[left];
                    nums[left] = tmp;
                    left++;
                }
            }
        }
    }
}
