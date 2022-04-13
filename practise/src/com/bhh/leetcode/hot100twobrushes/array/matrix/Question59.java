package com.bhh.leetcode.hot100twobrushes.array.matrix;

/**
 * @author bhh
 * @description 螺旋矩阵 II
 * @date Created in 2022-01-27 14:03
 * @modified By
 */
public class Question59 {
    class Solution {
        /*
        螺旋矩阵是顺时针打印矩阵, 本题是生成矩阵
        如何生成?
            模拟遍历填数
         */
        public int[][] generateMatrix(int n) {
            int top = 0, floor = n - 1, right = n - 1, left = 0;
            int res[][] = new int[n][n];
            int num = 1;
            while (true) {
                for (int i = left; i <= right; i++) {
                    res[top][i] = num++;
                }
                if (++top > floor) {
                    break;
                }
                for (int i = top; i <= floor; i++) {
                    res[i][right] = num++;
                }
                if (--right < left) {
                    break;
                }
                for (int i = right; i >= left; i--) {
                    res[floor][i] = num++;
                }
                if (top > --floor) {
                    break;
                }
                for (int i = floor; i >= top; i--) {
                    res[i][left] = num++;
                }
                if (right < ++left) {
                    break;
                }
            }
            return res;
        }
    }

}
