package com.bhh.leetcode.three;

/**
 * @author bhh
 * @description 机器人的运动范围
 * @date Created in 2022-01-28 21:00
 * @modified By
 */
public class Question13sword {
    class Solution {
        /*
        求数量, 转换为求存在性 尝试dp 坐标型dp
        1.状态
            dp[m][n] 表示对应某一个元素机器人能否达到
        2.转换公式
            dp[i][j] = i %/ 10 + j %/ 10 >= k && (dp[i - 1][j] || dp[i][j - 1])
        3.初始值和边界值
            dp[0][0] = true;
        4.顺序
            向下向右
         */
        public int movingCount(int m, int n, int k) {
            boolean[][] dp = new boolean[m][n];
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = true;
                        continue;
                    }
                    if (get(i) + get(j) > k) {
                        continue;
                    }
                    dp[i][j] = (i > 0 ? dp[i - 1][j] : false) || (j > 0 ? dp[i][j - 1] : false);
                    if (dp[i][j]) {
                        count++;
                    }
                }
            }
            return count;
        }

        private int get(int x) {
            int sum = 0;
            while (x != 0) {
                sum += (x % 10);
                x /= 10;
            }
            return sum;
        }
    }
}
