package com.bhh.leetcode.swordfingeroffer.array;

/**
 * @author bhh
 * @description 矩阵中的路径
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。
 * 如果word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 * <p>
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * @date Created in 2021-10-12 8:55
 * @modified By
 */
public class Question12 {
    class Solution {
        /*
        实现思路 : 先遍历一遍查询到word[0]的出发点,
        再从该出发点开始查询是否有word

        这个思想本身没有错误, 但是实现起来较为麻烦, 可以直接遍历二位数组,
        将元素都传递给递归方法, 有方法来进行直接判断, 实现更为方便快捷
         */
        public boolean exist(char[][] board, String word) {
            int row = board.length;
            int line = board[0].length;
            int k = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < line; j++) {
                    if(re(board, i, j, word, 0))
                      return true;
                }
            }
            return false;
        }

        private boolean re(char[][] board, int row, int line, String word, int index) {
            if (index >= word.length()) return true;
            if (board[row][line] != word.charAt(index)) {
                return false;
            }
            board[row][line] = '\0';
            boolean res =  re(board, (row + 1 < board.length ? row + 1 : row), line, word, index + 1) ||
                    re(board, (row - 1 >= 0 ? row - 1 : row), line, word, index + 1) ||
                    re(board, row, (line + 1 < board[0].length ? line + 1 : line), word, index + 1) ||
                    re(board, row, (line - 1 >= 0 ? line - 1 : line), word, index + 1);
            board[row][line] = word.charAt(index);
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question12().new Solution().exist(new char[][]{
                {'a', 'a'}
        }, "aaa"));
    }
}
