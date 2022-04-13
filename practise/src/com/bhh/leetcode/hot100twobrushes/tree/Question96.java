package com.bhh.leetcode.hot100twobrushes.tree;

/**
 * @author bhh
 * @description 不同的二叉搜索树
 * @date Created in 2022-01-23 20:03
 * @modified By
 */
public class Question96 {
    class Solution {
        /*
        思路 : 如果整数1 ~ n中的 k 作为根节点值，则 1 ~ k-1 会去构建左子树，
        k+1 ~ n 会去构建右子树。
        左子树出来的形态有 aa 种，右子树出来的形态有 bb 种，则整个树的形态有 a * ba∗b 种。
        以 kk 为根节点的 BSTBST 种类数 = 左子树 BSTBST 种类数 * 右子树 BSTBST 种类数
        就好比，左手有编号1/2/3的手环，右手有编号5/6/7的手环，那搭配就有9种

        求方式 尝试dp 序列型dp
        1.状态
            dp[n] 定义为n个节点可以组成多少种二叉搜索树
        2.转换公式
            dp[i] = j:for(0 ~ i) | dp[j] * dp[i - j - 1]
        3.初始值和边界值
            dp[0] = 0
            dp[1] = 1
        4.顺序
         */
        public int numTrees(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 1; i < n + 1; i++) {
                for (int j = 0; j < i; j++) {
                    dp[i] += dp[j] * dp[i - j - 1];
                }
            }
            return dp[n];
        }
    }
}
