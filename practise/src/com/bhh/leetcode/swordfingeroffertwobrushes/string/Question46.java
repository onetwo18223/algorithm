package com.bhh.leetcode.swordfingeroffertwobrushes.string;

/**
 * @author bhh
 * @description 把数字翻译成字符串
 * @date Created in 2022-01-15 19:45
 * @modified By
 */
public class Question46 {
    class Solution {
        /*
        使用数字翻译成字符串
        求方式 dp 划分
        1.状态
            dp[i] 定义的是前i个元素有多少种翻译方式
            最后一个
                若是单独最后一个元素则一定可以翻译成字符串
                若是俩个元素若是 <= 26 则仍然可以翻译成字符串
            子问题
        2.转换公式
            dp[i] += dp[i - 1]| 元素i可以单独形成字符串
            dp[i] += dp[i - 2]| 元素i和元素i + 1可以形成字符串
        3.初始值和边界值
            dp[0] = 1;
        4.顺序
            正序
         */
        public int translateNum(int num) {
            String str = String.valueOf(num);
            int len = str.length();
            int[] dp = new int[len + 1];
            dp[0] = 1;
            for (int i = 1; i < len + 1; i++) {
                dp[i] += dp[i - 1];
                if (i > 1 && (str.charAt(i - 2) - '0')!= 0
                        && (str.charAt(i - 2) - '0') * 10 + (str.charAt(i - 1) - '0') <= 25) {
                    dp[i] += dp[i - 2];
                }
            }
            return dp[len];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question46().
                new Solution().translateNum(506));
    }
}
