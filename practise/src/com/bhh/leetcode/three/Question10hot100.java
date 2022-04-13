package com.bhh.leetcode.three;

/**
 * @author bhh
 * @description 正则表达式匹配
 * @date Created in 2022-02-03 11:33
 * @modified By
 */
public class Question10hot100 {
    class Solution {
        /*
        s和p进行匹配
        使用dp
        1.状态
            dp[len1 + 1][len2 + 1]表示p的前j个元素能否匹配s的前i个元素
        2.转换公式
            dp[i][j] = dp[i - 1][j - 1] |
                    s[i - 1] == p[i - 1] || p[i - 1] == '.'
            // 如果p对应元素是 * , 则认为 * 分别是0, 1, >= 2这三种情况进行判断
                // 判断s[i - 1]和p[i - 2], 相等
                dp[i][j] |= dp[i][j - 2] |
                        dp[i - 1][j - 2] |
                        dp[i - 1][j] |
                        p[i - 1] == '*'
                // 不等
                dp[i][j] = dp[i][j - 2];
        3.初始值和边界值
            dp[0][0] = true;
        4.顺序
         */
        public boolean isMatch(String s, String p) {
            int len1 = s.length();
            int len2 = p.length();
            char[] array1 = s.toCharArray();
            char[] array2 = p.toCharArray();
            boolean[][] dp = new boolean[len1 + 1][len2 + 1];
            dp[0][0] = true;

            // 初始化
            for (int i = 1; i < len2 + 1; i++) {
                if (array2[i - 1] == '*') {
                    dp[0][i] = dp[0][i - 2];
                }
            }
            for (int i = 1; i < len1 + 1; i++) {
                for (int j = 1; j < len2 + 1; j++) {
                    if (array1[i - 1] == array2[j - 1] ||
                            array2[j - 1] == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                        continue;
                    }
                    if (array2[j - 1] == '*') {
                        if (array1[i - 1] == array2[j - 2] ||
                                array2[j - 2] == '.') {
                            dp[i][j] |= dp[i][j - 2] ||
                                    dp[i - 1][j - 2] || dp[i - 1][j];
                        } else {
                            dp[i][j] = dp[i][j - 2];
                        }
                    }
                }
            }
            return dp[len1][len2];
        }
    }
}
