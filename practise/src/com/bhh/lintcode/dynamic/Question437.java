package com.bhh.lintcode.dynamic;

/**
 * @author bhh
 * @description 书籍复印
 * @date Created in 2022-01-01 14:40
 * @modified By
 */
public class Question437 {
    public class Solution {
        /*
        求最短时间/ 求最值/ 考虑DP/ 划分型
        1.状态
            最后一步 :
                最优策略:从j 到 len - 1由第k个人抄, 那么前j个元素由k - 1个人抄
            子问题 :
                j个元素由第n个人完成
            dp不仅需要表示前j个元素完成的最短时间, 还需要表示由第几个人完成
            那么dp[n][j]可以表示n个人完成前j本书的最少时间
        2.公式转换
            dp[i][n] = Math.min(Math.max(sum(pages(j ~ i))|j:(0 ~ i),
            dp[i - 1][n]), dp[i][n])
            // 在这一步, sum计算合集时, 因为需要在j当前这一步就做出dp[i][n]的数据更新,
            // 所以sum计算需要一次循环到位, 否则里面再嵌套一层for, 大大加大了复杂度
            // sum的计算可以反向计算: 因为是计算j 到 i, 且计算直接的sum, 所以从 j=i 到 j>=0
            // sum += pages[j - 1];, 每次循环添加一次pages, 就可以计算 j 到 i 的sum
            // 很好的办法
        3.初始值和边界值
            dp[0][0] = 0;
        4.顺序
            正序
         */
        public int copyBooks(int[] pages, int k) {
            if (pages == null || pages.length == 0) {
                return 0;
            }
            int len = pages.length;
            int[][] dp = new int[k + 1][len + 1];
            dp[0][0] = 0;
            for (int i = 1; i < len + 1; i++) {
                dp[0][i] = Integer.MAX_VALUE;
            }

            for (int i = 1; i < k + 1; i++) {
                // 遍历每一本书
                for (int j = 0; j < len + 1; j++) {
                    dp[i][j] = Integer.MAX_VALUE;
                    int sum = 0;
                    for (int l = j; l >= 0; l--) {
                        dp[i][j] = Math.min(
                                Math.max(sum, dp[i - 1][l]), dp[i][j]);
                        if (l > 0) {
                            sum += pages[l - 1];
                        }
                    }
                }
            }
            return dp[k][len];
        }
    }
}
