package com.bhh.leetcode.hot100twobrushes.array.matrix;

/**
 * @author bhh
 * @description 旋转图像
 * @date Created in 2022-01-21 20:28
 * @modified By
 */
public class Question48 {
    class Solution {
        /*
        方法一 : 找规律
        方法二 : 找规律, 水平翻转 + 对角翻转
         */
        public void rotate(int[][] matrix) {
            int n = matrix.length;
//            // 水平翻转
//            for (int i = 0; i < n / 2; i++) {
//                for (int j = 0; j < n; j++) {
//                    int temp = matrix[i][j];
//                    matrix[i][j] = matrix[n - i - 1][j];
//                    matrix[n - i - 1][j] = temp;
//                }
//            }
//            // 主对角线翻转
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < i; j++) {
//                    int temp = matrix[i][j];
//                    matrix[i][j] = matrix[j][i];
//                    matrix[j][i] = temp;
//                }
//            }

            // 垂直翻转
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n / 2; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[i][n - j - 1];
                    matrix[i][n - j - 1] = tmp;
                }
            }

            // 副对角线翻转
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0, k = n - i - 1; j < n - i - 1; j++, k--) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[i + k][j + k];
                    matrix[i + k][j + k] = tmp;
                }
            }

        }
    }
}
