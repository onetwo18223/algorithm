package com.bhh.leetcode.headquarters.greedy;

/**
 * @author bhh
 * @description 判断子序列
 * @date Created in 2021-10-20 20:22
 * @modified By
 */
public class Question392 {
    class Solution {
        /*
        实现思路 : 从大的字符串中找小的
        遍历s
         */
        public boolean isSubsequence(String s, String t) {
            for (int i = 0, j = 0; i < s.length(); i++) {
                while (j < t.length() && s.charAt(i) != t.charAt(j)) {
                    j++;
                }
                if (j >= t.length()) {
                    return false;
                }
                j++;
            }
            return true;
        }
    }
}
