package com.bhh.leetcode.three;

import java.util.*;

/**
 * @author bhh
 * @description 字母异位词分组
 * @date Created in 2022-01-30 10:43
 * @modified By
 */
public class Question49hot100 {
    class Solution {
        /*
        排序, 整合
         */
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] array = str.toCharArray();
                Arrays.sort(array);
                String key = String.valueOf(array);
                List<String> list = map.getOrDefault(key,
                        new ArrayList<>());
                list.add(str);
                map.put(key, list);
            }
            return new ArrayList<>(map.values());
        }
    }
}
