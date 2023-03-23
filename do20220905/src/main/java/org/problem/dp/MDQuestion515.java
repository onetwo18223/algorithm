package org.problem.dp;

/**
 * TODO: 序列性
 * 装修房屋
 *
 * 1.1 最后一步
 *      三种情况，最后一个房子是红蓝绿色都有可能，所以需要对三种情况进行判断
 * 1.2 子问题
 *      前面房子的最小金额 + 最后一个房子不相邻颜色的金额
 * 2 转移方程
 *      dp[0~i][0~j] = dp[i - 1][!j] + costs[i][j]
 * 3 初始条件和边界
 *      dp[0][0] = 0;
 * 4 顺序
 */
public class MDQuestion515 {

    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0
                || costs[0] == null || costs[0].length == 0)
            return 0;
        int row = costs.length;
        int line = costs[0].length;
        int[][] dp = new int[row][line];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < line; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < line; k++) {
                    if (j == k) continue;
                    // 当前这个房子要染成这颜色，那么前一个房子不能是同一颜色
                    dp[i][j] = Math.min(dp[i][j], (i - 1 < 0 ? 0 : dp[i - 1][k]) + costs[i][j]);
                }
                if (i == row - 1)
                    res = Math.min(res, dp[i][j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MDQuestion515().minCost(new int[][]{
                {14, 2, 11},
                {11, 14, 5},
                {14, 3, 10}
        }));
    }
}
