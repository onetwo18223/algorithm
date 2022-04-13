package com.bhh.leetcode.hot100.dynamic;

/**
 * @author bhh
 * @description 正则表达式匹配
 * @date Created in 2022-01-05 18:54
 * @modified By
 */
public class Question10 {
    class Solution {
        /*
        求存在性/ DP
        1.状态
            dp[len1 + 1][len2 + 1]定义
            dp[i][j]表示word1前i个元素是否和word2的前j个元素相匹配
        2.转换公式
            dp[i][j] = dp[i - 1][j - 1] | array1[i - 1] == array2[j - 1] || array2[j - 1] == '.'
            array1[i - 1] != array2[j - 1]
                array2[j - 1] == '*'
                    // 判断 array1[i - 1] 和 array2[j - 2]
                    // 相等
                        // * 表示 0 的意思
                        dp[i][j] = dp[i][j - 2]
                        // * 表示 1 的意思
                        dp[i][j] = dp[i - 1][j - 2]
                        // * 表示多个的意思 >= 2
                        dp[i][j] = dp[i - 1][j]
                    // 不等
                    // 尝试 * 表示 0 的意思
                    dp[i][j] = dp[i][j - 2]
        3.初始值和边界值
            dp[0][0] = true
        4.顺序
            正序
         */
        public boolean isMatch(String s, String p) {
            if (s == null || p == null) {
                return false;
            }
            char[] array1 = s.toCharArray();
            char[] array2 = p.toCharArray();
            int len1 = array1.length;
            int len2 = array2.length;
            boolean[][] dp = new boolean[len1 + 1][len2 + 1];
            dp[0][0] = true;

            // s为空，p不为空，由于*可以匹配0个字符，所以有可能为true
            for (int j = 1; j <= array2.length; j++) {
                if (array2[j - 1] == '*') {
                    // 为什么隔俩个位置, 因为字符和*是绑定的
                    dp[0][j] = dp[0][j - 2];
                }
            }

            for (int i = 1; i < len1 + 1; i++) {
                for (int j = 1; j < len2 + 1; j++) {
                    if (array1[i - 1] == array2[j - 1] || array2[j - 1] == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                        continue;
                    }
                    // array1[i - 1] != array2[j - 1]
                    // 若是出现 * 则表示j - 2一定大于等于0
                    if (array2[j - 1] == '*') {
                        // 判断 array1[i - 1] 和 array2[j - 2]
                        if (array1[i - 1] == array2[j - 2] || array2[j - 2] == '.') {
                            // *分别表示0, 1, >=2
                            dp[i][j] = dp[i][j - 2]
                                    || dp[i - 1][j - 2] || dp[i - 1][j];
                        } else {
                            // array1[i - 1] != array2[j - 2]
                            dp[i][j] = dp[i][j - 2];
                        }
                    }
                }
            }
            return dp[len1][len2];
        }
    }
}
