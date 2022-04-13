package com.bhh.leetcode.hot100twobrushes.array.bit;

/**
 * @author bhh
 * @description 只出现一次的数字
 * @date Created in 2022-01-21 12:56
 * @modified By
 */
public class Question136 {
    class Solution {
        /*
        位运算, 使用x^x = 0
         */
        public int singleNumber(int[] nums) {
            int tmp = 0;
            for (int num : nums) {
                tmp ^= num;
            }
            return tmp;
        }
    }
}
