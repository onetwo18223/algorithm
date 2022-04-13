package com.bhh.leetcode.three;

/**
 * @author bhh
 * @description 螺旋矩阵 II
 * @date Created in 2022-01-30 17:24
 * @modified By
 */
public class Question59hot100 {
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] res = new int[n][n];
            int num = 1;
            int left = 0, top = 0, right = n - 1, floor = n - 1;
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
                if (left > --right) {
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
                if (++left > right) {
                    break;
                }
            }
            return res;
        }
    }
}
