package org.problem.dp.backpack;

/**
 * 背包问题 V
 *
 * 每个物品只能使用一次
 * 本题只求方式，不求具体组和，不必使用dfs，使用dp即可
 * 1.1 定义
 *      dp[n][m] 前 n个物品装满 m容量的方式数
 * 1.2 最后一步
 *      i : for(0 ~ m)
 *      dp[n][m] = dp[n - 1][m - i]
 * 2 转换公式
 *      dp[n][m] = sum(dp[n - 1][m - i])
 * 3 初始值和边界值
 *      dp[0][0] = 1;
 * 4 顺序
 */
public class MDQuestion563 {
    public int backPackV(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[][] dp = new int[len + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= target; i++)
            dp[0][i] = 0;

        // 遍历物品
        for (int i = 1; i <= len; i++) {
            // 遍历容量
            for (int j = 0; j <= target; j++) {
                // i个物品装满容量j的方式 =  i - 1个物品装满容量j的方式
                //      + i - 1个物品装满容量j - nums[i - 1]的方式
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1])
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
            }
        }
        return dp[len][target];
    }
}
