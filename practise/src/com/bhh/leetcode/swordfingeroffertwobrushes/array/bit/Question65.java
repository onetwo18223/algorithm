package com.bhh.leetcode.swordfingeroffertwobrushes.array.bit;

/**
 * @author bhh
 * @description 不用加减乘除做加法
 * @date Created in 2022-01-14 21:27
 * @modified By
 */
public class Question65 {
    class Solution {
        /*
        使用 ^ 来充当不进位的加法,
        进位使用 & 和 <<
         */
        public int add(int a, int b) {

            while (b != 0) {
                int c = (a & b) << 1; // 进位
                a = a ^ b;// 不进位和
                b = c;
            }
            return a;
        }
    }
}
