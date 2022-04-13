package com.bhh.leetcode.four.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bhh
 * @description 电话号码的字母组合
 * @date Created in 2022-03-03 21:11
 * @modified By
 */
public class Question17 {
    class Solution {
        /*
        组合题目, dfs
         */
        char[][] map = {
                {}, {}, {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}
        };
        public List<String> letterCombinations(String digits) {
            List<String> res = new ArrayList<>();
            if (digits == null || digits.equals("")) {
                return res;
            }
            dfs(digits, 0, "", res);
            return res;
        }

        private void dfs(String digits, int index, String str,
                         List<String> res) {
            if (str.length() == digits.length()) {
                res.add(str);
                return;
            }
            for (int i = index; i < digits.length(); i++) {
                // 获取字符串数字值
                int num = digits.charAt(i) - '0';
                // 遍历对应的元素数量
                for (int j = 0; j < map[num].length; j++) {
                    dfs(digits, i + 1, str + map[num][j], res);
                }
            }
        }
    }
}
