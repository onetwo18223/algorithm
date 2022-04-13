package com.bhh.leetcode.hot100.math;

/**
 * @author bhh
 * @description 不同的二叉搜索树
 * @date Created in 2022-01-02 20:03
 * @modified By
 */
public class Question96 {
    class Solution {
        /*
        CV工程, 使用了  卡特兰数 公式
        G(n)=G(0)∗G(n−1)+G(1)∗(n−2)+...+G(n−1)∗G(0)
        记住他!
         */
        public int numTrees(int n) {
            int[] G = new int[n + 1];
            G[0] = 1;
            G[1] = 1;

            for (int i = 2; i <= n; ++i) {
                for (int j = 1; j <= i; ++j) {
                    G[i] += G[j - 1] * G[i - j];
                }
            }
            return G[n];
        }
    }

}
