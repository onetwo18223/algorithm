package com.bhh.lintcode.dynamic;

/**
 * @author bhh
 * @description 解码方法
 * @date Created in 2021-12-29 19:01
 * @modified By
 */
public class Question512 {
    public class Solution {
        /*
        几种方式/动态规划/划分型动态规划
        1.状态
            dp[i]定义为存储前i个数据的解码方式
            最后一步 :
                最后的单独一个元素形成的解码方式 += dp[i - 1]
                最后俩个元素形成的解码方式 += dp[i - 2]
                我又等于dp[i - 1], 又等于dp[i - 2], 一般来说都会相加
            子问题
        2.方程转换
            dp[len] = dp[len - 1]|判断str[len - 1]解码方式 +
                dp[len - 2]|判断str[len - 2]解码方式
        3.初始值和边界值
            dp[0] = 1
        4.顺序
            正序
         */
        public int numDecodings(String s) {
            char[] charArray = s.toCharArray();
            int len = charArray.length;
            if (len == 0) {
                return 0;
            }
            int[] dp = new int[len + 1];
            dp[0] = 1;
            for (int i = 1; i < len + 1; i++) {
                dp[i] = 0;
                int tmp = charArray[i - 1] - '0';
                if (tmp >= 1 && tmp <= 9) {
                    dp[i] += dp[i - 1];
                }

                if (i >= 2) {
                    tmp = (charArray[i - 2] - '0') * 10
                            + (charArray[i - 1] - '0');
                    if (tmp >= 10 && tmp <= 26) {
                        dp[i] += dp[i - 2];
                    }
                }
            }
            return dp[len];
        }
    }
}
