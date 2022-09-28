package org.problem.dfs.group;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合
 *
 * 实现：先建立数组进行比对
 */
public class Question17 {
    class Solution {

        final char[][] CHARS = new char[][]{
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
            if (digits == null || "".equals(digits)) return res;
            dfs(digits, 0, "", res);
            return res;
        }

        private void dfs(String digits, int index, String str, List<String> res) {
            if (index == digits.length()) {
                res.add(str);
                return;
            }
            int charIndex = digits.charAt(index) - '0';
            for (int i = 0; i < CHARS[charIndex].length; i++) {
                dfs(digits, index + 1, str + CHARS[charIndex][i], res);
                // 因为没有对参数值进行修改所以无需回溯
            }
        }
    }
}
