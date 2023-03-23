package org.problem.dp.divide;

/**
 * 完全平方数
 *
 * 划分型dp，特点：需要进行划分
 * 实现：
 * 1.1 定义
 *      dp[i]定义为当前元素可以划分的最少数量
 * 1.2 最后一步
 *      最后一个元素的最少划分数量需要对前面的元素进行遍历，
 *          获取dp[i - j * j]，以获取最小值
 * 2 转换公式
 *      dp[i] = Integer.MAX_VALUE;
 *      dp[i] = min(dp[i], dp[i - j * j] + 1);
 * 3 初始值和边界值
 *      dp[0] = 0;
 * 4 顺序
 */
public class Question279 {
    class Solution {
        public int numSquares(int n) {
            if (n == 0) return 0;
            int[] dp = new int[n + 1];
            dp[0] = 0;
            for (int i = 1; i <= n; i++) {
                dp[i] = Integer.MAX_VALUE;
                for (int j = 1; j * j <= i; j++) {
                    // 并非所有元素对应的dp是存在的
                    // 当有些dp不存在时就需要进行判断 dp[i] != 初始值
                    if (dp[i - j * j] != Integer.MAX_VALUE && dp[i - j * j] + 1 < dp[i])
                        dp[i] = dp[i - j * j] + 1;
                }
            }
            return dp[n];
        }
    }
}
