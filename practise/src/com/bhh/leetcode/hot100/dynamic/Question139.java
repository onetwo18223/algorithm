package com.bhh.leetcode.hot100.dynamic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bhh
 * @description 单词拆分
 * @date Created in 2022-01-02 19:16
 * @modified By
 */
public class Question139 {
    class Solution {
        /*
        求是否存在/DFS可以解决/确定是DP/ 好像是完全背包问题(不会)
        DFS + 记忆化/ DP
        使用dfs对wordDict进行组合, 判断能否组合出s字符串
        会造成超时
         */
        Map<String, Boolean> map = new HashMap();

        public boolean wordBreak(String s, List<String> wordDict) {
            if (s == null || "".equals(s) || wordDict.size() == 0) {
                return false;
            }
            return dfs(wordDict, s, "");
        }

        private boolean dfs(List<String> wordDict, String target,
                            String str) {
            if (map.containsKey(str)) {
                return map.get(str);
            }
            if (target.equals(str)) {
                return true;
            }
            if (str.length() > target.length()) {
                map.put(str, false);
                return false;
            }
            for (int i = 0; i < wordDict.size(); i++) {
                if (dfs(wordDict, target, str + wordDict.get(i))) {
                    return true;
                }
            }
            return false;
        }
    }
}
