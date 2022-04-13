package com.bhh.lintcode.dynamic;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @author bhh
 * @description 换硬币
 * @date Created in 2021-12-28 12:42
 * @modified By
 */
public class Question669 {
    public class Solution {
        /*
        可以使用DFS, 并且使用min记录最少硬币数量, 但是复杂度过高
            优化 : 使用记忆化搜索
        题目中提到了最少, 那么是否可以理解为BFS的最短路径

        这是最大最小型动态规划
         */
        // BFS, 提交成功了, 但是复杂度很高, DFS会更高
        public int coinChange(int[] coins, int amount) {
            if (amount == 0) {
                return 0;
            }
            Map<Integer, Integer> visited = new HashMap();
            Queue<Integer> queue = new ArrayDeque();
            queue.add(amount);
            visited.put(amount, 0);
            while (!queue.isEmpty()) {
                int len = queue.size();
                for (int i = 0; i < len; i++) {
                    Integer element = queue.poll();
                    for (int j = 0; j < coins.length; j++) {
                        int tmp = element - coins[j];
                        if (tmp == 0) {
                            return visited.get(element) + 1;
                        }
                        if (tmp < 0) {
                            continue;
                        }
                        if (visited.containsKey(tmp)) {
                            continue;
                        }
                        queue.add(tmp);
                        visited.put(tmp, visited.get(element) + 1);
                    }
                }
            }
            return -1;
        }

        // 动态规划
        // 1. 状态 : dp[x], amount - dp[x]
        // 2. 转移方程 : for循环 + dp[x] = min(dp[x - coins[i]] + 1, dp[x])
        // 3. 初始条件 : dp[0] = 0, dp[x] 不存在则赋值 Integer.MAX_INTEGER
        // 4. 计算顺序 : 一般是从 0 ~ x
        public int coinChangeDP(int[] coins, int amount) {
            // 初始化DP
            int[] dp = new int[amount + 1];
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                dp[i] = Integer.MAX_VALUE;
                for (int j = 0; j < coins.length; j++) {
                    // 当前面值要大于等于硬币面值 && dp[面值减去硬币面值] 的值并非无穷大(即没有方案) &&
                    if (i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                    }
                }
            }
            return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question669().new Solution().coinChangeDP(new int[]{
                1, 2, 5
        }, 11));
    }
}
