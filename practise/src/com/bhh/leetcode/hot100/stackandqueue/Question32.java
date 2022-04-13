package com.bhh.leetcode.hot100.stackandqueue;

/**
 * @author bhh
 * @description 最长有效括号
 * @date Created in 2022-01-05 21:16
 * @modified By
 */
public class Question32 {
    class Solution {
        /*
        求最长有效括号/括号类 + 最值类题目/DP
        既然是求最长, 那么dp[i]可直接定义为前i个元素最长有效括号
        1.状态
            对于最后一个元素array[i]而言, 若是其为'(', 则dp[i]直接为0
            若为')', 则判断array[i - 1]是否是'(',
                若是则dp[i] = dp[i - 2] + 2
                若array[i - 1]是')', 则对于array[i - 1]而言, 其一定是有效括号(否则不会遍历到i),
                    其最长有效括号长度是dp[i - 1], 那么对于元素i而言,
                    与其配对的元素是array[i - 1 - dp[i - 1]], 例如 : ((...))
                    判断array[i - 1 - dp[i - 1]]是否是'(', 若是则dp[i] = dp[i - 1] + 2
                    值得注意的是，i − dp[i − 1] − 1 和 i 组成了有效括号对，这将是一段独立的有效括号序列，
                    如果之前的子序列是形如 (...)(...) 这种序列，
                    那么当前位置的最长有效括号长度还需要加上这一段。所以：
                    dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2
        2. 转换公式
            0 | array[i] = '('
            dp[i] = dp[i - 2] + 2 | array[i - 1] = ')'
            dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2 | array[i - 1 - dp[i - 1]] = '('
         */
        public int longestValidParentheses(String s) {
            if (s == null || "".equals(s)) {
                return 0;
            }
            int max = 0;
            char[] array = s.toCharArray();
            int len = array.length;
            int[] dp = new int[len];
            for (int i = 1; i < len; i++) {
                if (array[i] == '(') {
                    continue;
                }
                else if (array[i - 1] == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                }
                else if (i - dp[i - 1] > 0
                        && array[i - dp[i - 1] - 1] == '(') {
                    dp[i] = dp[i - 1] +
                            ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
}
