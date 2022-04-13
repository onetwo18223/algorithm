package com.bhh.lintcode.dynamic;

/**
 * @author bhh
 * @description 分割回文串（二）
 * @date Created in 2022-01-01 9:22
 * @modified By
 */
public class Question108 {
    public class Solution {
        /*
        最少需要分割几次/ 最值问题/ 考虑DP/ 划分型DP
        1.状态
            定义dp[len + 1], 表示前i个字符串最少可以分割出多少个回文串
            最后一步 : 将最后一个回文串分割从 j 分割到 len - j
            子问题 : 求 dp[len - j] 最少可以分割多少个回文串
        2.公式转换
            dp[i] = Math.min((dp[i - j] + 1)|i ~ j是回文串, dp[i])
        3.初始值和边界值
            dp[0] = 0;
        4.顺序
            正序
         */
        public int minCut(String s) {
            if (s == null || "".equals(s)) {
                return 0;
            }
            char[] array = s.toCharArray();
            int len = array.length;
            int[] dp = new int[len + 1];
            dp[0] = 0;
            // 遍历dp, 遍历"前"几个元素
            for (int i = 1; i < len + 1; i++) {
                dp[i] = Integer.MAX_VALUE;
                // 遍历数组本身, 遍历是从0 到 len - 1
                for (int j = 0; j < i; j++) {
                    // 这里为什么判断的是从j到i - 1, 因为i是前i个元素, 最后一位元素是i - 1
                    // 而j是元素本身, 所以不需要 - 1
                    if (isPartitioning(array, i - 1, j)) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
            return dp[len] - 1;
        }

        // 判断array从i开始到j是否是回文串
        // i > j
        private boolean isPartitioning(char[] array,
                                       int i, int j) {
            while (i >= j) {
                if (array[i] != array[j]) {
                    return false;
                }
                i--;
                j++;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question108().
                new Solution().minCut("a"));
    }
}
