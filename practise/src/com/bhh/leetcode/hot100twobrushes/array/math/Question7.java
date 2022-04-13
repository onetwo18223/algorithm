package com.bhh.leetcode.hot100twobrushes.array.math;

import java.util.Arrays;

/**
 * @author bhh
 * @description 整数反转
 * @date Created in 2022-01-27 10:03
 * @modified By
 */
public class Question7 {
    class Solution {
        /*
        转换为字符串反转,
        首部跳过-号
        尾部跳过0
         */
        public int reverse(int x) {
            char[] array = String.valueOf(x).toCharArray();
            int left = 0;
            int right = array.length - 1;
            int end = array.length - 1;
            if (array[left] == '-') {
                left++;
            }
            while (right >= 0 && array[right] == '0') {
                right--;
                end = right;
            }
            while (left < right) {
                swap(array, left, right);
                left++;
                right--;
            }
            array = Arrays.copyOf(array, end + 1);
            try {
                return Integer.parseInt(new String(array));
            } catch (Exception e) {
                return 0;
            }
        }

        private void swap(char[] array, int left, int right) {
            char tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
        }

        // 更好的方法是直接取模尾数进行相加
        // 数学方法
        public int reverseBetter(int x) {
            // 反转数
            int ans = 0;
            while (x != 0) {
                // 最后一位的值
                int pop = x % 10;
                // 判断是否越界
                if (ans > Integer.MAX_VALUE / 10 ||
                        (ans == Integer.MAX_VALUE / 10 && pop > 7)) {
                    return 0;
                }
                if (ans < Integer.MIN_VALUE / 10 ||
                        (ans == Integer.MIN_VALUE / 10 && pop < -8)) {
                    return 0;
                }

                // 反转数相加
                ans = ans * 10 + pop;
                x /= 10;
            }
            return ans;
        }
    }
}
