package com.bhh.leetcode.four;

/**
 * @author bhh
 * @description 旋转图像
 * @date Created in 2022-02-25 21:34
 * @modified By
 */
public class Question48 {
    class Solution {
        /*
        矩阵旋转问题, 如何水平翻转, 如何垂直翻转, 如何延对角线翻转
        旋转90是水平翻转再对角线翻转
         */
        public void rotate(int[][] matrix) {
            int rowLen = matrix.length;
            int lineLen = matrix[0].length;
            // 水平翻转
            for (int i = 0; i < rowLen / 2; i++) {
                for (int j = 0; j < lineLen; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[rowLen - i - 1][j];
                    matrix[rowLen - i - 1][j] = tmp;
                }
            }

            // 对角线翻转
            for (int i = 0; i < rowLen; i++) {
                for (int j = 0; j < i; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }
        }
    }
}
