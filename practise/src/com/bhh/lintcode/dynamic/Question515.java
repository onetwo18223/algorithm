package com.bhh.lintcode.dynamic;

/**
 * @author bhh
 * @description 房屋染色
 * @date Created in 2021-12-29 12:05
 * @modified By
 */
public class Question515 {
    /*
    第二遍, 思想
    最小问题, 最值/ 考虑动态规划/
    题目中有俩个点, 分别是费用最低, 那么这个肯定是要存储在dp数组当中的, 但是又需要相邻房间颜色不同, 所以这就是一道序列 + 状态的序列性dp

    状态
        最后一步, 第N - 1个房子的染色情况, 由N - 2的房子染色情况而定, 那就需要直到 N - 2 前的房子染色情况
        子问题, 前i个房子的染色最小费用, 并记录第i - 1个房子的染色
        需要dp[len][3] 描述前 len 个房子的最小费用和第len - 1个房子的染色情况
    公式转换
       dp[i][j] = for(k:0~2,j:0~2)min(dp[i - 1][k(k != j)] + costs[i - 1][j])
    初始值和边界
        初始值dp[0][0] = dp[0][1] = dp[0][2] = 0
    顺序
        正序
     */
    public class Solution {
        /*
        最低成本(最小值)/考虑动态规划/序列形DP
        1.状态 :
            最后一步 : dp数组存储的肯定是最低的成本价格,
                     要求N-1的房子的最低成本, 那么就需要知道N-2的房子颜色
                     也就是说dp不仅需要存储最低成本, 还需要存储前一个房子的每种颜色的情况下的最低成本
                     二维数组dp[i][j]
                     dp[i][0] 表示 房子i - 1选择了红色,
                     dp[i][1] 表示房子i - 1选择了蓝色,
                     dp[i][2] 表示房子i - 1选择了绿色
            子问题 : 需要知道每种颜色的情况下的最低成本价格
        2.转换公式 dp[i][j] = for(3) (循环房子i - 1 三种颜色的情况), for(3) (循环房子i - 2应该是哪个颜色),
          俩次循环值不能相等 (连续房子颜色不等),
          dp[i][0] = min(dp[i - 1][1] + costs[i - 1][0], dp[i - 1][2] + costs[i - 1][0])
          dp[i][1] = min(dp[i - 1][0] + costs[i - 1][0], dp[i - 1][2] + costs[i - 1][0])
          dp[i][0] = min(dp[i - 1][1] + costs[i - 1][0], dp[i - 1][2] + costs[i - 1][0])
          dp[i][j] = Math.min(dp[i - 1][k] + costs[i - 1][j])
        3.初始值和边界 初始值 dp[0](前0个房子, 表示不存在)为 0
        4.顺序 正序
         */
        public int minCost(int[][] costs) {
            int len = costs.length;
            int[][] dp = new int[len + 1][3];
            dp[0][0] = dp[0][1] = dp[0][2] = 0;
            for (int i = 1; i <= len; i++) {
                // j表示 i - 1 索引的房子选择哪个颜色
                for (int j = 0; j < 3; j++) {
                    dp[i][j] = Integer.MAX_VALUE;
                    // k表示 i - 2索引的房子选择了哪些颜色
                    for (int k = 0; k < 3; k++) {
                        if (j == k) {
                            continue;
                        }
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + costs[i - 1][j]);
                    }
                }
            }
            return Math.min(dp[len][0], Math.min(dp[len][1], dp[len][2]));
        }
    }
}
