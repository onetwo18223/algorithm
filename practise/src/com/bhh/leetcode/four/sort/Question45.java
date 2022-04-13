package com.bhh.leetcode.four.sort;

import java.util.Arrays;

/**
 * @author bhh
 * @description  把数组排成最小的数
 * @date Created in 2022-03-05 14:10
 * @modified By
 */
public class Question45 {
    class Solution {
        /*
        进行排序, 排序准则是 前一个元素 + 后一个元素, Arrays.sort() 比较
         */
        public String minNumber(int[] nums) {
            if (nums == null || nums.length == 0) {
                return "";
            }
            int len = nums.length;
            String[] strs = new String[len];
            for (int i = 0; i < len; i++) {
                strs[i] = String.valueOf(nums[i]);
            }
            Arrays.sort(strs, (str1, str2) ->
                    (str1 + str2).compareTo(str2 + str1));
            StringBuilder res = new StringBuilder();
            for (String str : strs) {
                res.append(str);
            }
            return res.toString();
        }
    }
}
