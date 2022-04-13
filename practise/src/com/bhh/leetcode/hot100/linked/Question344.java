package com.bhh.leetcode.hot100.linked;

/**
 * @author bhh
 * @description 反转字符串
 * @date Created in 2021-12-23 16:59
 * @modified By
 */
public class Question344 {
    class Solution {
        /*
        对字符串进行原地翻转
        Hello
        olleH
        如何使用相向双指针?
        这道题是要求翻转 指向(next)(这道题是翻转字符串, tm不是翻转链表)
        不使用栈, 就需要使用双指针
         */
        public void reverseString(char[] s) {
            if (s == null) {
                return;
            }
            int start = 0, end = s.length - 1;
            // 结束条件为 start == end
            while (start < end) {
                char temp = s[start];
                s[start] = s[end];
                s[end] = temp;
                start++;end--;
            }
        }
    }
}
