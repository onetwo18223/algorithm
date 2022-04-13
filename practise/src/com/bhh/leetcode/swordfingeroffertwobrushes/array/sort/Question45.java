package com.bhh.leetcode.swordfingeroffertwobrushes.array.sort;

import java.util.Arrays;

/**
 * @author bhh
 * @description 把数组排成最小的数
 * @date Created in 2022-01-19 13:31
 * @modified By
 */
public class Question45 {
    class Solution {
        /*
        此题求拼接起来的最小数字，本质上是一个排序问题。
        设数组 nums 中任意两数字的字符串为 x 和 y ，则规定 排序判断规则 为：

        若拼接字符串 x + y > y + x ，则 x “大于” y ；
        反之，若 x + y < y + x ，则 x “小于” y ；
        x “小于” y 代表：排序完成后，数组中 x 应在 y 左边；“大于” 则反之。
         */
        public String minNumber(int[] nums) {
            String[] strs = new String[nums.length];
            for(int i = 0; i < nums.length; i++)
                strs[i] = String.valueOf(nums[i]);
            Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
            StringBuilder res = new StringBuilder();
            for(String s : strs)
                res.append(s);
            return res.toString();
        }
    }
}
