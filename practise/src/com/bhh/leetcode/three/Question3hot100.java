package com.bhh.leetcode.three;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bhh
 * @description 无重复字符的最长子串
 * @date Created in 2022-02-01 13:48
 * @modified By
 */
public class Question3hot100 {
    class Solution {
        /*
        Hash + 滑动窗口
         */
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int max = 0;
            int left = 0;
            for (int i = 0; i < s.length(); i++) {
                // 容器包含这个元素
                if (map.containsKey(s.charAt(i))) {
                    left = Math.max(left, map.get(s.charAt(i)) + 1);
                }
                map.put(s.charAt(i), i);
                max = Math.max(max, i - left + 1);
            }
            return max;
        }
    }
}
