package com.bhh.leetcode.swordfingeroffertwobrushes.string;

/**
 * @author bhh
 * @description 翻转单词顺序
 * @date Created in 2022-01-15 19:10
 * @modified By
 */
public class Question58_1 {
    class Solution {
        /*
        先处理俩边空格, 再处理多余空格
        利用双指针找单词
         */
        public String reverseWords(String s) {
            if ("".equals(s)) {
                return "";
            }
            // 处理俩边空格
            int left = 0;
            int right = s.length() - 1;
            // 结束不为 ' '
            while (s.charAt(left) == ' ') {
                left++;
            }
            // 结束不为 ' '
            while (s.charAt(right) == ' ') {
                right--;
            }
            s = s.substring(left, right + 1);
            // 处理字符串内容, 寻找单词
            left = s.length() - 1;
            right = s.length() - 1;
            StringBuilder res = new StringBuilder();
            // 结束 left == right
            while (left >= 0) {
                left = Math.min(right - 1, left);
                // 结束 right == s.length() 或者 left == ' '
                while (left >= 0 && s.charAt(left) != ' ') {
                    left--;
                }
                res.append(s.substring(left + 1, right + 1) + " ");
                right = left;
                // 结束 ... 或者 right != ' '
                while (right >= 0 && s.charAt(right) == ' ') {
                    right--;
                }
            }
            // 结尾会多一个空格, 去除
            return res.substring(0, res.length() - 1);
        }
    }
}
