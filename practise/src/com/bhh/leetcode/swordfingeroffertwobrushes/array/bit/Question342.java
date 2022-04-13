package com.bhh.leetcode.swordfingeroffertwobrushes.array.bit;

/**
 * @author bhh
 * @description 4的幂
 * @date Created in 2022-01-14 20:36
 * @modified By
 */
public class Question342 {
    class Solution {
        /*
        先开方, 再判断是否是2的幂次方
         */
        public boolean isPowerOfFour(int n) {
            int sqrt = (int)Math.sqrt(n);
            return sqrt > 0
                    && sqrt * sqrt == n
                    && (sqrt & (sqrt - 1)) == 0;
        }
    }
}
