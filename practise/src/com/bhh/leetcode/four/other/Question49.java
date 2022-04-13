package com.bhh.leetcode.four.other;

import java.util.*;

/**
 * @author bhh
 * @description 字母异位词分组
 * @date Created in 2022-03-04 20:40
 * @modified By
 */
public class Question49 {
    class Solution {
        /*
        字母异位词类型题目
        遍历, 排序, 添加到HashMap, 返回valueSet()
         */
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs == null || strs.length == 0) {
                return new ArrayList<>();
            }
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] tmp = str.toCharArray();
                Arrays.sort(tmp);
                List<String> list = map.getOrDefault(
                        String.valueOf(tmp), new ArrayList<String>());
                list.add(str);
                map.put(String.valueOf(tmp), list);
            }
            return new ArrayList<>(map.values());
        }
    }

    public static void main(String[] args) {
        for (List<String> list : new Question49().new Solution().groupAnagrams(
                new String[]{"eat", "tea", "tan", "ate", "nat", "bat"})) {
            System.out.println(list);
        }
    }
}
