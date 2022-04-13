package com.bhh.leetcode.three;

import java.util.List;

/**
 * @author bhh
 * @description 单词拆分
 * @date Created in 2022-02-02 15:10
 * @modified By
 */
public class Question139hot100 {
    class Solution {
        /*
        使用dfs实现, 但是需要配合使用visited[]的剪枝实现
        遍历s的每个元素, 将其切割, 判断该字符串是否存在于集合 &&
            另一部分是否同样存在于集合
        使用visited[] 存储结果
         */
        public boolean wordBreak(String s, List<String> wordDict) {
            int[] visited = new int[s.length() + 1];
            return dfs(s, wordDict, 0, visited);
        }

        private boolean dfs(String s, List<String> wordDict, int index, int[] visited) {
            if (index > s.length()) {
                return false;
            }
            if (index == s.length()) {
                return true;
            }

            if (visited[index] == 1) {
                return true;
            } else if (visited[index] == -1) {
                return false;
            }

            for (int i = index; i < s.length(); i++) {
                String str = s.substring(index, i + 1);
                if (wordDict.contains(str) && dfs(s, wordDict, i + 1, visited)) {
                    visited[i + 1] = 1;
                    return true;
                }
            }
            visited[index] = -1;
            return false;
        }
    }
}
