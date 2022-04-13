package com.bhh.leetcode.headquarters.dynamic;

/**
 * @author bhh
 * @description 解码方法
 * @date Created in 2021-12-31 10:23
 * @modified By
 */
public class Question91 {
    class Solution {
        /*
        第二遍实现
        求方式/ 动态规划/ 划分型动态规划
        状态 :
            最后一个 :
                俩种情况 : 单个数字可以进行划分 和 俩个数字可以进行划分
            子问题 : 需要知道前n-1和n-2的解密方式数
            定义dp[len + 1]为前len个元素的解密方式数
        公式 : dp[i] = dp[i - 1]|0 < charArray[i - 1] < 10
            + dp[i - 2]|10 <= charArray[i - 2] * 10 + charArray[i - 1] <= 26
        初始值和边界值 : dp[0] = 1
        顺序 : 正序
         */
        public int numDecodings(String s) {
            if (s == null || "".equals(s)) {
                return 0;
            }
            char[] charArray = s.toCharArray();
            int len = charArray.length;
            int[] dp = new int[len + 1];
            dp[0] = 1;
            for (int i = 1; i < len + 1; i++) {
                // dp[i] = dp[i - 1]|0 < charArray[i - 1] < 10
                //            + dp[i - 2]|10 <= charArray[i - 2] * 10 + charArray[i - 1] <= 26
                dp[i] = 0;
                int tmp = charArray[i - 1] - '0';
                if (0 < tmp && tmp < 10) {
                    dp[i] += dp[i - 1];
                }
                if (i <= 1) {
                    continue;
                }
                tmp = (charArray[i - 2] - '0') * 10 + (charArray[i - 1] - '0');
                if (10 <= tmp && tmp <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
            return dp[len];
        }
    }
}
