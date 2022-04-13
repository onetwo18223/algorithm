package com.bhh.leetcode.swordfingeroffertwobrushes.string;

/**
 * @author bhh
 * @description 替换空格
 * @date Created in 2022-01-15 18:54
 * @modified By
 */
public class Question5 {
    class Solution {
        public String replaceSpace(String s) {
            StringBuilder res = new StringBuilder();
            for(Character c : s.toCharArray())
            {
                if(c == ' ') res.append("%20");
                else res.append(c);
            }
            return res.toString();
        }
    }
}
