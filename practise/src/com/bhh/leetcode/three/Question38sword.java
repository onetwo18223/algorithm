package com.bhh.leetcode.three;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bhh
 * @description 字符串的排列
 * @date Created in 2022-01-28 20:43
 * @modified By
 */
public class Question38sword {
    class Solution {
        /*
        排列问题 dfs + visited 剪枝
         */
        public String[] permutation(String s) {
            char[] array = s.toCharArray();
            boolean[] visited = new boolean[s.length()];
            Set<String> res = new HashSet<>();
            dfs(array, visited, "", res);
            return res.toArray(new String[]{});
        }

        private void dfs(char[] array, boolean[] visited, String str, Set<String> res) {
            if (str.length() == array.length) {
                res.add(str);
                return;
            }
            for (int i = 0; i < array.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(array, visited, str + array[i], res);
                    visited[i] = false;
                }
            }
        }
    }
}
