package com.bhh.leetcode.hot100twobrushes.array.string;

/**
 * @author bhh
 * @description 反转字符串中的单词 III
 * @date Created in 2022-01-27 11:40
 * @modified By
 */
public class Question557 {
    class Solution {
        /*
        反转每个单词
        快慢指针获取每个单词
        以每个单词进行反转
         */
        public String reverseWords(String s) {
            if (s == null || "".equals(s)) {
                return "";
            }
            int left = 0, right = 0;
            char[] array = s.toCharArray();
            while (right < array.length) {
                // 结束 right越界或者是right == ' '
                while (right < array.length && array[right] != ' ') {
                    right++;
                }
                if (right <= array.length) {
                    swap(array, left, right - 1);
                    left = right + 1;
                    right++;
                }
            }
            return new String(array);
        }

        // 交换从left到right
        private void swap(char[] array, int left, int right) {
            while (left < right) {
                char tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
                left++;
                right--;
            }
        }
    }
}
