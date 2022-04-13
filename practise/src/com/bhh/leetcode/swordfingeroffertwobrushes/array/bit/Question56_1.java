package com.bhh.leetcode.swordfingeroffertwobrushes.array.bit;

/**
 * @author bhh
 * @description  数组中数字出现的次数
 * @date Created in 2022-01-14 20:44
 * @modified By
 */
public class Question56_1 {
    class Solution {
        /*
        一个数字出现一次时, 可直接异或获取值
        俩个数字出现一次时, 我们需要进行分辨, 先异或, 再根据1的位置分辨俩个数
         */
        public int[] singleNumbers(int[] nums) {
            int tmp = 0;
            for (int num : nums) {
                tmp ^= num;
            }
            // 获取最后一个1的位置
            tmp &= (-tmp);
            int[] res = new int[2];
            for (int num : nums) {
                // 三位运算符中0 1的位置可互换
                res[(num | tmp) == num ? 0 : 1] ^= num;
            }
            return res;
        }
    }
}
