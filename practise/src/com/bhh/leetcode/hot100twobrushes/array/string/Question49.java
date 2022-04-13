package com.bhh.leetcode.hot100twobrushes.array.string;

import java.util.*;

/**
 * @author bhh
 * @description 字母异位词分组
 * @date Created in 2022-01-24 18:47
 * @modified By
 */
public class Question49 {
    class Solution {
        /*
        字母异位词类题目
        对String[] 中每一个String元素都进行排序
        然后以<String, List<String>>存储在HashMap中
        然后获取map的values集合
         */
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] array = str.toCharArray();
                // 排序
                Arrays.sort(array);
                String tmp = String.valueOf(array);
                // 如果map中不存在排序后的String
                List<String> list = map.getOrDefault(tmp, new ArrayList<>());
                list.add(str);
                map.put(tmp, list);
            }
            return new ArrayList<>(map.values());
        }
    }
}
