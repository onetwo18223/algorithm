package com.bhh.leetcode.swordfingeroffertwobrushes.array.bit;

/**
 * @author bhh
 * @description 数组中数字出现的次数 II
 * @date Created in 2022-01-14 21:09
 * @modified By
 */
public class Question56_2 {
    class Solution {
        /*
        出现俩次可以直接使用异或,
        可以发现nums各个元素相加每一位取余3可以获得那一个元素
        那我们就可以通过表示每一位相加取余3的情况来获取值

        因为取余3的值有0,1,2, 但是通过二进制表示就是
        00, 01, 10
        转换公式就是
        one = one ^ num & ~two;
        two = two ^ num & ~one;
        返回值是one, 因为数组中都是出现一次或者是三次的情况
         */
        public int singleNumber(int[] nums) {
            int one = 0, two = 0;
            for (int num : nums) {
                one = one ^ num & ~two;
                two = two ^ num & ~one;
            }
            return one;
        }
    }
}
