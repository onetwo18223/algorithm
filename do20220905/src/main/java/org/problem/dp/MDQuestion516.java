package org.problem.dp;

/**
 * 房屋染色 II
 *
 * 实现：
 * 1.1 最后一步
 *      前面房子最少金钱数 + 最后的房子（前一个房子不同的颜色）的最小颜色金额
 * 1.2 子问题
 * 2 转换公式
 *      i 表示房屋
 *      j 表示选择这个颜色
 *      dp[i][j] = Min(dp[i - 1] + Min(costs[i][k|k : 0 ~ j]))
 *      可以错位
 *      dp[i][j] = Min(dp[i - 1] != Integer.MAX_VALUE + Min(costs[i - 1][k|k : 0 ~ j]))
 * 3 初始值和边界值
 *      dp[0] = 0;
 * 4 顺序
 */
public class MDQuestion516 {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0
                || costs[0] == null || costs[0].length == 0)
            return 0;
        // 房子的数量
        int houseNum = costs.length;
        // 颜色的数量
        int paintNum = costs[0].length;
        // 如果只有一个房子要装修
        if (paintNum == 1)
            return costs[0][0];

        int res = Integer.MAX_VALUE;
        int[][] dp = new int[houseNum + 1][paintNum];
        for (int i = 1; i <= houseNum; i++) {
            // 遍历当前元素的颜色
            for (int j = 0; j < paintNum; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                // 遍历前一个元素的颜色
                for (int k = 0; k < paintNum; k++) {
                    if (j == k) continue;
                    if (dp[i - 1][k] + costs[i - 1][j] < dp[i][j])
                        dp[i][j] = dp[i - 1][k] + costs[i - 1][j];
                }
                if (i == houseNum)
                    res = Math.min(res, dp[i][j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MDQuestion516().minCostII(new int[][]{
                {6}
        }));
    }
}
