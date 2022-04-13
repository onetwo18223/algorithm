package com.bhh.lintcode.dynamic;

/**
 * @author bhh
 * @description 打劫房屋
 * @date Created in 2021-12-31 14:57
 * @modified By
 */
public class Question392 {
    public class Solution {
        /*
        最多可以得多少钱/ 最值问题 / 考虑DP/ 序列 + 状态 序列型DP
        1.状态
            这道题目所求的最大存放钱数, dp数组应该存放金钱数目, 但是还需要存储前一个房屋的状态
                所以dp定义为dp[i][j]存储前i个房子的最大金额, 并且第i-1的状态为j(0没抢/1抢了)
            最后一步
                如果i-1被抢了, 那么i就不抢
                如果i-1没有被抢, 那么就可以抢i
                寻找一个最大值
            子问题
                i-1有没有被抢
        2.转换公式
            dp[i][0/1] 0表示没抢, 1表示抢了
            dp[i][1] = Math.max dp[i - 1][0] + money[i - 1]
            dp[i][0] = Math.max dp[i - 1][1]
        3.初始值和边界值
            初始值 dp[0][i] = 0;
        4.顺序
            正序
         */
        public long houseRobber(int[] money) {
            if (money == null || money.length == 0) {
                return 0;
            }
            int len = money.length;
            long[][] dp = new long[len + 1][2];
            dp[0][0] = dp[0][1] = 0;
            // 遍历房子
            for (int i = 1; i < len + 1; i++) {
                // 不偷当前房子, 那么取前一个房子偷和不偷的最大值
                // Error : dp[i][0] = dp[i - 1][1] 并不是这个房子不偷, 上个房子一定被偷
                dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
                dp[i][1] = dp[i - 1][0] + money[i - 1];
            }
            return Math.max(dp[len][0], dp[len][1]);
        }

        /*
        简化版本 (因为可以简化到只有俩种可能)
        定义dp[i]为前i个房子可获取到的最大价值
        则对于i
            偷 : money[i - 1] + dp[i - 2]
            不偷 : 继承dp[i - 1]

        问 : 如果房屋刷漆也只有俩个配色, 能否也进行简化?
            经过思考, 我觉得不行, 因为配色问题, 每个房屋都需要配色,
                而打家劫舍问题, 可以跳过某个房屋
         */
        public long houseRobberSimple(int[] money) {
            if (money == null || money.length == 0) {
                return 0;
            }
            int len = money.length;
            long[] dp = new long[len + 1];
            dp[0] = 0;
            dp[1] = money[0];
            // 遍历房子
            for (int i = 2; i < len + 1; i++) {
                // 遍历获取 第i - 1 房子要不要被抢
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i - 1]);
            }
            return dp[len];
        }
    }
}
