package com.bhh.leetcode.three;

/**
 * @author bhh
 * @description 字符串转换整数 (atoi)
 * @date Created in 2022-02-01 16:33
 * @modified By
 */
public class Question8hot100 {
    class Solution {
        /*
        多情况处理
        首位是空格, 则去除空格
        去除之后, 如果有符号, 则记录符号(-,+)
        如果首位是字符, 则return 0
        记录合法数字
        如果值大于范围, 则返回边界值
         */
        public int myAtoi(String s) {
            if (s == null || "".equals(s)) {
                return 0;
            }
            int left = 0;
            while (left < s.length() && s.charAt(left) == ' ') {
                left++;
            }
            // 字符串全空
            if (left == s.length()) {
                return 0;
            }
            int sign = 1;
            if (s.charAt(left) == '-') {
                sign = -1;
                left++;
            } else if (s.charAt(left) == '+') {
                left++;
            }
            int res = 0;
            while (left < s.length()){
                char tmp = s.charAt(left);
                if (!(s.charAt(left) >= '0' && s.charAt(left) <= '9')) {
                    break;
                }
                if (res > Integer.MAX_VALUE / 10 ||
                        (res == Integer.MAX_VALUE / 10 &&
                                tmp - '0' > Integer.MAX_VALUE % 10)) {
                    return Integer.MAX_VALUE;
                }
                if (res < Integer.MIN_VALUE / 10 ||
                        (res == Integer.MIN_VALUE / 10 &&
                                -(tmp - '0') < Integer.MIN_VALUE % 10)) {
                    return Integer.MIN_VALUE;
                }
                res = res * 10 + (tmp - '0') * sign;
                left++;
            }
            return res;
        }
    }
}
