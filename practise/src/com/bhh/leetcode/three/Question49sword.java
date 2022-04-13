package com.bhh.leetcode.three;

/**
 * @author bhh
 * @description 丑数
 * @date Created in 2022-01-28 19:17
 * @modified By
 */
public class Question49sword {
    class Solution {
        /*
        这道题需要三个指针 + dp配合完成
         */
        public int nthUglyNumber(int n) {
            int[] dp = new int[n];
            dp[0] = 1;
            int index1 = 0, index2 = 0, index3 = 0;
            for (int i = 1; i < n; i++) {
                int tmp1 = 2 * dp[index1];
                int tmp2 = 3 * dp[index2];
                int tmp3 = 5 * dp[index3];
                dp[i] = Math.min(Math.min(tmp1, tmp2), tmp3);
                if (dp[i] == tmp1) {
                    index1++;
                }
                if (dp[i] == tmp2) {
                    index2++;
                }
                if (dp[i] == tmp3) {
                    index3++;
                }
            }
            return dp[n - 1];
        }
    }
}
