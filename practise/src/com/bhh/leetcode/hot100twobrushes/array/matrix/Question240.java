package com.bhh.leetcode.hot100twobrushes.array.matrix;

/**
 * @author bhh
 * @description 搜索二维矩阵 II
 * @date Created in 2022-01-22 20:48
 * @modified By
 */
public class Question240 {
    class Solution {
        /*
        方法一 : 逐行二分对比
        方法二 : 每次对比右上角, 若是小于target则删去一列, 大于则删去一行
         */
        public boolean searchMatrix(int[][] matrix, int target) {
            int rowLen = matrix.length;
            int lineLen = matrix[0].length;
            int row = 0, line = lineLen - 1;
            while (row >= 0 && row < rowLen &&
                    line >= 0 && line < lineLen) {
                if (target < matrix[row][line]) {
                    line--;
                } else if (target > matrix[row][line]) {
                    row++;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
}
