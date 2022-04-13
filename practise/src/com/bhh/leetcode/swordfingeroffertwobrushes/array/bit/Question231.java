package com.bhh.leetcode.swordfingeroffertwobrushes.array.bit;

/**
 * @author bhh
 * @description 2 的幂
 * @date Created in 2022-01-14 20:32
 * @modified By
 */
public class Question231 {
    class Solution {
        /*
        判断是否是2的幂次方,
        2的幂次方的二进制只有一位是1,
        那么只需要去除这个1就是0
         */
        public boolean isPowerOfTwo(int n) {
            return n > 0 && (n & (n - 1)) == 0;
        }
    }
}
