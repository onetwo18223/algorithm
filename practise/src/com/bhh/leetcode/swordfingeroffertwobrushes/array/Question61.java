package com.bhh.leetcode.swordfingeroffertwobrushes.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bhh
 * @description 扑克牌中的顺子
 * @date Created in 2022-01-12 20:34
 * @modified By
 */
public class Question61 {
    class Solution {
        /*
        直接获取最大值和最小值, 判断其间是否相差5
         */
        public boolean isStraight(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            Set<Integer> set = new HashSet<>();
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int num : nums) {
                if (num == 0) {
                    continue;
                }
                if (set.contains(num)) {
                    return false;
                }
                set.add(num);
                max = Math.max(max, num);
                min = Math.min(min, num);
            }
            return max - min + 1 >= 5;
        }
    }
}
