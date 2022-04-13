package com.bhh.leetcode.headquarters.dynamic;

/**
 * @author bhh
 * @description 整数拆分
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。
 * 返回你可以获得的最大乘积。
 * @date Created in 2021-10-07 15:39
 * @modified By
 */
public class Question343 {
    class Solution {

        private int[] memo;

        /*
        实现思路 :
        递归实现, 使用参数
        对参数n进行拆分, 循环使用递归方法来获取最大值
         */
        public int integerBreak(int n) {
            memo = new int[n + 1];
            return reD(n);
        }

        /*
        记忆化搜索
         */
        private int re(int n) {
            if (n == 1) return 1;
            if (memo[n] != 0) {
                return memo[n];
            }
            int res = -1;
            for (int i = 1; i <= n - 1; i++) {
                res = Math.max(res,
                        Math.max(i * (n - i), i * re(n - i)));
            }
            memo[n] = res;
            return res;
        }

        /*
        动态规划
         */
        private int reD(int n) {
            memo[1] = 1;
            memo[2] = 1;
            for (int i = 3; i <= n; i++) {
                for (int j = 1; j <= i - 1; j++) {
                    memo[i] = Math.max(memo[i],
                            Math.max(j * (i - j), j * memo[i - j]));
                }
            }
            return memo[n];
        }

    }
}
