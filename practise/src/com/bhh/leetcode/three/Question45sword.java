package com.bhh.leetcode.three;

import java.util.Arrays;

/**
 * @author bhh
 * @description 把数组排成最小的数
 * @date Created in 2022-01-29 11:11
 * @modified By
 */
public class Question45sword {
    class Solution {
        /*
        本质是一道排序题目
        排序是由俩数相加的值来决定
        不是直接相加而是拼接, 使用String可以直接完成拼接, 所以先转换为String
         */
        public String minNumber(int[] nums) {
            String[] strs = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                strs[i] = String.valueOf(nums[i]);
            }
            // 排序
            Arrays.sort(strs, (str1, str2) -> (str1 + str2).compareTo(str2 + str1));
            StringBuilder strBuilder = new StringBuilder();
            for (String str : strs) {
                strBuilder.append(str);
            }
            return strBuilder.toString();

        }
    }
}
