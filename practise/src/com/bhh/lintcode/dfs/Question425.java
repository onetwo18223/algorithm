package com.bhh.lintcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bhh
 * @description 电话号码的字母组合
 * @date Created in 2021-12-10 18:55
 * @modified By
 */
public class Question425 {

    public class Solution {
        public final String[] key = new String[]{
                "",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };

        /*
        组合类题目, 将参数digits中的对应的key进行组合
         */
        public List<String> letterCombinations(String digits) {
            if (digits == null || "".equals(digits)) {
                return new ArrayList<>();
            }
            List<String> strList = new ArrayList<>();
            dfs(digits, 0, "", strList);
            return strList;
        }

        private void dfs(String digits, int index, String str, List<String> strList) {
            if (index == digits.length()) {
                strList.add(str);
                return;
            }
            int digit = digits.charAt(index) - '0';
            for (int i = 0; i < key[digit].length(); i++) {
                dfs(digits, index + 1, str + key[digit].charAt(i), strList);
            }
        }
    }
}
