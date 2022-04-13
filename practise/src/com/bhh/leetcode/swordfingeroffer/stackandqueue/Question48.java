package com.bhh.leetcode.swordfingeroffer.stackandqueue;

import java.util.HashSet;

/**
 * @author bhh
 * @description 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 * 示例1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * @date Created in 2021-09-22 7:46
 * @modified By
 */
public class Question48 {
    class Solution {
        /*
        实现思路 :
        第一想法 : 滑动窗口记录最大值 + Hash判断重复
            具体实现 :  索引l = 0, 索引r = 1
            while循环(循环条件 : l <= r, r < s.length()), 让l++, r++,
                内嵌循环 while循环(循环条件 : true), 遍历 l 到 r , 添加数据到Hash, 若是碰到重复则退出(l++)
         */
        public int lengthOfLongestSubstring(String s) {
            if (s == null || "".equals(s)) {
                return 0;
            }
            if (s.length() == 1){
                return 1;
            }

            int l = 0, r = 1;
            int sum = 0;
            int ssum = 0;
            HashSet<String> hash = new HashSet<>();
            // 这个循环意义在于限制l
            while (l < r && l < s.length() && r < s.length()) {
                sum = 0;
                hash.clear();
                // 遍历l到r寻找最大值
                if (hash.add(String.valueOf(s.charAt(l)))) {
                    sum++;
                }
                while (r < s.length()) {
                    if (hash.add(String.valueOf(s.charAt(r)))) {
                        sum++;
                    } else {
                        break;
                    }
                    r++;
                }
                l++;
                r = l + 1;
                ssum = sum > ssum ? sum : ssum;
            }
            return ssum;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question48().new Solution().lengthOfLongestSubstring("bbbbbb"));
    }
}
