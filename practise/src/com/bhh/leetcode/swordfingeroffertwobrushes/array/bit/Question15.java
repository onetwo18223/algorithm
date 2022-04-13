package com.bhh.leetcode.swordfingeroffertwobrushes.array.bit;

/**
 * @author bhh
 * @description 二进制中1的个数
 * @date Created in 2022-01-14 21:23
 * @modified By
 */
public class Question15 {
    public class Solution {
        /*
        对于n删除最后一位1, 直到等于0
         */
        public int hammingWeight(int n) {
            int count = 0;
            while (n != 0) {
                n = n & (n - 1);
                count++;
            }
            return count;
        }
    }
}
