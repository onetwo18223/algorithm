package com.bhh.leetcode.three;

/**
 * @author bhh
 * @description 整数反转
 * @date Created in 2022-02-01 14:00
 * @modified By
 */
public class Question7hot100 {
    class Solution {
        /*
        整数翻转使用数据 除以10再取余的 方式来解决
        符号要进行标记
         */
        public int reverse(int x) {
            int res = 0;
            while (x != 0) {
                if ((res > Integer.MAX_VALUE / 10 ||
                        (res == Integer.MAX_VALUE / 10 && x % 10 > Integer.MAX_VALUE % 10)) ||
                        (res < Integer.MIN_VALUE / 10 ||
                        (res == Integer.MIN_VALUE / 10 && x % 10 < Integer.MIN_VALUE % 10))) {
                    return 0;
                }
                res = res * 10 + x % 10;
                x /= 10;
            }
            return res;
        }
    }
}
