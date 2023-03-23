package org.problem.dp;

/**
 * 最小路径
 *
 * 1.1 最后一步
 *      右下角终值 = 左边值 + 上边值
 * 1.2 子问题
 *      到达各个结点上最小路径
 * 2 转换公式
 *      dp[i][j] = Math.min(dp[i - 1][j] + dp[i][j - 1]) + nums[i][j]
 * 3 初始值和边界条件
 *      对于二维数组应该考虑到 i == 0 和 j == 0
 *      i == 0 && j == 0 dp[i][j] = nums[0][0]
 *      i == 0 dp[i][j] = dp[i][j - 1] + nums[i][j]
 *      j == 0 dp[i][j] = dp[i - 1][j] + nums[i][j]
 * 4 顺序
 */
public class MDQuestion110 {
    public int getMin(int[][] nums) {
        if (nums == null || nums.length == 0
                || nums[0] == null || nums[0].length == 0)
            return 0;
        int row = nums.length;
        int line = nums[0].length;
        int[][] dp = new int[row][line];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < line; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = nums[i][j];
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + nums[i][j];
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + nums[i][j];
                    continue;
                }
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + nums[i][j];
            }
        }
        return dp[row - 1][line - 1];
    }

    public static void main(String[] args) {
        System.out.println(new MDQuestion110().getMin(new int[][]{
                {14, 2, 11}, // 27
                {11, 1, 5},
                {14, 3, 10}
        }));
    }
}
