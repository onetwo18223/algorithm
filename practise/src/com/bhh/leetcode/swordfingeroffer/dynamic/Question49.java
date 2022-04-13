package com.bhh.leetcode.swordfingeroffer.dynamic;

import java.util.function.Predicate;

/**
 * @author bhh
 * @description 丑数
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。
 * 求按从小到大的顺序的第 n 个丑数。
 * <p>
 * 示例:
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 2 3 2*2 5 2*3 2*2*2 3*3 2*5
 * 12 是丑数的原因是 3 * 4 , 而4是丑数, 则2 * 4, 3 * 4, 5 * 4为丑数
 * @date Created in 2021-10-10 9:12
 * @modified By
 */
public class Question49 {
    class Solution {
        /*
        实现思路 :
            暴力解法
            动态规划 : 根据动态规划规律 从0开始 递增 index, 可以发现规律(这规律是人能发现的?)
                memo[]动态规划数组存储着关于对应索引大小的丑数
                index位置的丑数 = Math.min(a * 2, b * 3, c * 5);
                (a,b,c索引都是从0开始)(memo[0] = 1)

        收获 : 这道题并不好总结, 规律并没有自主发现,
        只可以推断若是需要这种三条信息齐头并进的可以使用三个索引
        然后根据动态规划规律寻找规律
         */
        public int nthUglyNumber(int n) {
            int[] memo = new int[n];
            memo[0] = 1;
            int a = 0, b = 0, c = 0;
            for (int i = 1; i < n; i++) {
                memo[i] = Math.min(memo[a] * 2, Math.min(memo[b] * 3, memo[c] * 5));
                if (memo[i] == memo[a] * 2) a++;
                if (memo[i] == memo[b] * 3) b++;
                if (memo[i] == memo[c] * 5) c++;
            }
            return memo[n - 1];
        }

        private int[] primes = new int[]{2, 3, 5};

        /**
         * 暴力解法
         * 判断n是否是丑数
         * 若是n可以被丑数除开, 则这个数取余 2 或者 3 或者 5 等于 0
         * 如果不等于 0 , 则表示这个数不是丑数
         *
         * @param n 当前数
         * @return
         */
        private boolean isUglyNum(int n) {
            for (int prime : primes) {
                while (n % prime == 0)
                    n /= prime;
            }
            return n == 1 ? true : false;
        }
    }
}
