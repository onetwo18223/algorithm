package com.bhh.leetcode.swordfingeroffertwobrushes.array;

/**
 * @author bhh
 * @description 求1+2+…+n
 * @date Created in 2022-01-20 14:44
 * @modified By
 */
public class Question64 {
    class Solution {
        /*
        不能使用循环, 使用递归
         */
        public int sumNums(int n) {
            boolean x = (n > 1) && (n += sumNums(n - 1)) > 0;
            return n;
        }
    }
}
