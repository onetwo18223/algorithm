package com.bhh.lintcode.dynamic;

/**
 * @author bhh
 * @description 房屋染色 II
 * @date Created in 2021-12-31 14:16
 * @modified By
 */
public class Question516 {
    public class Solution {
        /*
        Question515 plus/ 序列 + 状态 序列性DP
        1.状态
            最后一步
            子问题
            dp[i][j], i表示前i个房屋, 最后一个房屋是i - 1, j表示第几种颜色
        2.转换公式
            问题升级的地方在于如何判断各种不同染料获得最小值
            如果像上一道题俩个循环
        3.初始值和边界值
        4.顺序
         */
        public int minCostII(int[][] costs) {
            if (costs == null || costs.length == 0 || costs[0] == null || costs[0].length == 0){
                return 0;
            }
            int rowLen = costs.length;
            int lineLen = costs[0].length;
            if (lineLen == 1) {
                return costs[0][0];
            }
            // 初始化dp, 设置初始值
            int[][] dp = new int[rowLen + 1][lineLen];
//            for (int i = 0; i < lineLen; i++) {
//                dp[0][i] = 0;
//            }

            // 遍历房屋
            for (int i = 1; i < rowLen + 1; i++) {
                // 表示i - 1的房子的染料颜色
                for (int j = 0; j < lineLen; j++) {
                    dp[i][j] = Integer.MAX_VALUE;
                    // 表示i - 2的房子的染料颜色
                    for (int k = 0; k < lineLen; k++) {
                        // 颜色不可相同
                        if (j == k) {
                            continue;
                        }
                        dp[i][j] = Math.min(dp[i - 1][k] + costs[i - 1][j], dp[i][j]);
                    }
                }
            }
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < lineLen; i++) {
                res = Math.min(dp[rowLen][i], res);
            }
            return res;
        }

    }
    public static void main(String[] args) {
        System.out.println(new Question516().new Solution().minCostII(new int[][]{
                {14, 2, 11},
                {11, 14, 5},
                {14, 3, 10}
        }));
    }
}
