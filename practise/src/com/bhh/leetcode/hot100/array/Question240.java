package com.bhh.leetcode.hot100.array;

/**
 * @author bhh
 * @description 搜索二维矩阵 II
 * @date Created in 2021-12-21 22:33
 * @modified By
 */
public class Question240 {
    class Solution {
        /*
        二维矩阵中的二分搜索
        每行的元素从左到右升序排列。
        每列的元素从上到下升序排列。
         */
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0
                    || matrix[0] == null || matrix[0].length == 0) {
                return false;
            }
            return binarySearch(matrix, target);
        }

        /*
        错误解法, 写的有点过于繁琐了, 因为是指向右上角的坐标, 所以不需要start, end,
            只需要右上角的row和col即可
            而且解法出现错误, 应当是
                当target > matrix[row][col]时, 去掉行, row++
                当target < matrix[row][col]时, 去掉列, col--

         */
        private boolean binarySearchError(int[][] matrix, int target) {
            int startRow = 0, startLine = 0;
            int endRow = matrix.length - 1;
            int endLine = matrix[0].length - 1;
            while (startLine < endLine) {
                int mid = matrix[startRow][endLine];
                if (target == mid) {
                    return true;
                } else if (target > mid) {
                    startLine = endLine;
                } else {
                    endLine--;
                }
            }
            while (startRow + 1 < endRow) {
                int mid = startRow + (endRow - startRow) / 2;
                if (target == matrix[mid][startLine]) {
                    return true;
                } else if (target > matrix[mid][startLine]) {
                    startRow = mid;
                } else {
                    endRow = mid;
                }
            }
            if (matrix[startRow][startLine] == target
                    || matrix[endRow][startLine] == target) {
                return true;
            }
            return false;
        }

        /*
        当target > matrix[row][col]时, 去掉行, row++
        当target < matrix[row][col]时, 去掉列, col--
         */
        private boolean binarySearch(int[][] matrix, int target) {
            int row = 0;
            int col = matrix[0].length - 1;
            while (row < matrix.length && col >= 0) {
                if (target == matrix[row][col]) {
                    return true;
                }
                // 去掉行
                else if (target > matrix[row][col]) {
                    row++;
                }
                // 去掉列
                else {
                    col--;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question240().new Solution().searchMatrix(new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        }, 19));
    }
}
