package com.bhh.leetcode.hot100.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bhh
 * @description 电话号码的字母组合
 * @date Created in 2021-12-27 15:38
 * @modified By
 */
public class Question17 {
    class Solution {
        /*
        比较经典的DFS题目, 我想想该怎么做
         */
        private final char[][] CHARS = new char[][]{
                {}, {},
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'},
        };

        public List<String> letterCombinations(String digits) {
            List<String> res = new ArrayList<>();
            if (digits == null || "".equals(digits)) {
                return null;
            }
            dfs(digits, 0, "", res);
            return res;
        }

        private void dfs(String digits, int index, String str, List<String> res) {
            if (index == digits.length()) {
                res.add(str);
                return;
            }
            int charsIndex = digits.charAt(index) - '0';
            for (int i = 0; i < CHARS[charsIndex].length; i++) {
                dfs(digits, index + 1, str + CHARS[charsIndex][i], res);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question17().
                new Solution().letterCombinations("23"));
    }
}
