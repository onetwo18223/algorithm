package com.bhh.leetcode.swordfingeroffertwobrushes.dfs;

import java.util.*;

/**
 * @author bhh
 * @description 字符串的排列
 * @date Created in 2022-01-15 16:07
 * @modified By
 */
public class Question38 {
    class Solution {
        /*
        求排列 dfs + visited[]剪枝
         */
        public String[] permutation(String s) {
            HashSet<String> res = new HashSet<>();
            if (s == null || "".equals(s)) {
                return new String[0];
            }
            char[] array = s.toCharArray();
            boolean[] visited = new boolean[array.length];
            for (int i = 0; i < array.length; i++) {
                visited[i] = true;
                dfs(array, visited, "" + array[i], res);
                visited[i] = false;
            }
            return res.toArray(new String[0]);
        }

        private void dfs(char[] array, boolean[] visited, String str, Set<String> res) {
            if (array.length == str.length()) {
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
