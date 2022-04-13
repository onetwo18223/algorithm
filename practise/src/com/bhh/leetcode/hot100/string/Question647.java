package com.bhh.leetcode.hot100.string;

/**
 * @author bhh
 * @description 回文子串
 * @date Created in 2022-01-01 19:36
 * @modified By
 */
public class Question647 {
    class Solution {
        /*
        获取所有回文子串数量
        直接遍历获取中心点, 然后统计回文串数量
         */
        public int countSubstrings(String s) {
            if (s == null || "".equals(s)) {
                return 0;
            }
            int len = s.length();
            int start , end;
            int sum = 0;
            for (int i = 0; i < len; i++) {
                start = end = i;
                while (start >= 0 && end < len && s.charAt(start) == s.charAt(end)) {
                    sum++;
                    start--;
                    end++;
                }

                start = i;
                end = i + 1;
                while (start >= 0 && end < len && s.charAt(start) == s.charAt(end)) {
                    sum++;
                    start--;
                    end++;
                }
            }
            return sum;
        }
    }
}
