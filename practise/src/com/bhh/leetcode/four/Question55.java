package com.bhh.leetcode.four;

/**
 * @author bhh
 * @description 跳跃游戏
 * @date Created in 2022-02-23 17:22
 * @modified By
 */
public class Question55 {
    class Solution {
        /*
        记录最长可以跳到的距离
         */
        public boolean canJump(int[] nums) {
            int jumpMax = nums[0];
            for (int i = 1; i < jumpMax; i++) {
                jumpMax = Math.max(jumpMax, i + nums[i]);
                if (jumpMax >= nums.length) {
                    return true;
                }
            }
            return false;
        }
    }
}
