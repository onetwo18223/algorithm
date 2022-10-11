package org.problem.dp;

/**
 * 机器人路径方式问题I
 */
public class MDQuestion114 {
    public int uniquePaths(int m, int n){
        int[][] dp = new int[m][n];
        // row
        for (int i = 0; i < m; i++) {
            // line
            for (int j = 0; j < n; j++) {
                // i == 0 || j == 0 属于边界，
                // 不会进行相加，也就是说只会继承上一个元素值
                // 一直继承 dp[0][0] = 1
                if (i == 0 || j == 0)
                    dp[i][j] = 1;
                // 上一个元素和左边一个元素进行相加
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
