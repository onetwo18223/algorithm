package com.bhh.leetcode.swordfingeroffertwobrushes.string;

/**
 * @author bhh
 * @description 左旋转字符串
 * @date Created in 2022-01-15 19:41
 * @modified By
 */
public class Question58_2 {
    class Solution {
        public String reverseLeftWords(String s, int n) {
            StringBuilder res = new StringBuilder();
            for(int i = n; i < s.length(); i++)
                res.append(s.charAt(i));
            for(int i = 0; i < n; i++)
                res.append(s.charAt(i));
            return res.toString();
        }
    }
}
