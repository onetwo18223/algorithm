package com.bhh.leetcode.hot100.array;

/**
 * @author bhh
 * @description 跳跃游戏
 * @date Created in 2021-12-21 15:08
 * @modified By
 */
public class Question55 {
    class Solution {
        /*
        不懂这道题考什么?
        标签写的贪心
         */
        public boolean canJump(int[] nums) {
            int k = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i > k) return false;
                k = Math.max(k, i + nums[i]);
                if (k >= nums.length){
                    return true;
                }
            }
            return true;
        }
    }
}
