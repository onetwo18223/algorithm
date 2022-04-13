package com.bhh.leetcode.three;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bhh
 * @description 最长连续序列
 * @date Created in 2022-01-30 11:13
 * @modified By
 */
public class Question128hot100 {
    class Solution {
        /*
        使用 Hash 存储再遍历
        遍历时先判断元素前一个元素是否存在, 存在则continue;
        否则则一直判断 i + 1存在否, count++;
         */
        public int longestConsecutive(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                set.add(nums[i]);
            }
            int count = 0;
            int max = 0;
            for (Integer num : set) {
                if (set.contains(num - 1)) {
                    continue;
                }
                while (set.contains(num + 1)) {
                    num++;
                    count++;
                }
                max = Math.max(max, count);
                count = 1;
            }
            return max;
        }
    }
}
