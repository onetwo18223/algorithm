package com.bhh.leetcode.swordfingeroffertwobrushes.array.dp;

/**
 * @author bhh
 * @description 丑数
 * @date Created in 2022-01-20 9:37
 * @modified By
 */
public class Question49 {
    class Solution {
        /*
        题目要求求出第n个丑数
        最后一个元素和前元素存在依赖性 尝试dp 坐标型dp
        1.状态
            dp[i]表示第i个丑数
            错误
                最后一步 第i个丑数可能是前一个元素乘2, 乘3, 乘5或者是前2个元素又或者是前三个元素如此
                子问题 求i的前三位元素的丑数
            最后一步 第i个丑数可能是前面的某个或其他元素乘2, 乘3, 乘5的最小值
        2.转换公式
            创建3个指针, 分别表示 *2序列, *3序列和*5序列, 某一个序列被选中则对应指针++
            dp[i] = min(min(2 * dp[a], 3 * dp[b]), 5 * dp[c]);
        3.初始值和边界值
            dp[0] = 1;
        4.顺序
         */
        public int nthUglyNumber(int n) {
            int[] dp = new int[n];
            dp[0] = 1;
            int a = 0, b = 0, c = 0;
            for (int i = 1; i < n; i++) {
                int tmp1 = 2 * dp[a];
                int tmp2 = 3 * dp[b];
                int tmp3 = 5 * dp[c];
                dp[i] = Math.min(Math.min(tmp1, tmp2), tmp3);
                if (dp[i] == tmp1) {
                    a++;
                }
                if (dp[i] == tmp2) {
                    b++;
                }
                if (dp[i] == tmp3) {
                    c++;
                }
            }
            return dp[n - 1];
        }
    }
}
