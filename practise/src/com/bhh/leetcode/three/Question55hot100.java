package com.bhh.leetcode.three;

/**
 * @author bhh
 * @description 跳跃游戏
 * @date Created in 2022-01-30 10:51
 * @modified By
 */
public class Question55hot100 {
    class Solution {
        /*
        记录可到达的最远点, 若是点大于最后的元素, 则返回true, 不能达到则false
         */
        public boolean canJump(int[] nums) {
            int max = 0;
            for (int i = 0; i <= max; i++) {
                max = Math.max(max, i + nums[i]);
                if (max >= nums.length - 1) {
                    return true;
                }
            }
            return false;
        }
    }
}
