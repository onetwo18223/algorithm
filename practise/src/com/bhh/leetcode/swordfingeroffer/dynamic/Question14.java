package com.bhh.leetcode.swordfingeroffer.dynamic;

/**
 * @author bhh
 * @description 剪绳子
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段
 * （m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，
 * 此时得到的最大乘积是18。
 * <p>
 * 示例 1：
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * <p>
 * 示例2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 ×3 ×4 = 36
 * @date Created in 2021-10-10 15:00
 * @modified By
 */
public class Question14 {
    class Solution {
        /*
        实现思路 : 思路如潮水般涌起, 和之前一道题一样
        记忆化搜索, 每一次将参数n分为俩段, 再将这俩段进行继续分
         */
        private int[] memo;

        public int cuttingRope(int n) {
            memo = new int[n + 1];
            return re(n);
        }

        private int re(int n) {
            if (n == 1) {
                return 1;
            }
            if (n == 0) {
                return 0;
            }
            if (memo[n] != 0) {
                return memo[n];
            }
            int res = -1;
            for (int i = 1; i <= n - 1; i++) {
                res = Math.max(res,
                        Math.max(i * re(n - i), i * (n - i)));
            }
            memo[n] = res;
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question14().new Solution().cuttingRope(10));
    }
}
