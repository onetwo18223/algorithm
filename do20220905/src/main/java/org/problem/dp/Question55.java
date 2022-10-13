package org.problem.dp;

/**
 * 跳跃游戏
 *
 * 实现：注意本题最佳解法其实是模拟，但是可以使用dp实现
 */
public class Question55 {
    class Solution {
        public boolean canJump(int[] nums) {
            if (nums == null || nums.length == 0)
                return false;
            int length = nums.length;
            boolean[] dp = new boolean[length];
            dp[0] = true;
            for (int i = 1; i < length; i++) {
                // 遍历之前的元素
                for (int j = 0; j < i; j++) {
                    if (dp[j] && (j + nums[j] >= i)){
                        dp[i] = true;break;
                    }
                }
            }
            return dp[length - 1];
        }
    }
}
