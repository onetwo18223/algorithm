package com.bhh.leetcode.hot100.string;

/**
 * @author bhh
 * @description 翻转字符串里的单词
 * @date Created in 2021-12-23 20:42
 * @modified By
 */
public class Question151 {
    class Solution {
        /*
        方法一 : 从后向前遍历参数s, 并使用到额外空间
        方法二 : 去除多余空格, 使用双指针进行反转, 再遍历获取空格之前的字符串再反转
         */
        public String reverseWordsM1(String s) {
            if (s == null || "".equals(s)) {
                return "";
            }
//            s = s.trim();
            // 去除前后多余空格
            int left = 0, right = s.length() - 1;
            while (s.charAt(left) == ' ') left++;
            while (s.charAt(right) == ' ') right--;

            StringBuilder strBuilder = new StringBuilder();
            int end = right + 1;
            for (int start = right; start >= left; start--) {
                if (s.charAt(start) != ' '){
                    continue;
                }
                if (s.charAt(start + 1) == ' ') {
                    end = start;
                    continue;
                }
                strBuilder.append(s.substring(start + 1, end) + " ");
                end = start;
            }
            strBuilder.append(s.substring(left, end));
            return strBuilder.toString();
        }

        public String reverseWordsM2(String s) {
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question151().new Solution().
                reverseWordsM1("  hello   world  "));
    }
}
