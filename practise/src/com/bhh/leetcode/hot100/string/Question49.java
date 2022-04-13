package com.bhh.leetcode.hot100.string;

import java.util.*;

/**
 * @author bhh
 * @description 字母异位词分组
 * @date Created in 2021-12-27 19:45
 * @modified By
 */
public class Question49 {
    class Solution {
        /*
        将strs中每个元素转换为char[], 然后排序,
        排序之后的元素放入(String str, List<String>)的HashMap中

        反思 : 想到了排序, 但是我想的是双指针检测重复, 也有想到HashMap, 但是最终未想到
        Map结构(以List<String> 为value没有想到)
         */
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String tmp = new String(chars);
                List<String> list = map.getOrDefault(tmp, new ArrayList<>());
                list.add(str);
                map.put(tmp, list);
            }
            return new ArrayList<>(map.values());
        }
    }
}
