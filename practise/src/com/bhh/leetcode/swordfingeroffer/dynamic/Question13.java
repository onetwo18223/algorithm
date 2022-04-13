package com.bhh.leetcode.swordfingeroffer.dynamic;

/**
 * @author bhh
 * @description 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 * <p>
 * 示例 1：
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * @date Created in 2021-10-10 18:43
 * @modified By
 */
public class Question13 {
    class Solution {
        /*
        实现思路 : 尝试动态规划
        机器人, 从0,0开始走, 那么就只能往下或者往右走
        需要注意的是, 数组中包含三种类型区域,
            大于k区域
            小于k机器人可以走到的区域
            小于k机器人走不到的区域

        总结 : 对于二维数组的问题,
                动态规划, DFS, BFS, 查找数据(二分), 找规律
                    动态规划一般是用于保存某种情况, 某一个状态,
                        + 可能是由某一种规律
                        + 也可能是需要保存自身状态, 本题的boolean数组
                    二位数组的规律 : 很可能是通过邻边的元素进行简单运算来实现

                这道题和Question12的不同点在于, 起点虽然固定, 但是可运行分区划分出了更多
                刚开始没有考虑到 小于k机器人走不到的区域 导致出错
                Question12依靠DFS可以很简单实现, 而Question13因为更多的限制规律难找
                动态规划数组存储状态反而比较好实现,
                而递归需要考虑规律和机器人是否走过这个宫格, 实现较难

         */
        public int movingCountD(int m, int n, int k) {
            boolean[][] memo = new boolean[m][n];
            memo[0][0] = true;
            int res = 1;
            for (int i = 1; i < memo[0].length; i++) {
                if (getSum(i, 0) <= k) {
                    memo[0][i] = memo[0][i - 1];
                    if (memo[0][i])
                        res++;
                }
            }
            for (int i = 1; i < memo.length; i++) {
                for (int j = 0; j < memo[0].length; j++) {
                    if (getSum(i, j) <= k) {
                        memo[i][j] = memo[(i - 1) >= 0 ? i - 1 : i][j] ||
                                memo[i][(j - 1) >= 0 ? j - 1 : j];
                        if (memo[i][j]) res++;
                    }
                }
            }
            return res;
        }

        /*
        通过DFS实现
         */
        private boolean visited[][];

        public int movingCount(int m, int n, int k) {
            this.visited = new boolean[m][n];
            return re(0, 0, m, n, k);
        }

        private int re(int row, int line, int m, int n, int k) {
            if (row >= m || line >= n || getSum(row, line) > k || visited[row][line])
                return 0;
            visited[row][line] = true;
            return re(row + 1, line, m, n, k) + re(row, line + 1, m, n, k) + 1;
        }

        private int getSum(int i, int i1) {
            int tmp = i;
            int sum = 0;
            while (tmp > 0) {
                sum += tmp % 10;
                tmp /= 10;
            }
            tmp = i1;
            while (tmp > 0) {
                sum += tmp % 10;
                tmp /= 10;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question13().
                new Solution().movingCount(16, 8, 4));
    }
}
