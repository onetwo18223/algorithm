package com.bhh.leetcode.swordfingeroffer.array;

/**
 * @author bhh
 * @description 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target=5，返回true。
 * <p>
 * 给定target=20，返回false。
 * @date Created in 2021-09-15 10:40
 * @modified By
 */
public class Question04 {
    class Solution {
        /*
        实现思路 :
        方法一 : 暴力解法
            时间复杂度 : O(nm)
        方法二 : 使用二分查找
            二分查找每一次都会获取到有序队列中中间大小的数值, 比较然后选取范围
            同理二维数组使用二分查找时, 也需要获取中间大小的数值来进行比较
                二维数组左上最小, 右下最大, 相对来说右上为中间值
                    选取右上为当前值,
                        如果当前值小于目标值, 则下移一行
                        如果当前值大于目标值, 则左移一列

            时间复杂度 : O(N+M)
         */
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            // 在数组中判空需要常在
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
                return false;
            }
            // i指什么? 一般是指行
            int i = 0;
            // j指列
            int j = matrix[0].length - 1;

            // 最大行 = matrix.length - 1
            // 最大列 = matrix[0].length - 1
            while (i < matrix.length && j >= 0){
                if (matrix[i][j] > target){
                    j--;
                }else if (matrix[i][j] < target){
                    i++;
                }else{
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        /*
        1 2
        3 4
        5 6
         */
        int[][] a = new int[][]{{1, 2}, {3, 4}, {5, 6}};
        System.out.println("a[0][0] = " + a[0][0]);
        System.out.println("a[0][1] = " + a[0][1]);
        System.out.println("a.length = " + a.length);
        System.out.println(a[a.length - 1][0]);
        System.out.println(a[0][a[0].length - 1]);

        // 测试
        Solution test = new Question04().new Solution();
        System.out.println(test.findNumberIn2DArray(a, 7));
        System.out.println(test.findNumberIn2DArray(a, 6));
        System.out.println(test.findNumberIn2DArray(a, 1));
        System.out.println(test.findNumberIn2DArray(a, 4));
    }
}
