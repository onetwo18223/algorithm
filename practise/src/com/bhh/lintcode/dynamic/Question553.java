package com.bhh.lintcode.dynamic;

import com.bhh.leetcode.hot100.array.Question53;

/**
 * @author bhh
 * @description 炸弹袭击
 * @date Created in 2021-12-31 12:28
 * @modified By
 */
public class Question553 {
    public class Solution {
        /*
        最大, 求最值 + 结合矩阵/ 考虑动态规划 /坐标型dp
        1.状态
            递推一般和前面某个元素是有关联的,
                而如果按照题意, war和enemy是不允许放炸弹的, 那么dp[i]和dp[j]的等式就无法成立
                所以我们先假设war和enemy都是可以放炸弹的, war的位置可以炸0个人, enemy的位置可以炸1人
            题意是三个方向, 先解决一个方向, 剩下三个方向进行复制
            最后一步
                dp[i][j]可以炸来自上方的n个敌人, grid[i][j] == e, 则dp[i][j] = dp[i - 1][j] + 1
            子问题
                dp[i - 1][j]可以炸上方的几个人
        2.公式转换
            碰到e, +1; 碰到w, 重置为0; 碰到0, 不变继承
            dp[i][j] += dp[i - 1][j] + 1|grid[i][j] == 'e'; // 上 注意判空
            dp[i][j] += dp[i + 1][j] + 1|grid[i][j] == 'e'; // 下 注意判空
            dp[i][j] += dp[i][j - 1] + 1|grid[i][j] == 'e'; // 左 注意判空
            dp[i][j] += dp[i][j + 1] + 1|grid[i][j] == 'e'; // 右 注意判空
        3.初始值和边界值
            dp[0][0] =  dp[i - 1][j] + 1|grid[0][0] == 'e' / 0|grid[0][0] == 'w' / dp[i - 1][j]|0
            边界就是矩阵边界
        4.顺序
            正序

        错误点
        每个方向的遍历不应都存储在一个数组中, 数据再个这种情况下是无法统一处理的
        初始化错误
         */
        public int maxKilledEnemiesError(char[][] grid) {
            if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
                return 0;
            }
            int rowLen = grid.length;
            int lineLen = grid[0].length;
            // 初始化dp, 初始值
            int[][] dp = new int[rowLen][lineLen];
            for (int i = 0; i < lineLen; i++) {
                dp[0][i] = grid[0][i] == 'E' ? 1 : 0;
            }

            // up 上方 从上到下
            for (int i = 1; i < rowLen; i++) {
                for (int j = 0; j < lineLen; j++) {
                    dp[i][j] = 0;
                    if (grid[i][j] == 'E') {
                        dp[i][j] = dp[i - 1][j] + 1;
                    } else if (grid[i][j] == 'W') {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            // down 下方 从下到上
            for (int i = rowLen - 2; i >= 0; i--) {
                for (int j = 0; j < lineLen; j++) {
                    if (grid[i][j] == 'E') {
                        dp[i][j] = dp[i + 1][j] + 1;
                    } else if (grid[i][j] == 'W') {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i + 1][j];
                    }
                }
            }
            // left 左方 从左到右
            for (int i = 0; i < rowLen; i++) {
                for (int j = 1; j < lineLen; j++) {
                    if (grid[i][j] == 'E') {
                        dp[i][j] = dp[i][j - 1] + 1;
                    } else if (grid[i][j] == 'W') {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
            // right 右方 从右到左
            for (int i = 0; i < rowLen; i++) {
                for (int j = lineLen - 2; j >= 0; j--) {
                    if (grid[i][j] == 'E') {
                        dp[i][j] = dp[i][j + 1] + 1;
                    } else if (grid[i][j] == 'W') {
                        dp[i][j] += 0;
                    } else {
                        dp[i][j] = dp[i][j + 1];
                    }
                }
            }

            int res = 0;
            for (int i = 0; i < rowLen; i++) {
                for (int j = 0; j < lineLen; j++) {
                    if (grid[i][j] == '0') {
                        res = Math.max(res, dp[i][j]);
                    }
                }
            }
            return res;
        }
        public int maxKilledEnemies(char[][] grid) {
            if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
                return 0;
            }
            int rowLen = grid.length;
            int lineLen = grid[0].length;
            // 初始化dp, 初始值
            int[][] dp = new int[rowLen][lineLen];
            int[][] directionDP = new int[rowLen][lineLen];

            // up 上方 从上到下
            for (int i = 0; i < rowLen; i++) {
                for (int j = 0; j < lineLen; j++) {
                    if (grid[i][j] == 'W') {
                        directionDP[i][j] = 0;
                        continue;
                    }
                    directionDP[i][j] = 0;
                    if (grid[i][j] == 'E') {
                        directionDP[i][j] = 1;
                    }
                    if (i > 0) {
                        directionDP[i][j] += directionDP[i - 1][j];
                    }
                    dp[i][j] += directionDP[i][j];
                }
            }
            // down 下方 从下到上
            for (int i = rowLen - 1; i >= 0; i--) {
                for (int j = 0; j < lineLen; j++) {
                    if (grid[i][j] == 'W') {
                        directionDP[i][j] = 0;
                        continue;
                    }
                    directionDP[i][j] = 0;
                    if (grid[i][j] == 'E') {
                        directionDP[i][j] = 1;
                    }
                    if (i < rowLen - 1) {
                        directionDP[i][j] += directionDP[i + 1][j];
                    }
                    dp[i][j] += directionDP[i][j];
                }
            }
            // left 左方 从左到右
            for (int i = 0; i < rowLen; i++) {
                for (int j = 0; j < lineLen; j++) {
                    if (grid[i][j] == 'W') {
                        directionDP[i][j] = 0;
                        continue;
                    }
                    directionDP[i][j] = 0;
                    if (grid[i][j] == 'E') {
                        directionDP[i][j] = 1;
                    }
                    if (j > 0) {
                        directionDP[i][j] += directionDP[i][j - 1];
                    }
                    dp[i][j] += directionDP[i][j];
                }
            }
            // right 右方 从右到左
            for (int i = 0; i < rowLen; i++) {
                for (int j = lineLen - 1; j >= 0; j--) {
                    if (grid[i][j] == 'W') {
                        directionDP[i][j] = 0;
                        continue;
                    }
                    directionDP[i][j] = 0;
                    if (grid[i][j] == 'E') {
                        directionDP[i][j] = 1;
                    }
                    if (j < lineLen - 1) {
                        directionDP[i][j] += directionDP[i][j + 1];
                    }
                    dp[i][j] += directionDP[i][j];
                }
            }

            int res = 0;
            for (int i = 0; i < rowLen; i++) {
                for (int j = 0; j < lineLen; j++) {
                    if (grid[i][j] == '0') {
                        res = Math.max(res, dp[i][j]);
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question553().new Solution().maxKilledEnemies(new char[][]{
                {'0', 'E', '0', '0'},
                {'E', '0', 'W', 'E'},
                {'0', 'E', '0', '0'}
        }));
    }
}
