package com.bhh.leetcode.hot100twobrushes.array.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bhh
 * @description 无重复字符的最长子串
 * @date Created in 2022-01-24 9:29
 * @modified By
 */
public class Question3 {
    class Solution {
        /*
        使用Hash + 滑动窗口完成
         */
        public int lengthOfLongestSubstring(String s) {
            if (s == null || "".equals(s)) {
                return 0;
            }
            int left = 0;
            int max = 0;
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                left = Math.max(left, map.getOrDefault(String.valueOf(s.charAt(i)), 0) + 1);
                map.put(String.valueOf(s.charAt(i)), i);
                max = Math.max(max, i - left + 1);
            }
            return max;
        }
    }
}
