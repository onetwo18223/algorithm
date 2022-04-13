package com.bhh.leetcode.swordfingeroffer.string;

/**
 * @author bhh
 * @description 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
 * 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 * @date Created in 2021-09-15 13:45
 * @modified By
 */
public class Question17 {
    class Solution {
        /*
        实现思路 :
        首先要获取n是多少位, n % 10
        根据位数获取到对应位的最大数值
            对应位的最大值 = 10的高一位次方 - 1的值
         */
        public int[] printNumbers(int n) {
            int digits = n % 10;
            int max = 1;
            for (int i = 1; i <= digits; i++) {
                max *= 10;
            }
            max -= 1;
            int[] nums = new int[max];
            for (int i = 0; i < max; i++) {
                nums[i] = i + 1;
            }
            return nums;
        }
    }
}
