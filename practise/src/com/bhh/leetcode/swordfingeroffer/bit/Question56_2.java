package com.bhh.leetcode.swordfingeroffer.bit;

/**
 * @author bhh
 * @description 数组中数字出现的次数 II
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。
 * 请找出那个只出现一次的数字。
 * @date Created in 2021-09-26 18:53
 * @modified By
 */
public class Question56_2 {
    class Solution {
        /*
        实现思路 : 不同于出现俩次, 无法通过异或来完成消除获取值
        可以通过记录二进制中出现1的位数来记录二进制
        记录数组中位出现1的次数, 因为不能超过2, 所以需要除以3
        一位不足以表示状态, 使用俩位完成
        00 -> 01 -> 10 -> 00
        参数中一位 用 俩位 来描述状态
        two one

        如何动态变化?
        one :
        if(two == 1)
            one = 0;
        if(two == 0)
            if(n == 0)
                one = one;
            if(n == 1)
                one = ~one;
        简化 : one = one ^ n & ~two
        two类似

        将一位应用到三十二位同理

        因为数值会出现三次, 所以不会出现 10 状态, 所以只需要返回one即可
         */
        public int singleNumber(int[] nums) {
            int ones = 0, twos = 0;
            for (int num : nums) {
                ones = ones ^ num & ~twos;
                twos = twos ^ num & ~ones;
            }
            return ones;
        }
    }
}
