package com.bhh.leetcode.hot100.array;

/**
 * @author bhh
 * @description 旋转图像
 * @date Created in 2021-12-21 13:34
 * @modified By
 */
public class Question48 {
    class Solution {
        /*
        原地修改二维数组
        二维数组的逆时针和顺时针旋转, 都可以由 水平翻转/列翻转 + 对角线翻转实现
        水平翻转/列翻转 到 对角线 是正确位置, 然后翻转对角线即可
         */
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            // 水平翻转
            for (int i = 0; i < n / 2; ++i) {
                for (int j = 0; j < n; ++j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n - i - 1][j];
                    matrix[n - i - 1][j] = temp;
                }
            }
            // 主对角线翻转
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < i; ++j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }
}
