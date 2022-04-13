package com.bhh.leetcode.swordfingeroffertwobrushes.array.matrix;

/**
 * @author bhh
 * @description 二维数组中的查找
 * @date Created in 2022-01-12 9:46
 * @modified By
 */
public class Question04 {
    class Solution {
        /*
        暴力解法就是遍历矩阵
        更优解是遍历每一行, 每行都进行二分
        更更优解是直接在矩阵上做二分
            每次都寻找右上角的数据和target作对比,
            若是大于target则去一行,
            若是小于target则去一列
         */
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }
            // start是指第一行, end是指最后一列
            int start = 0, end = matrix[0].length - 1;
            while (start < matrix.length && end >= 0) {
                if (matrix[start][end] == target) {
                    return true;
                }
                if (matrix[start][end] > target) {
                    end--;
                } else {
                    start++;
                }
            }
            return false;
        }
    }
}
