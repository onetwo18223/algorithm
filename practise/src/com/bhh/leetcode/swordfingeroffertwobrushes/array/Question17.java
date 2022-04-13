package com.bhh.leetcode.swordfingeroffertwobrushes.array;

/**
 * @author bhh
 * @description 打印从1到最大的n位数
 * @date Created in 2022-01-19 13:28
 * @modified By
 */
public class Question17 {
    class Solution {
        /*
        就是获取最大值然后写入
         */
        public int[] printNumbers(int n) {
            int num = 1;
            while(n > 0) {
                num *= 10;
                n--;
            }
            num--;
            int[] array = new int[num];
            for (int i = 1; i < num + 1; i++) {
                array[i - 1] = i;
            }
            return array;
        }
    }
}
