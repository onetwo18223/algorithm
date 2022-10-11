package org.problem.dp;

/**
 * 机器人路径方式问题I
 *
 * 实现：
 * 1.1 最后一步
 *      求方式，使用dp定义方式次数
 *      到达最后一个元素方式次数 = 到达左边元素方式次数 + 上边
 * 1.2 子问题
 * 2 转换方程
 *      dp[i][j] = array[i][j] == 0 ? dp[i - 1][j] + dp[i][j - 1] ? 0
 * 3 初始值和边界值
 *      i == 0 && j == 0 dp[i][j] = 1;
 *      (i == 0 || j == 0) && array[i][j] != 0
 *          dp[i][j] = 1
 * 4 顺序
 *
 */
public class MDQuestion115 {
    public int uniquePathsII(int[][] array) {
        if (array == null || array.length == 0
                || array[0] == null || array[0].length == 0)
            return 0;
        int row = array.length;
        int line = array[0].length;
        int[][] dp = new int[row][line];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < line; j++) {
                if (array[i][j] == 1){
                    dp[i][j] = 0;continue;
                }
                // 处理边界条件
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[row - 1][line - 1];
    }
}
