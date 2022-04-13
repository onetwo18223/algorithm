package com.bhh.leetcode.four;

/**
 * @author bhh
 * @description 最长回文子串
 * @date Created in 2022-02-22 21:20
 * @modified By
 */
public class Question5 {
    class Solution {
        /*
        中心扩展法获取所有的回文子串, 然后选择最大长度返回
         */
        String maxString = "";
        public String longestPalindrome(String s) {
            getAllPalindrome(s);
            return maxString;
        }

        private void getAllPalindrome(String str) {
            for (int i = 0; i < str.length(); i++) {
                int left = i;
                int right = i;
                while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
                    if (maxString.length() < right - left + 1) {
                        maxString = str.substring(left, right + 1);
                    }
                    left--;
                    right++;
                }

                left = i;
                right = i + 1;
                while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
                    if (maxString.length() < right - left + 1) {
                        maxString = str.substring(left, right + 1);
                    }
                    left--;
                    right++;
                }
            }
        }
    }
}
