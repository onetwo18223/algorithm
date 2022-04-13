package com.bhh.leetcode.three;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bhh
 * @description 螺旋矩阵
 * @date Created in 2022-01-30 13:03
 * @modified By
 */
public class Question54hot100 {
    class Solution {
        /*
        顺时针输出矩阵
        限定上下左右, 依次输出
         */
        public List<Integer> spiralOrder(int[][] matrix) {
            int top = 0, left = 0, floor = matrix.length - 1, right = matrix[0].length - 1;
            List<Integer> res = new ArrayList<>();
            while (true) {
                for (int i = left; i <= right; i++) {
                    res.add(matrix[top][i]);
                }
                if (++top > floor) {
                    break;
                }
                for (int i = top; i <= floor; i++) {
                    res.add(matrix[i][right]);
                }
                if (left > --right) {
                    break;
                }
                for (int i = right; i >= left; i--) {
                    res.add(matrix[floor][i]);
                }
                if (top > --floor) {
                    break;
                }
                for (int i = floor; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                if (++left > right) {
                    break;
                }
            }
            return res;
        }
    }
}
