package com.bhh.leetcode.swordfingeroffer.dynamic;

import java.util.Arrays;

/**
 * @author bhh
 * @description 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。
 * 求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * @date Created in 2021-10-09 14:47
 * @modified By
 */
public class Question10_2 {
    class Solution {
        private int[] memo;

        public int numWays(int n) {
            memo = new int[n + 1];
            Arrays.fill(memo, -1);
            return reD(n);
        }

        private int re(int n) {
            if (n == 0)
                return 1;
            if (n == 1)
                return 1;
            if (memo[n] != -1) {
                return memo[n];
            }
            return memo[n] = (re(n - 1) + re(n - 2)) % 1000000007;
        }

        private int reD(int n) {
            memo[0] = 1;
            memo[1] = 1;
            for (int i = 2; i <= n; i++) {
                memo[i] = (memo[i - 1] + memo[i - 2]) % 1000000007;
            }
            return memo[n];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question10_2().new Solution().numWays(7));
    }
}
