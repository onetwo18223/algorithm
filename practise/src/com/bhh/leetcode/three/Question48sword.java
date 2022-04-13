package com.bhh.leetcode.three;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bhh
 * @description 最长不含重复字符的子字符串
 * @date Created in 2022-01-28 19:44
 * @modified By
 */
public class Question48sword {
    class Solution {
        /*
        滑动窗口 + Hash
        快指针for循环, 判断慢指针位置, 取长度
         */
        public int lengthOfLongestSubstring(String s) {
            if (s == null || "".equals(s)) {
                return 0;
            }
            Map<Character, Integer> map = new HashMap<>();
            int left = 0;
            int max = 0;
            for (int i = 0; i < s.length(); i++) {
                char currChar = s.charAt(i);
                if (map.containsKey(currChar)) {
                    // 获取左指针位置
                    left = Math.max(left, map.get(currChar) + 1);
                }
                max = Math.max(max, i - left + 1);
                map.put(currChar, i);
            }
            return max;
        }
    }
}
