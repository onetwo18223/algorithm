package com.bhh.leetcode.hot100twobrushes.array;

/**
 * @author bhh
 * @description 跳跃游戏
 * @date Created in 2022-01-21 16:10
 * @modified By
 */
public class Question55 {
    class Solution {
        /*
        不断刷新获取最大可跳跃长度
         */
        public boolean canJump(int[] nums) {
            int max = 0;
            int index = 0;
            while (index <= max) {
                max = Math.max(max, index + nums[index]);
                if (max >= nums.length - 1) {
                    return true;
                }
                index++;
            }
            return false;
        }
    }
}
