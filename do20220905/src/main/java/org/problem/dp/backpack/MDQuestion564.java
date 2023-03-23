package org.problem.dp.backpack;

/**
 * 背包问题VI
 *
 * 关键点：
 *  每个物品可以多次使用
 *
 * 那么本题就会类似于 Question322零钱兑换
 */
public class MDQuestion564 {
    public int backPackVI(int[] nums, int target) {
        // 容量
        int[] dp = new int[target + 1];
        dp[0] = 1;
        // 遍历背包大小
        for (int i = 1; i <= target; i++) {
            dp[i] = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j])
                    dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }
}
