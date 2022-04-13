package com.bhh.leetcode.hot100twobrushes.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bhh
 * @description 电话号码的字母组合
 * @date Created in 2022-01-24 12:48
 * @modified By
 */
public class Question17 {
    class Solution {
        /*
        求组合
         */
        char[][] nums = new char[][]{
                {},
                {},
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}
        };
        List<String> res = new ArrayList<>();
        public List<String> letterCombinations(String digits) {
            if (digits == null || "".equals(digits)) {
                return res;
            }
            dfs(digits, 0, new StringBuilder());
            return res;
        }

        private void dfs(String digits, int index, StringBuilder str) {
            if (index == digits.length()) {
                res.add(str.toString());
                return;
            }
            int num = digits.charAt(index) - '0';
            int len = nums[num].length;
            for (int i = 0; i < len; i++) {
                str.append(nums[num][i]);
                dfs(digits, index + 1, str);
                str.deleteCharAt(str.length()-1);
            }
        }
    }
}
