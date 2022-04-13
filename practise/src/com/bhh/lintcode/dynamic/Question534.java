package com.bhh.lintcode.dynamic;

/**
 * @author bhh
 * @description 打劫房屋2
 * @date Created in 2021-12-31 16:24
 * @modified By
 */
public class Question534 {
    public class Solution {
        /*
        打家劫舍的升级版, 升级的地方在于由线性升级到了圆
        打劫了0, 就不能打劫 n - 1
        打劫了n - 1, 就不能打劫0
        那么我们在这俩种情况选择一个最大值即可
         */
        public int houseRobber2(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int len = nums.length;
            int[] numsTmp = new int[len - 1];
            // 删除 len - 1
            for (int i = 0; i < len - 1; i++) {
                numsTmp[i] = nums[i];
            }
            int res = houseRobberSimple(numsTmp);
            // 删除 0
            for (int i = 1; i < len; i++) {
                numsTmp[i - 1] = nums[i];
            }
            return Math.max(res, houseRobberSimple(numsTmp));
        }

        public int houseRobberSimple(int[] money) {
            if (money == null || money.length == 0) {
                return 0;
            }
            int len = money.length;
            int[] dp = new int[len + 1];
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
