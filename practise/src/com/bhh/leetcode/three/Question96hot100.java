package com.bhh.leetcode.three;

/**
 * @author bhh
 * @description 不同的二叉搜索树
 * @date Created in 2022-01-31 15:58
 * @modified By
 */
public class Question96hot100 {
    class Solution {
        /*
        求方式 尝试dp 序列型dp
        1.状态
            dp[n + 1] 表示 n 个节点形成的二叉搜索树的数量
        2.转换公式
            dp[i] = dp[j] | d : for(0 ~ i - 1) * dp[i - j - 1];
        3.初始值和边界值
            dp[0] = 1;
            dp[1] = 1;
        4.顺序
            正序
         */
        public int numTrees(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i < n + 1; i++) {
                for (int j = 0; j < i; j++) {
                    dp[i] += dp[j] * dp[i - j - 1];
                }
            }
            return dp[n];
        }
    }
}
