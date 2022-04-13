package com.bhh.leetcode.hot100.dynamic;

/**
 * @author bhh
 * @description 编辑距离
 * @date Created in 2022-01-05 15:33
 * @modified By
 */
public class Question72 {
    class Solution {
        /*
        求最少操作数/ BFS我觉得是可以的, 但是偏向于暴力解法/ 求最值可以考虑DP, 但是DP定义摸不清
        使用DP, DP定义为dp[m + 1][n + 1], 表示word1前i个元素转换为word2前j个元素最少需要多少步骤
        2.转换公式
            dp[i][j] = dp[i - 1][j - 1] | word1[i] == word2[j]
            // 增删改是怎么推导呢?
                // 改最容易推导
                // 增, word1增加元素转换为word2(word2的元素较多, 所以才需要增多), dp[i][j] = dp[i][j - 1] + 1
                // 删, word1删除元素转换为word2(word1的元素较多, 所以才需要删除), dp[i][j] = dp[i - 1][j] + 1
            // 增删改的都是对于word1而言
            dp[i][j] = min(dp[i][j - 1] + 1/增, dp[i - 1][j] + 1/删, dp[i - 1][j - 1] + 1/改)
        3.初始值和边界值
            dp[0][0] = 1;
            // dp[0][j] 表示从word1的0个元素转换为word2的j个元素的最少步骤
            dp[0][j] = dp[0][j - 1] + 1;
            // dp[i][0] 表示从word1的i个元素转换为word的0个元素的最少步骤
            dp[i][0] = dp[i - 1][0] + 1;
        4.顺序
            正序
         */
        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();
            int[][] dp = new int[m + 1][n + 1];

            for (int i = 0; i < m + 1; i++) {
                for (int j = 0; j < n + 1; j++) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = 0;
                        continue;
                    }
                    // word1 0 个元素转换为 word2前j个元素
                    // 增加
                    if (i < 1) {
                        dp[i][j] = dp[i][j - 1] + 1;
                        continue;
                    }
                    // word1 i 个元素转换为 word2前0个元素
                    // 删除
                    if (j < 1) {
                        dp[i][j] = dp[i - 1][j] + 1;
                        continue;
                    }
                    // 无需操作
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                        continue;
                    }
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
            return dp[m][n];
        }
    }
}
