package com.bhh.leetcode.three;

/**
 * @author bhh
 * @description  最长回文子串
 * @date Created in 2022-02-01 13:30
 * @modified By
 */
public class Question5hot100 {
    class Solution {
        /*
        中心扩展法求回文串, 获取最长串
         */
        public String longestPalindrome(String s) {
            String maxString = "";
            for (int i = 0; i < s.length(); i++) {
                int left = i;
                int right = i;
                while (left >= 0 && right < s.length() &&
                        s.charAt(left) == s.charAt(right)) {
                    if (maxString.length() < right - left + 1) {
                        maxString = s.substring(left, right + 1);
                    }
                    left--;
                    right++;
                }

                left = i;
                right = i + 1;
                while (left >= 0 && right < s.length() &&
                        s.charAt(left) == s.charAt(right)) {
                    if (maxString.length() < right - left + 1) {
                        maxString = s.substring(left, right + 1);
                    }
                    left--;
                    right++;
                }
            }
            return maxString;
        }
    }
}
