package com.bhh.leetcode.hot100twobrushes.dfs;

import java.util.List;

/**
 * @author bhh
 * @description 单词拆分
 * @date Created in 2022-01-28 9:36
 * @modified By
 */
public class Question139 {
    class Solution {
        /*
        方法一 : 使用 wordDict 内的集合进行拼接组合, 判断能否生成s
        这个办法会造成超时, 所以抛弃
        方法二 : 以字符串s为主体, dfs这个字符串,
            判断是否可以切割出各种情况在wordDict中, 思路接近于dp
         */
        public boolean wordBreak(String s, List<String> wordDict) {
            // 被访问过且为true : 1
            // 被访问过且为false : -1
            int[] visited = new int[s.length() + 1];
            return dfs(s, 0, wordDict, visited);
        }

        private boolean dfs(String str, int index, List<String> wordDict, int[] visited) {
            // index递归到了字符串末尾, 说明遍历完了, 返回true
            if (str.length() == index) {
                return true;
            }
            if (visited[index] == 1) {
                return true;
            } else if (visited[index] == -1) {
                return false;
            }
            for (int i = index; i < str.length(); i++) {
                // 切割判断是否存在在wordDict中
                String sub = str.substring(index, i + 1);
                if (wordDict.contains(sub) && dfs(str, i + 1, wordDict, visited)) {
                    visited[index] = 1;
                    return true;
                }
            }
            visited[index] = -1;
            return false;
        }
    }
}
