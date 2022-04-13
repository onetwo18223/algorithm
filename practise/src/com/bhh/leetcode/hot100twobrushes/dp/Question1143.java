package com.bhh.leetcode.hot100twobrushes.dp;

/**
 * @author bhh
 * @description 最长公共子序列
 * @date Created in 2022-01-30 9:53
 * @modified By
 */
public class Question1143 {
    class Solution {
        /*
        使用二维数组dp
        求公共子序列
        1.状态
            dp[len1][len2] 表示 text1的前i个元素和text2的前j个元素公共子序列长度
        2.公式转换
            dp[i][j] = dp[i - 1][j -  1] + 1| text1.charAt(i) == text.charAt(j)
            else
                // 对位元素不等时, 就应该错位继续进行判断
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        3.初始值和边界值
            dp[0][0] = text1.charAt(0) == text2.charAt(0) ? 1 : 0;
        4.顺序
            正序
         */
        public int longestCommonSubsequence(String text1, String text2) {
            int len1 = text1.length();
            int len2 = text2.length();
            int[][] dp = new int[len1 + 1][len2 + 1];
            dp[0][0] = 0;
            for (int i = 1; i < len1 + 1; i++) {
                for (int j = 1; j < len2 + 1; j++) {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j -  1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[len1][len2];
        }
    }
}
