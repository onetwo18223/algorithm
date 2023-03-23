package org.problem.dp.backpack;

/**
 * 背包问题 II
 * 定义dp[][]为 0个物品装满容量为0的背包的最大价值
 */
public class MDQuestion125 {
    public int backPackII(int m, int[] a, int[] v) {
        if(a == null || a.length == 0) return 0;
        int len = a.length;
        int[][] dp = new int[len + 1][m + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            // -1表示不可能
            dp[0][i] = -1;
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - a[i - 1] >= 0 && dp[i - 1][j - a[i - 1]] + v[i - 1] != -1) {
                    dp[i][j] = Math.max(dp[i][j]
                            , dp[i - 1][j - a[i - 1]] + v[i - 1]);
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
