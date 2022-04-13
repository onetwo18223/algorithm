package com.bhh.leetcode.hot100twobrushes.array.string;

/**
 * @author bhh
 * @description 回文子串
 * @date Created in 2022-01-24 11:22
 * @modified By
 */
public class Question647 {
    class Solution {
        /*
        中心扩展法, 获取所有的子串, 进行总数相加
         */
        public int countSubstrings(String s) {
            int count = 0;
            int len = s.length();
            for (int i = 0; i < len; i++) {
                int start = i;
                int end = i;
                while (start >= 0 && end < len
                        && s.charAt(start) == s.charAt(end)) {
                    count++;
                    start--;
                    end++;
                }

                start = i;
                end = i + 1;
                while (start >= 0 && end < len
                        && s.charAt(start) == s.charAt(end)) {
                    count++;
                    start--;
                    end++;
                }
            }
            return count;
        }
    }
}
