package com.bhh.leetcode.swordfingeroffer.stackandqueue;

import java.util.HashMap;

/**
 * @author bhh
 * @description 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
 * s 只包含小写字母。
 * <p>
 * 示例 1:
 * 输入：s = "abaccdeff"
 * 输出：'b'
 * <p>
 * 示例 2:
 * 输入：s = ""
 * 输出：' '
 * @date Created in 2021-09-22 18:28
 * @modified By
 */
public class Question50 {
    class Solution {
        /*
        实现思路 : 使用HasMap存储元素, key存储元素, value存储出现次数
        遍历字符串存储, 若是元素已经存在则value : 次数++
            遍历完之后判断map若是含有value == 1则返回key, 若是没有则返回' '
            因为遍历map在存储时是按照hash值进行了排序, 而题目要求, 所以可以再次遍历字符串, 查找value = 1的情况

         */
        public char firstUniqChar(String s) {
            if (s == null || s.equals("")) {
                return ' ';
            }
            HashMap<String, Integer> map = new HashMap();
            for (int i = 0; i < s.length(); i++) {
                String str = String.valueOf(s.charAt(i));
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
            for (int i = 0; i < s.length(); i++) {
                String str = String.valueOf(s.charAt(i));
                if (map.get(str).equals(1)){
                    return str.charAt(0);
                }
            }
            return ' ';
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question50().new Solution().firstUniqChar("leetcode"));
    }
}
