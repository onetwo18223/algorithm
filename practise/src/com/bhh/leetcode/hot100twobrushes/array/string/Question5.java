package com.bhh.leetcode.hot100twobrushes.array.string;

import com.bhh.datastructure.heap.MaxHeap;

/**
 * @author bhh
 * @description 最长回文子串
 * @date Created in 2022-01-24 10:56
 * @modified By
 */
public class Question5 {
    class Solution {
        /*
        获取最长回文串
        先以中间线获取所有回文串
        记录最长回文串
         */
        public String longestPalindrome(String s) {
            int len = s.length();
            String maxString = "";
            for (int i = 0; i < len; i++) {
                int start = i;
                int end = i;
                while (start >= 0 && end < len
                        && s.charAt(start) == s.charAt(end)) {
                    if (maxString.length() < (end - start)) {
                        maxString = s.substring(start, end + 1);
                    }
                    start--;end++;
                }

                start = i;
                end = i + 1;
                while (start >= 0 && end < len
                        && s.charAt(start) == s.charAt(end)) {
                    if (maxString.length() < (end - start)) {
                        maxString = s.substring(start, end + 1);
                    }
                    start--;end++;
                }
            }
            return maxString;
        }
    }
}
