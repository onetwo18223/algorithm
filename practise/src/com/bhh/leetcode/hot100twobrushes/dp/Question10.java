package com.bhh.leetcode.hot100twobrushes.dp;

/**
 * @author bhh
 * @description 正则表达式匹配
 * @date Created in 2022-01-27 21:46
 * @modified By
 */
public class Question10 {
    class Solution {
        /*
        求存在性 尝试dp 序列型dp
        1.状态
            dp[len1 + 1][len2 + 1] dp定义为长度为len2的p能否匹配长度为len1的s
        2.转换公式
            // 遍历到当前元素时, 俩对应索引位置元素相等
            if(array1[i - 1] == array2[j - 1])
                dp[i][j] = dp[i - 1][j - 1]
            // 若是不等
            if(array1[i - 1] != array2[j - 1]) {
                // 若是匹配元素是 *, 有了* ,则还需要判断他的前一个元素,
                // 就是判断array2[j - 2]
                if(array2[j - 1] == '*') {
                    // 相等
                    if (array1[i - 1] == array2[j - 2]) {
                        // *可能表示1, 多个
                        dp[i][j] = dp[i - 1][j - 2] | dp[i - 1][j]
                    }
                    // 不等则尝试让*表示0
                    else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        3.初始值和边界值
            dp[0][0] = true;
        4.顺序
            正序
         */
        public boolean isMatch(String s, String p) {
            char[] array1 = s.toCharArray();
            char[] array2 = p.toCharArray();
            int len1 = array1.length;
            int len2 = array2.length;
            boolean[][] dp = new boolean[len1 + 1][len2 + 1];
            dp[0][0] = true;

            // 初始化, 若是s为0, p不为0, 也是有可能匹配成功, 因为*可以表达0的意思
            for (int i = 1; i < len2 + 1; i++) {
                if (array2[i - 1] == '*') {
                    dp[0][i] = dp[0][i - 2];
                }
            }

            // 赋值
            for (int i = 1; i < len1 + 1; i++) {
                for (int j = 1; j < len2 + 1; j++) {
                    // 等于
                    if (array1[i - 1] == array2[j - 1] || array2[j - 1] == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                    // 如果不等于, 但是匹配式为 * 时
                    else if (array2[j - 1] == '*') {
                        // 判断array1[i - 1] 与 array2[j - 2]
                        // 相等
                        if (array1[i - 1] == array2[j - 2] || array2[j - 2] == '.') {
                            // 判断 * 为 0, 为 1, 为 >=2 的情况
                            dp[i][j] = dp[i][j - 2] | dp[i - 1][j - 2] | dp[i - 1][j];
                        }
                        // 不等
                        else {
                            // 若是 * 为0
                            dp[i][j] = dp[i][j - 2];
                        }
                    }
                }
            }
            return dp[len1][len2];
        }
    }
}
