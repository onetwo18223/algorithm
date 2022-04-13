package com.bhh.leetcode.swordfingeroffertwobrushes.array.dp;

/**
 * @author bhh
 * @description 机器人的运动范围
 * @date Created in 2022-01-19 13:58
 * @modified By
 */
public class Question13 {
    class Solution {
        /*
        尝试dp, 坐标型dp
        1.状态
        dp[m][n]定义为(m,n)当前格子是否可以达到
        最后一个 : 判断当前格子是否可以达到,
        2.转换公式
        dp[m][n] = dp[m - 1] | dp[n - 1] && m每个字符 + n每个字符 <= k
        3.初始值和边界值
        4.顺序
            正序
         */
        public int movingCount(int m, int n, int k) {
            boolean[][] dp = new boolean[m][n];
            dp[0][0] = true;
            int sum = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0 || getEveryNum(i) + getEveryNum(j) > k) {
                        continue;
                    }
                    if (i > 0) {
                        dp[i][j] |= dp[i - 1][j];
                    }
                    if (j > 0) {
                        dp[i][j] |= dp[i][j - 1];
                    }
                    sum += dp[i][j] ? 1 : 0;
                }
            }
            return sum;
        }

        private int getEveryNum(int num) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            return sum;
        }
    }
}
