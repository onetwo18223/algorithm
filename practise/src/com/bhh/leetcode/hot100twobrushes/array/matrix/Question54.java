package com.bhh.leetcode.hot100twobrushes.array.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bhh
 * @description 螺旋矩阵
 * @date Created in 2022-01-27 12:12
 * @modified By
 */
public class Question54 {
    class Solution {
        /*
        以上左下右上的方式循环输出
         */
        public List<Integer> spiralOrder(int[][] matrix) {
            int rowLen = matrix.length;
            int lineLen = matrix[0].length;
            int top = 0, right = lineLen - 1, floor = rowLen - 1, left = 0;
            List<Integer> res = new ArrayList<>();
            int index = 0;
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
                if (--right < left) {
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
                if (right < ++left) {
                    break;
                }
            }
            return res;
        }
    }
}
