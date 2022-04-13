package com.bhh.leetcode.hot100twobrushes.array;

/**
 * @author bhh
 * @description 回文数
 * @date Created in 2022-01-27 14:19
 * @modified By
 */
public class Question9 {
    class Solution {
        /*
        方法一 : 转换为字符串, 再判断
        方法二 : 反转数再判断是否等于原值
         */
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            int cur = 0;
            int tmp = x;
            while (tmp != 0) {
                cur = cur * 10 + tmp % 10;
                tmp /= 10;
            }
            return cur == x;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question9().new Solution().isPalindrome(-121));
    }
}
