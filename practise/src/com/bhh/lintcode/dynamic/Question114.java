package com.bhh.lintcode.dynamic;

/**
 * @author bhh
 * @description 不同的路径
 * @date Created in 2021-12-28 19:32
 * @modified By
 */
public class Question114 {
    public class Solution {
        /*
        问有多少条路径?
        可以使用DFS, 但是复杂度太高
            如果具体问有哪些路径, 可以使用DFS
         */
        // 1.确定状态 :
        //      最后一步 : 机器人最后一步是到达(m - 1, n - 1), 那么他的
        //          前一步是 (m - 1, n - 2) 或者 (m - 2, n - 1),
        //          也就是说dp[m - 1][n - 1] = dp[m - 1][n - 1] + dp[m - 2][n - 1];
        //      子问题 : 机器人有多少种方法走到dp[m - 1][n - 2], 有多少种方法走到dp[m - 2][n - 1]
        // 2.转移方程 : dp[m - 1][n - 1] = dp[m - 1][n - 1] + dp[m - 2][n - 1];
        // 3.初始条件和边界条件 :
        //      初始条件 : dp[0][0] = 1
        //      边界条件 : 如果 i == 0, j == 0, 那么对应的 dp 应该是0 (机器人只能往右走和往下走)
        // 4.计算顺序 : 从(0, 0)到(m - 1, n - 1)
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            dp[0][0] = 1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
            return dp[m - 1][n - 1];
        }
    }
}
