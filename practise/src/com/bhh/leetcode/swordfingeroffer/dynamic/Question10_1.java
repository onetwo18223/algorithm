package com.bhh.leetcode.swordfingeroffer.dynamic;

import java.util.Arrays;

/**
 * @author bhh
 * @description 斐波那契数列
 * @date Created in 2021-10-09 14:27
 * @modified By
 */
public class Question10_1 {
    class Solution {
        private int[] memo;

        public int fib(int n) {
            memo = new int[n + 1];
            Arrays.fill(memo, -1);
            return reD(n);
        }

        private int re(int n) {
            if (n == 0)
                return 0;
            if (n == 1)
                return 1;
            if (memo[n] != -1) {
                return memo[n];
            }
            return memo[n] = (re(n - 1) + re(n - 2)) % 1000000007;
        }

        private int reD(int n) {
            memo[0] = 0;
            memo[1] = 1;
            for (int i = 2; i <= n; i++) {
                memo[i] = (memo[i - 1] + memo[i - 2]) % 1000000007;
            }
            return memo[n];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question10_1().new Solution().fib(7));
    }
}
