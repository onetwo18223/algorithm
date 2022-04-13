package com.bhh.leetcode.swordfingeroffer.array;

import java.util.Arrays;

/**
 * @author bhh
 * @description 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * 输入：matrix =[[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * @date Created in 2021-09-15 14:48
 * @modified By
 */
public class Question29 {
    class Solution {
        /*
        实现思路 :
        标记现在最小层是多少行minRow, 多少列minList, 最大层是多少行maxRow, 多少列maxList,
        循环输出, 当行数(大-小)和列数都等于1, 停止
            循环输出 : i(行),j(列)索引递增输出,
            当i == maxRow时, 转向, 行不变输出列
            当j == maxList时, 转向 , 列不变输出行

         */
        public int[] spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return new int[]{};
            }

            int minRow = 0, minList = 0;
            int maxRow = matrix.length - 1, maxList = matrix[0].length - 1;

            int[] nums = new int[(maxRow + 1) * (maxList + 1)];
            int i = 0;

            // 进行循环. 每一圈一次循环
            // 三种情况被刨除 :
            // minRow == maxRow 同行输出列即可
            // minList == maxList 同列输出行即可
            // minRow == maxRow && minList == maxList 输出中心点
//            while (minRow != maxRow && minList != maxList) {
            while (true){
                // 横 (行不变, 最小行)
                for (int k = minList; k <= maxList; k++) {
//                    System.out.println(matrix[minRow][k]);
                    nums[i++] = matrix[minRow][k];
                }
                minRow++;
                if (minRow>maxRow){
                    break;
                }
                // 竖 (列不变, 最大列)
                for (int k = minRow; k <= maxRow; k++) {
//                    System.out.println(matrix[k][maxList]);
                    nums[i++] = matrix[k][maxList];
                }
                maxList--;
                if (minList>maxList){
                    break;
                }
                // 倒横 (行不变, 最大行)
                for (int k = maxList; k >= minList; k--) {
//                    System.out.println(matrix[maxRow][k]);
                    nums[i++] = matrix[maxRow][k];
                }
                maxRow--;
                if (minRow>maxRow){
                    break;
                }
                // 倒竖 (列不变, 最小列)
                for (int k = maxRow; k >= minRow; k--) {
//                    System.out.println(matrix[k][minList]);
                    nums[i++] = matrix[k][minList];
                }
                minList++;
                if (minList>maxList){
                    break;
                }
            }

//            if (minRow == maxRow && minList == maxList) {
////                System.out.println(matrix[maxRow][maxList]);
//                nums[i++] = matrix[maxRow][maxList];
//            } else if (minRow == maxRow) {
//                for (int j = minList; j <= maxList; j++) {
////                    System.out.println(matrix[minRow][i]);
//                    nums[i++] = matrix[minRow][j];
//                }
//            } else if (minList == maxList) {
//                for (int j = minRow; j <= maxRow; j++) {
////                    System.out.println(matrix[i][minList]);
//                    nums[i++] = matrix[j][minList];
//                }
//            }

            return nums;
        }
    }

    public static void main(String[] args) {
        /*
        1 2  3  4
        5 6  7  8
        9 10 11 12
         */
        Arrays.stream(new Question29().new Solution().spiralOrder(new int[][]{
                {1,2},{3,4}
        })).forEach(System.out::println);
    }
}
