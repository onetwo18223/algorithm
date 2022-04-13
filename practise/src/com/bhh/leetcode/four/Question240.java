package com.bhh.leetcode.four;

/**
 * @author bhh
 * @description 搜索二维矩阵 II
 * @date Created in 2022-02-25 21:23
 * @modified By
 */
public class Question240 {
    class Solution {
        /*
        矩阵右上角和target比较
         */
        public boolean searchMatrix(int[][] matrix, int target) {
            int row = 0, line = matrix[0].length - 1;
            while (row < matrix.length && line >= 0) {
                int tmp = matrix[row][line];
                // 右上角元素较大, 去一列
                if (tmp > target) {
                    line--;
                }
                // 右上角元素较小, 去一行
                else if (tmp < target) {
                    row++;
                }
                // 元素相等
                else {
                    return true;
                }
            }
            return false;
        }
    }
}
