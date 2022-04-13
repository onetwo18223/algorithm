package com.bhh.lintcode.dynamic;

/**
 * @author bhh
 * @description 不同的路径 II
 * @date Created in 2021-12-29 9:44
 * @modified By
 */
public class Question115 {
    public class Solution {
        // 有多少种方式(计数)/ 动态规划/ 坐标型动态规划
        // 1.确定状态 :
        //      最后一步 : 是由 nums[m - 1][n - 2] 或者 nums[m - 2][n - 1]
        //          向向下或者向右走一步到达最右下角,
        //          也就是dp[m - 1][n - 1] = dp[m - 2][n - 1] + dp[m - 1][n - 2]
        //      子问题 : 如何到达nums[m - 1][n - 2] 和 nums[n - 2][m - 1]呢?
        // 2.转换方程 : dp[i][j] =  dp[i - 2][j - 1] + dp[i - 1][j - 2]
        // 3.初始值和边界 : dp[0][0] = 1,
        //      i == 0 && dp[i][j - 1] == 1, dp[i][j] == 1
        //      j == 0 && dp[i - 1][j] == 1, dp[i][j] == 1
        //      nums[i][j] == 1时, dp[i][j] == 0
        // 4.计算顺序 : 正序
        public int uniquePathsWithObstacles(int[][] nums) {
            int[][] dp = new int[nums.length][nums[0].length];
            dp[0][0] = 1;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[0].length; j++) {
//                    if (nums[i][j] == 1) {
//                        dp[i][j] = 0;
//                    } else if (i == 0) {
//                        if (j == 0) {
//                            dp[i][j] = 1;
//                        } else {
//                            dp[i][j] = dp[i][j - 1] == 1 ? 1 : 0;
//                        }
//                    } else if (j == 0) {
//                        dp[i][j] = dp[i - 1][j] == 1 ? 1 : 0;
//                    } else {
//                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//                    }
                    dp[i][j] = 0;
                    if (nums[i][j] == 1) {
                        continue;
                    }
                    if (i == 0 && j == 0) {
                        dp[i][j] = 1;
                        continue;
                    }
                    if (i > 0) {
                        dp[i][j] += dp[i - 1][j];
                    }
                    if (j > 0) {
                        dp[i][j] += dp[i][j - 1];
                    }
                }
            }
            return dp[nums.length - 1][nums[0].length - 1];
        }
    }
}
