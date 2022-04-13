package com.bhh.lintcode.dynamic;

/**
 * @author bhh
 * @description 跳跃游戏
 * @date Created in 2021-12-28 19:53
 * @modified By
 */
public class Question116 {
    public class Solution {
        /*
        动态规划例题, 但是有一个比较简单的方法解决(贪心)
         */
        public boolean canJump(int[] A) {
            // k表示最长可以到达哪里
            int k = 0;
            for (int i = 0; i < A.length; i++) {
                if (k < i) return false;
                k = Math.max(k, i + A[i]);
                if (k > A.length) {
                    return true;
                }
            }
            return true;
        }

        // 错误 :
        // 动态规划
        // 确定状态 :
        //      最后一个 : dp[len] = dp[len - 1] && (A[len - 1] > 1)
        //      子问题 : 该元素dp[i]状态是true or false, 由dp[i - 1]的状态和对应数组索引中的值是否 > 1 共同决定
        // 转移方程 : dp[i] = dp[i - 1] && (A[i - 1] > 1)
        // 初始值和边界值 : dp[0] = true;
        // 计算顺序 : 正序
        public boolean canJumpDPError(int[] A) {
            boolean[] dp = new boolean[A.length];
            dp[0] = true;
            for (int i = 1; i < A.length; i++) {
                dp[i] = dp[i - 1] && A[i] > 1;
            }
            return dp[A.length - 1];
        }

        // 动态规划
        // 确定状态 :
        //      最后一个 : 最后一步由 i 跳到 len - 1 的位置, 那么 len - 1 - i <= A[i]
        //      子问题 : 又是怎么跳到了i的位置呢?
        // 转移方程 : dp[i] = 从0到i获取j, 需要j满足 dp[j] && i - j <= A[i]
        // 初始值和边界值 : dp[0] = true;
        // 计算顺序 : 正序
        public boolean canJumpDP(int[] A) {
            int len = A.length;
            boolean[] dp = new boolean[len];
            dp[0] = true;
            for (int i = 1; i < len; i++) {
                dp[i] = false;
                for (int j = 0; j < i; j++) {
                    if (dp[j] && i - j <= A[j]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[len - 1];
        }
    }
}
