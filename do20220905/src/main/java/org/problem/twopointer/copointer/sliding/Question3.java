package org.problem.twopointer.copointer.sliding;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长不含重复字符的子字符串
 * <p>
 * 实现：使用滑动窗口，但是题目涉及到对‘重复’的需求，所以可以有HashMap参与
 * 窗口左端和窗口右端
 * 也就是使用HashMap获取到index充
 */
public class Question3 {
    class Solution1 {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) return 0;
            int max = 1;
            // 滑动窗口右指针
            int end = 0;
            Map<Character, Integer> map = new HashMap();
            // 从左向右遍历，寻找每个元素充当滑动窗口左指针时，不重复的字符串长度
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), i);
                end = Math.max(end, i + 1);
                while(end < s.length() && !map.containsKey(s.charAt(end))) {
                    map.put(s.charAt(end), end);
                    end++;
                }
                max = Math.max(max, end - i);
                map.remove(s.charAt(i));
            }
            return max;
        }
    }
    class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) return 0;
            int max = 1;
            // 滑动窗口左指针
            int left = 0;
            Map<Character, Integer> map = new HashMap();
            // 以当前元素作为滑动窗口右指针
            for (int i = 0; i < s.length(); i++) {
                // 判断窗口是否包含重复元素，包含则移动左指针
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
