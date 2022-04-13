package com.bhh.leetcode.swordfingeroffertwobrushes.array.matrix;

/**
 * @author bhh
 * @description 顺时针打印矩阵
 * @date Created in 2022-01-11 22:38
 * @modified By
 */
public class Question29 {
    class Solution {
        /*
        矩阵 + 找规律/数学 题目
        遍历矩阵需要进行模拟, 设置四个边界, 然后从左到右, 从上到小, 从右到左, 从下到上依次遍历
        直到边界混乱
         */
        public int[] spiralOrder(int[][] matrix) {
            if(matrix == null || matrix.length == 0) {
                return new int[0];
            }
            // 左右上下
            int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
            // 索引
            int i = 0;
            int[] res = new int[(r + 1) * (b + 1)];
            while (true) {
                for (int j = l; j <= r; j++) {
                    res[i++] = matrix[t][j];
                }
                if (++t > b) {
                    break;
                }
                for (int j = t; j <= b; j++) {
                    res[i++] = matrix[j][r];
                }
                if (--r < l) {
                    break;
                }
                for (int j = r; j >= l; j--) {
                    res[i++] = matrix[b][j];
                }
                if (--b < t) {
                    break;
                }
                for (int j = b; j >= t; j--) {
                    res[i++] = matrix[j][l];
                }
                if (++l > r) {
                    break;
                }
            }
            return res;
        }
    }
}
