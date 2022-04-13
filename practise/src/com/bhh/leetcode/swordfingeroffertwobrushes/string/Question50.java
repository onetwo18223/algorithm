package com.bhh.leetcode.swordfingeroffertwobrushes.string;

/**
 * @author bhh
 * @description 第一个只出现一次的字符
 * @date Created in 2022-01-15 19:03
 * @modified By
 */
public class Question50 {
    class Solution {
        /*
        使用HashMap或是字典完成
         */
        public char firstUniqChar(String s) {
            if (s == null || "".equals(s)) {
                return ' ';
            }
            // 创建 a-z 的字典
            int[] dic = new int[26];
            for (int i = 0; i < s.length(); i++) {
                dic[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < s.length(); i++) {
                if (dic[s.charAt(i) - 'a'] == 1) {
                    return s.charAt(i);
                }
            }
            return ' ';
        }
    }
}
