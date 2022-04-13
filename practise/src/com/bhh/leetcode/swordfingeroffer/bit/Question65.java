package com.bhh.leetcode.swordfingeroffer.bit;

/**
 * @author bhh
 * @description 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * @date Created in 2021-09-26 19:06
 * @modified By
 */
public class Question65 {
    class Solution {
        /*
        实现思路 : 加法使用 ^(不进位), 进位使用 (a & b) << 1
        循环直到, 进位为 0
         */
        public int add(int a, int b) {
            return a == 0 ? b : add((a & b) << 1, a ^ b);
        }
    }
}
