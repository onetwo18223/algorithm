package com.bhh.leetcode.swordfingeroffertwobrushes.array.other;

/**
 * @author bhh
 * @description 数组中出现次数超过一半的数字
 * @date Created in 2022-01-12 20:45
 * @modified By
 */
public class Question39 {
    class Solution {
        /*
        HashMap/摩尔投票法
         */
        public int majorityElement(int[] nums) {
            /*
            先认定一个数是众数, 然后计数, 若是count == 0, 则重新换众数
             */
            int res = nums[0];
            int count = 1;
            for (int i = 1; i < nums.length; i++) {
                count = nums[i] == res ? count + 1 : count - 1;
                if (count == 0) {
                    res = nums[i];
                    count = 1;
                }
            }
            return res;
        }
    }
}
