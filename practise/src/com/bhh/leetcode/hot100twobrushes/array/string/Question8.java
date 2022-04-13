package com.bhh.leetcode.hot100twobrushes.array.string;

/**
 * @author bhh
 * @description 字符串转换整数 (atoi)
 * @date Created in 2022-01-27 18:56
 * @modified By
 */
public class Question8 {
    class Solution {
        /*
        字符串转换为数字
        转换合法字符串
         */
        public int myAtoi(String s) {
            int len = s.length();
            char[] array = s.toCharArray();

            // 1.去除前置空格
            int index = 0;
            while (index < len && array[index] == ' ') {
                index++;
            }

            // 2. 排除全部是空格的情况
            if (index == len) {
                return 0;
            }

            // 3.设置正负标记
            int sign = 1;
            char tmp = array[index];
            if (tmp == '+') {
                index++;
            } else if(tmp == '-') {
                index++;
                sign = -1;
            }

            // 4.转换字符
            int res = 0;
            while (index < len) {
                char currChar = array[index];
                // 4.1 判断不合法情况
                // 4.1.1 不符合要求
                if (currChar > '9' || currChar < '0') {
                    break;
                }

                // 4.1.2 大小超出范围
                if (res > Integer.MAX_VALUE / 10 ||
                        (res == Integer.MAX_VALUE / 10 &&
                                (currChar - '0') > Integer.MAX_VALUE % 10)) {
                    return Integer.MAX_VALUE;
                }
                if (res < Integer.MIN_VALUE / 10 ||
                        (res == Integer.MIN_VALUE / 10 &&
                                -(currChar - '0') < Integer.MIN_VALUE % 10)) {
                    return Integer.MIN_VALUE;
                }

                // 正常情况
                res = res * 10 + sign * (currChar - '0');
                index++;
            }
            return res;
        }
    }
}
